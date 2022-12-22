package com.example.a02;

import jakarta.persistence.Column;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import static java.lang.Math.toIntExact;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController {


    /** -- ORGANISATION -- **/
    private OrganisationResult selectedOrganisation;
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML
    private Button organisationHinzufuegenButton;

    private ObservableList<OrganisationResult> organisationList = FXCollections.observableArrayList();

    @FXML
    private TableView<OrganisationResult> organisationTableView;

    @FXML
    private TableColumn<OrganisationResult, String> organisationsNameCol;

    @FXML
    private TableColumn<OrganisationResult, String> anzahlAnsprechpartnerCol;

    @FXML
    void onOrganisationHinzuefuegenClick(ActionEvent event) {
        AddOrganisationDialog.show();
        updateAll();
    }

    /** -- ANSPRECHPARTNER -- **/

    private Ansprechpartner selectedAnsprechpartner;


    private ObservableList<Ansprechpartner> ansprechparterList = FXCollections.observableArrayList();

    @FXML
    private TableView<Ansprechpartner> ansprechpartnerTableView;

    @FXML
    private TableColumn<Ansprechpartner, String> ansprechpartnerVornameCol;

    @FXML
    private TableColumn<Ansprechpartner, String> ansprechpartnerNachnameCol;

    @FXML
    private TableColumn<Ansprechpartner, String> ansprechpartnerEmailCol;

    @FXML
    private TableColumn<Ansprechpartner, String> ansprechpartnerOrganisationCol;


    @FXML
    void onAnsprechpartnerHinzufuegenClick(ActionEvent event) {
        AddAnsprechpartnerDialog.show();
        updateAll();
    }

    void updateAnsprechpartnerTable() {
        EntityManager entityManager = EntityManagerFactorySingleton.getEntityManager();
        // get all ansprechpartner from the database
        List<Ansprechpartner> ansprechpartnerList = entityManager.createQuery("SELECT a FROM Ansprechpartner a", Ansprechpartner.class).getResultList();
        // clear the table
        ansprechpartnerTableView.getItems().clear();

        // add all ansprechpartner to the table
        ansprechpartnerTableView.getItems().addAll(ansprechpartnerList);
        entityManager.clear();

        ansprechpartnerVornameCol.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper(cellData.getValue().getVorname()));

        ansprechpartnerNachnameCol.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper(cellData.getValue().getNachname()));

        ansprechpartnerEmailCol.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper(cellData.getValue().getEmail()));

        ansprechpartnerOrganisationCol.setCellValueFactory(cellData -> {
            //Organisation currentOrg = cellData.getValue().getOrganisation();
            //System.out.println(currentOrg.getName());

            return new ReadOnlyObjectWrapper(cellData.getValue().getOrganisation().getName());
        });

        entityManager.clear();
    }


    class OrganisationResult {
        @Column(name = "anzahl_ansprechpartner")
        public int anzahlAnsprechpartner;

        @Column(name = "organisation_id")
        public int organisationId;

        @Column(name = "organisation_name")
        public String organisationName;

        public OrganisationResult(int anzahlAnsprechpartner, int organisationId, String organisationName) {
            this.anzahlAnsprechpartner = anzahlAnsprechpartner;
            this.organisationId = organisationId;
            this.organisationName = organisationName;
        }

    }

    void updateOrganisationTable() {
        // get all organisations from the database
        EntityManager entityManager = EntityManagerFactorySingleton.getEntityManager();
        //List<Organisation> organisations = entityManager.createQuery("SELECT o FROM Organisation o", Organisation.class).getResultList();

        // SELECT COUNT(ansprechpartner.id) AS anzahl_ansprechpartner, organisation.id, organisation.name  FROM organisation LEFT JOIN ansprechpartner ON ansprechpartner.organisation = organisation.id GROUP BY organisation.id
        List<Object[]> results = entityManager.createNativeQuery("SELECT COUNT(ansprechpartner.id) AS anzahl_ansprechpartner, organisation.id, organisation.name  FROM organisation LEFT JOIN ansprechpartner ON ansprechpartner.organisation = organisation.id GROUP BY organisation.id").getResultList();

        organisationList.clear();
        for (Object[] result: results) {
            OrganisationResult organisationResult = new OrganisationResult(toIntExact((Long) result[0]), (int) result[1], (String) result[2]);
            System.out.println("Anzahl Ansprechpartner" + organisationResult.anzahlAnsprechpartner);
            System.out.println("Organisation ID" + organisationResult.organisationId);
            System.out.println("Organisation Name" + organisationResult.organisationName);

            organisationList.add(organisationResult);
        }

        organisationTableView.setItems(organisationList);

        organisationsNameCol.setCellValueFactory(p -> new ReadOnlyObjectWrapper(p.getValue().organisationName));
        anzahlAnsprechpartnerCol.setCellValueFactory(p -> new ReadOnlyObjectWrapper(p.getValue().anzahlAnsprechpartner));
    }

    void updateAll() {
        updateAnsprechpartnerTable();
        updateOrganisationTable();
    }


    @FXML
    Tab ansprechpartnerTab;

    @FXML
    Tab organisationenTab;


    @FXML
    Button ansprechpartnerHinzufuegenButton;



    /** Login Tab */
    @FXML
    void alsDozentEinloggenButtonOnClick(ActionEvent event) {
        // enable the ansprechpartner tab
        ansprechpartnerTab.setDisable(false);
        organisationenTab.setDisable(false);

        // enable add buttons
        ansprechpartnerHinzufuegenButton.setDisable(false);
        organisationHinzufuegenButton.setDisable(false);

        // set current user label
        currentUserLabel.setText("Current User: Dozent");

    }

    @FXML
    void alsStudentEinloggenButtonOnClick(ActionEvent event) {
        // disable the ansprechpartner tab
        ansprechpartnerTab.setDisable(true);
        // disable the organisationen tab
        organisationenTab.setDisable(true);

        ansprechpartnerHinzufuegenButton.setDisable(true);
        organisationHinzufuegenButton.setDisable(true);

        // set current user label
        currentUserLabel.setText("Current User: Student");

    }
    @FXML
    private Label currentUserLabel;

    @FXML
    private ListView<String> projektantraegeListView;

    private ObservableList<String> projektantraegeList = FXCollections.observableArrayList();

    @FXML
    private AnchorPane loginAnchorPane;

    /** Projektanträge Tab */
    @FXML
    private TableView<Projekt> projektantraegeTableView;

    @FXML
    private TableColumn<Projekt, String> projektTitelCol;

    @FXML
    private TableColumn<Projekt, String> projektAnsprechpartnerCol;

    private ObservableList<Projekt> projektListe = FXCollections.observableArrayList();




    @FXML
    void initialize() {
        assert organisationHinzufuegenButton != null : "fx:id=\"organisationHinzufuegenButton\" was not injected: check your FXML file 'dozentscreen.fxml'.";

        /** Organisation tab */
        updateOrganisationTable();

        /** Context menu for deleting organisations */
        ContextMenu cm = new ContextMenu();
        MenuItem mi1 = new MenuItem("Delete");
        mi1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Deleting organisation with id: " + selectedOrganisation.organisationId);
                EntityManager entityManager = EntityManagerFactorySingleton.getEntityManager();
                try {
                    entityManager.getTransaction().begin();
                    Query query = entityManager.createQuery("DELETE FROM Organisation o WHERE o.id = :id");
                    query.setParameter("id", selectedOrganisation.organisationId);
                    query.executeUpdate();
                    entityManager.getTransaction().commit();
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Fehler beim Löschen der Organisation. Die Organisation ist noch mit Ansprechpartnern verknüpft.");
                    alert.setContentText("Bitte löschen Sie zuerst alle Ansprechpartner der Organisation.");
                    e.printStackTrace();
                    alert.showAndWait();
                    entityManager.getTransaction().rollback();
                } finally {
                    updateAll();
                }
            }
        });
        cm.getItems().add(mi1);


        organisationTableView.setOnMouseClicked(event -> {
            // Use ListView's getSelected Item
            this.selectedOrganisation = organisationTableView.getSelectionModel().getSelectedItem();
            System.out.println("Selected Text " + selectedOrganisation.organisationName);
        });


        /** Hide context menu for deleting organisations when we clicked somewhere else :) */
        organisationTableView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                if(t.getButton() == MouseButton.SECONDARY) {
                    cm.show(organisationTableView, t.getScreenX(), t.getScreenY());
                } else {
                    cm.hide();
                }
            }
        });

        /** ------------------------ */

        /** Ansprechpartner tab */
        updateAll();
    
        ansprechpartnerTableView.setOnMouseClicked(event -> {
            // Use ListView's getSelected Item
            this.selectedAnsprechpartner = ansprechpartnerTableView.getSelectionModel().getSelectedItem();
            System.out.println("Selected Text " + selectedAnsprechpartner.getVorname());
        });

        /** Context menu for deleting ansprechpartner */
        ContextMenu cm2 = new ContextMenu();
        MenuItem mi2 = new MenuItem("Delete");
        mi2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Deleting ansprechpartner with id: " + selectedAnsprechpartner.getId());
                EntityManager entityManager = EntityManagerFactorySingleton.getEntityManager();
                try {
                    entityManager.getTransaction().begin();
                    Query query = entityManager.createQuery("DELETE FROM Ansprechpartner a WHERE a.id = :id");
                    query.setParameter("id", selectedAnsprechpartner.getId());
                    query.executeUpdate();
                    entityManager.getTransaction().commit();
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Fehler beim Löschen des Ansprechpartners.");
                    alert.setContentText("Bitte versuchen Sie es erneut.");
                    e.printStackTrace();
                    alert.showAndWait();
                    entityManager.getTransaction().rollback();
                } finally {
                    updateAll();
                }
            }
        });
        cm2.getItems().add(mi2);

        ansprechpartnerTableView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                if(t.getButton() == MouseButton.SECONDARY) {
                    cm2.show(ansprechpartnerTableView, t.getScreenX(), t.getScreenY());
                } else {
                    cm2.hide();
                }
            }
        });

        /** ------------------------ */

        /** Projektantraege tab */
        // create placeholder projekte
        // projekt 1
        Organisation org1 = new Organisation("FH-SWF");
        Ansprechpartner ansprechpartner1 = new Ansprechpartner(1, "Max", "Mustermann", "max@fh-swf.de", org1);

        Student student1 = new Student("Marc", "Richts", "marc@fh-swf.de", "123456");
        Student student2 = new Student("Erika", "Mustermann", "erika@fh-swf.de", "123455");

        ArrayList<Student> studenten = new ArrayList<Student>();
        studenten.add(student1);
        studenten.add(student2);

        Projekt projekt1 = new Projekt("Supertolles Projekt!", "Beschreibung 1", Projektstatus.EINGEREICHT, studenten, org1, ansprechpartner1);

        // Termine
        projekt1.setTermin1(LocalDate.of(2023, 1, 1));
        projekt1.setTermin2(LocalDate.of(2023, 2, 15));


        projektListe.add(projekt1);

        // projekt 2
        Organisation org2 = new Organisation("RWTH Aachen");

        Projekt projekt2 = new Projekt("Finanztool", "Beschreibung 2", Projektstatus.UEBERARBEITUNG, studenten, org2, ansprechpartner1);

        // Termine
        projekt2.setTermin1(LocalDate.of(2023, 5, 1));
        projekt2.setTermin2(LocalDate.of(2023, 7, 15));

        projektListe.add(projekt2);

        projektantraegeTableView.setItems(projektListe);

        /** Cell factories */
        projektTitelCol.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper(cellData.getValue().getTitel()));

        projektAnsprechpartnerCol.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper(cellData.getValue().getAnsprechpartner().getVorname() + " " + cellData.getValue().getAnsprechpartner().getNachname()));

        statusCol.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper(cellData.getValue().getStatus().toString()));

        vorstellungstermin1Col.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper(cellData.getValue().getTermin1().toString()));

        vorstellungstermin2Col.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper(cellData.getValue().getTermin2().toString()));


    }

    @FXML
    private TableColumn<Projekt, String> statusCol;

    @FXML
    private TableColumn<Projekt, String> vorstellungstermin1Col;

    @FXML
    private TableColumn<Projekt, String> vorstellungstermin2Col;

    @FXML
    private void projektAnsichtOnClick(ActionEvent event) throws IOException {
        // load projektantrag-dozent.fxml
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("projektantrag-dozent.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

}
