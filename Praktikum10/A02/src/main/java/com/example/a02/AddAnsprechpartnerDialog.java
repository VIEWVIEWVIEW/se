package com.example.a02;

import jakarta.persistence.EntityManager;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class AddAnsprechpartnerDialog {

        static void show() {
            // Create new JavaFX dialog
            Dialog dialog = new Dialog();
            dialog.setTitle("Ansprechpartner hinzufügen");
            dialog.setHeaderText("Ansprechpartner hinzufügen");

            ButtonType speichern = new ButtonType("Speichern", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().addAll(speichern, ButtonType.CANCEL);

            VBox vBox = new VBox();
            Label vornameLabel = new Label("Vorname");
            TextField vornameTextField = new TextField();

            Label nachnameLabel = new Label("Nachname");
            TextField nachnameTextField = new TextField();

            Label emailLabel = new Label("Email");
            TextField emailTextField = new TextField();

            Label organisationLabel = new Label("Organisation");
            ComboBox organisationComboBox = new ComboBox<Organisation>();

            // get all organisations from the database and add them to the combobox
            EntityManager entityManager = EntityManagerFactorySingleton.getEntityManager();
            entityManager.getTransaction().begin();
            organisationComboBox.getItems().addAll(entityManager.createQuery("SELECT o FROM Organisation o", Organisation.class).getResultList());
            entityManager.getTransaction().commit();
            entityManager.clear();

            // set organisationComboBox CellFactory to show the name of the organisation
            organisationComboBox.setCellFactory(param -> new ListCell<Organisation>() {
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

            // set organisationComboBox ButtonCell to show the name of the organisation
            organisationComboBox.setButtonCell(new ListCell<Organisation>() {
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

            // add speichern button event handler
            dialog.setOnCloseRequest(event -> {
                if (dialog.getResult() == speichern) {
                    Ansprechpartner ansprechpartner = new Ansprechpartner();
                    ansprechpartner.setVorname(vornameTextField.getText());
                    ansprechpartner.setNachname(nachnameTextField.getText());
                    ansprechpartner.setEmail(emailTextField.getText());
                    ansprechpartner.setOrganisation((Organisation) organisationComboBox.getValue());
                    try {
                        EntityManager entityManager1 = EntityManagerFactorySingleton.getEntityManager();
                        entityManager1.getTransaction().begin();
                        entityManager1.persist(ansprechpartner);
                        entityManager1.getTransaction().commit();
                        entityManager1.clear();

                    } catch (Exception e) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Fehler");
                        alert.setHeaderText("Fehler beim Speichern");
                        alert.setContentText(e.getMessage());
                        alert.showAndWait();
                    }
                }
            });

            vBox.getChildren().addAll(vornameLabel, vornameTextField, nachnameLabel, nachnameTextField, emailLabel, emailTextField, organisationLabel, organisationComboBox);

            dialog.getDialogPane().setContent(vBox);


            dialog.showAndWait();
        }



}
