package com.example.a02;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private Button organisationHinzufuegenButton;

    @FXML
    void onOrganisationHinzuefuegenClick(ActionEvent event) {
        Dialog dialog = new Dialog();
        dialog.setTitle("Organisation hinzufügen");

        // create a label and text field for adding an Organisation
        Label label = new Label("Organisationsname: ");
        TextField textField = new TextField();

// create a button for adding the Organisation
        Button button = new Button("Hinzufügen");

        // add the label and text field to the dialog
        dialog.getDialogPane().getChildren().addAll(label, textField, button);

        dialog.show();

    }


}
