package com.example.a02;

import jakarta.persistence.EntityManager;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class AddOrganisationDialog {
    static void show() {
        // Create new JavaFX dialog
        Dialog dialog = new Dialog();
        dialog.setTitle("Organisation hinzufügen");
        dialog.setHeaderText("Organisation hinzufügen");

        ButtonType speichern = new ButtonType("Speichern", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(speichern, ButtonType.CANCEL);

        VBox vBox = new VBox();
        Label nameLabel = new Label("Name");
        TextField nameTextField = new TextField();
        vBox.getChildren().addAll(nameLabel, nameTextField);
        dialog.getDialogPane().setContent(vBox);

        dialog.setOnCloseRequest(event -> {
            if (dialog.getResult() == speichern) {
                Organisation organisation = new Organisation();
                organisation.setName(nameTextField.getText());
                try {
                    EntityManager entityManager = EntityManagerFactorySingleton.getEntityManager();
                    entityManager.getTransaction().begin();
                    entityManager.persist(organisation);
                    entityManager.getTransaction().commit();
                    entityManager.clear();
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Fehler");
                    alert.setHeaderText("Fehler beim Speichern");
                    alert.setContentText(e.getMessage());
                    alert.showAndWait();
                }
            }
        });

        dialog.showAndWait();
    }
}

