package com.example.a02;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class StudentScreenController {



    @FXML
    private TableColumn<Projekt, String> projektStatusCol;

    @FXML
    private TableView<Projekt> projektTableView;

    @FXML
    private TableColumn<Projekt, String> projektTitelCol;

    @FXML
    void neuerProjektAntragOnClick(ActionEvent event) throws IOException {
        // load neuerProjektAntrag.fxml
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("neuer-projektantrag-student.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private Button projektantragBearbeitenButton;

    @FXML
    void projektAntragBearbeitenOnClick(ActionEvent event) throws IOException {
        // load projektantrag-bearbeiten-student.fxml
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("projektantrag-bearbeiten-student.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    private ObservableList<Projekt> projektListe = FXCollections.observableArrayList();

    private Projekt selectedProjekt;

    @FXML
    private TableColumn<Projekt, String> vorstellungstermin1Col;

    @FXML
    private TableColumn<Projekt, String> vorstellungstermin2Col;

    @FXML
    void initialize() {
        projektantragBearbeitenButton.setDisable(true);

        assert projektStatusCol != null : "fx:id=\"projektStatusCol\" was not injected: check your FXML file 'hauptansicht-student.fxml'.";
        assert projektTableView != null : "fx:id=\"projektTableView\" was not injected: check your FXML file 'hauptansicht-student.fxml'.";
        assert projektTitelCol != null : "fx:id=\"projektTitelCol\" was not injected: check your FXML file 'hauptansicht-student.fxml'.";

        // projekt 1
        Organisation org1 = new Organisation("FH-SWF");
        Ansprechpartner ansprechpartner1 = new Ansprechpartner(1, "Max", "Mustermann", "max@fh-swf.de", org1);

        Student student1 = new Student("Marc", "Richts", "marc@fh-swf.de", "123456");
        Student student2 = new Student("Erika", "Mustermann", "erika@fh-swf.de", "123455");

        ArrayList<Student> studenten = new ArrayList<Student>();
        studenten.add(student1);
        studenten.add(student2);

        Projekt projekt1 = new Projekt("Supertolles Projekt!", "Beschreibung 1", Projektstatus.EINGEREICHT, studenten, org1, ansprechpartner1);

        projektListe.add(projekt1);

        // projekt 2
        Organisation org2 = new Organisation("RWTH Aachen");

        Projekt projekt2 = new Projekt("Finanztool", "Beschreibung 2", Projektstatus.UEBERARBEITUNG, studenten, org2, ansprechpartner1);

        projekt2.setTermin1(LocalDate.of(2023, 5, 1));
        projekt2.setTermin2(LocalDate.of(2023, 6, 15));

        projektListe.add(projekt2);

        // projekt 3
        Organisation org3 = new Organisation("FH-SWF");

        Projekt projekt3 = new Projekt("Sehr schlechtes Projekt", "Beschreibung 2", Projektstatus.ABGELEHNT, studenten, org3, ansprechpartner1);

        projektListe.add(projekt3);

        // ---


        projektTableView.setItems(projektListe);

        // cell facotries

        projektTitelCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getTitel()));

        projektStatusCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getStatus().name()));

        projektTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                selectedProjekt = newSelection;

                if (selectedProjekt.getStatus() == Projektstatus.UEBERARBEITUNG) {
                    projektantragBearbeitenButton.setDisable(false);
                } else {
                    projektantragBearbeitenButton.setDisable(true);
                }
            }
        });

        vorstellungstermin1Col.setCellValueFactory(cellData -> {
            if (cellData.getValue().getTermin1() != null) {
                return new ReadOnlyStringWrapper(cellData.getValue().getTermin1().toString());
            } else {
                return new ReadOnlyStringWrapper("");

            }
        });


        vorstellungstermin2Col.setCellValueFactory(cellData -> {
            if (cellData.getValue().getTermin2() != null) {
                return new ReadOnlyStringWrapper(cellData.getValue().getTermin2().toString());
            } else {
                return new ReadOnlyStringWrapper("");
            }
        });



    }

}
