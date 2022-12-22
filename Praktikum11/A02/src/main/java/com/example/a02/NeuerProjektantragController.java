/**
 * Sample Skeleton for 'neuer-projektantrag-student.fxml' Controller Class
 */

package com.example.a02;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class NeuerProjektantragController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    private Button abbrechenButton;

    @FXML
    void abbrechenOnClick(ActionEvent action){
        Stage stage = (Stage) abbrechenButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void absendenOnClick(ActionEvent event)  {
        abbrechenOnClick(event);
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() throws IOException {

    }
}
