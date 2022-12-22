package com.example.a02;

import jakarta.persistence.EntityManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListCell;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.List;

public class ProjektantragBearbeitenStudentController {

    @FXML
    private Button abbrechenButton;

    @FXML
    private Button neuEinreichenButton;

    @FXML
    private DatePicker termin1;

    @FXML
    private DatePicker termin2;



    @FXML
    void abbrechenOnClick(ActionEvent event) {
        Stage stage = (Stage) abbrechenButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void neuEinreichenonClick(ActionEvent event) {
        abbrechenOnClick(event);
    }



    @FXML
    void initialize() {
        LocalDate Vorstellungstermin1 = LocalDate.of(2023, 5, 1);
        LocalDate Vorstellungstermin2 = LocalDate.of(2023, 6, 15);
        termin1.setValue(Vorstellungstermin1);
        termin2.setValue(Vorstellungstermin2);




    }

}
