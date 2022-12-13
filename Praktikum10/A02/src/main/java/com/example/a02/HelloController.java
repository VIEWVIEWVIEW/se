package com.example.a02;

import jakarta.persistence.EntityManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController {
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML
    private Button organisationHinzufuegenButton;

    private ObservableList<Organisation> organisationList = FXCollections.observableArrayList();
    @FXML
    private ListView<Organisation> organisationListView;


    @FXML
    void onOrganisationHinzuefuegenClick(ActionEvent event) {
        AddOrganisationDialog.show();

    }

    @FXML
    void initialize() {
        assert organisationHinzufuegenButton != null : "fx:id=\"organisationHinzufuegenButton\" was not injected: check your FXML file 'main.fxml'.";
        assert organisationListView != null : "fx:id=\"organisationListView\" was not injected: check your FXML file 'main.fxml'.";

        // get all organisations from the database
        EntityManager entityManager = EntityManagerFactorySingleton.getEntityManager();
        List<Organisation> organisations = entityManager.createQuery("SELECT o FROM Organisation o", Organisation.class).getResultList();
        organisationList.addAll(organisations);

        organisationListView.setItems(organisationList);

        organisationListView.setCellFactory(param -> new ListCell<Organisation>() {
            @Override
            protected void updateItem(Organisation item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null || item.getName() == null) {
                    setText(null);
                } else {
                    setText(item.getName());
                }
            }
        });



        /**
        String org1 = new String("org1");
        String org2 = new String("org2");

        organisationList.add(org1);
        organisationList.add(org2);
        organisationListView = new ListView<>(organisationList);

        test.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("test");
                String org1 = new String("org1");
                String org2 = new String("org2");

                organisationList.add(org1);
                organisationList.add(org2);
                organisationListView.setItems(organisationList);
            }
        });
         **/


        /**
        organisationListView.setCellFactory(param -> new ListCell<Organisation>() {
            @Override
            protected void updateItem(Organisation item, boolean empty) {
                // super.updateItem(item, empty);
                System.out.println(item.getName() + item.getId());
                setText(item.getName());
                if (empty || item == null || item.getName() == null) {
                    setText(null);
                } else {

                }
            }
        });**/




        /**
        EntityManager entityManager = EntityManagerFactorySingleton.getEntityManager();

        // Get
        entityManager.getTransaction().begin();

        // add all organisations to the list view
        List<Organisation> organisations = entityManager.createQuery("SELECT o FROM Organisation o").getResultList();


        for (Organisation organisation : organisations) {
            organisationen.add(organisation);
            System.out.println("Adding " + organisation.getName());
        }

        organisationListView.setItems(organisationen);


        entityManager.getTransaction().commit();
        entityManager.clear();
        organisationListView.refresh();
**/


    }




}
