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

public class ProjektantragBearbeitenDozentController {

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
    private ComboBox<Projektstatus> projektStatusCombobox;

    @FXML
    private ComboBox<Ansprechpartner> ansprechpartnerCombobox;

    @FXML
    private ObservableList<Ansprechpartner> ansprechparterList = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        LocalDate Vorstellungstermin1 = LocalDate.of(2023, 5, 1);
        LocalDate Vorstellungstermin2 = LocalDate.of(2023, 6, 15);
        termin1.setValue(Vorstellungstermin1);
        termin2.setValue(Vorstellungstermin2);

        projektStatusCombobox.getItems().addAll(Projektstatus.values());
        projektStatusCombobox.getSelectionModel().select(Projektstatus.EINGEREICHT);


        EntityManager entityManager = EntityManagerFactorySingleton.getEntityManager();
        List<Ansprechpartner> ansprechpartnerListTmp = entityManager.createQuery("SELECT a FROM Ansprechpartner a", Ansprechpartner.class).getResultList();
        ansprechparterList.addAll(ansprechpartnerListTmp);

        ansprechpartnerCombobox.getItems().addAll(ansprechparterList);
        ansprechpartnerCombobox.setCellFactory(cellData -> new ListCell<>(){
            // Why tf does JavaFX not let me use new ReadOnlyObjectProperty here?
            @Override
            protected void updateItem(Ansprechpartner item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setText(null);
                } else {
                    setText(item.getVorname() + " " + item.getNachname() + " @ " + item.getOrganisation().getName());
                }
            }
        });

        ansprechpartnerCombobox.setButtonCell(new ListCell<>(){
            @Override
            protected void updateItem(Ansprechpartner item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setText(null);
                } else {
                    setText(item.getVorname() + " " + item.getNachname() + " @ " + item.getOrganisation().getName());
                }
            }
        });



    }

}
