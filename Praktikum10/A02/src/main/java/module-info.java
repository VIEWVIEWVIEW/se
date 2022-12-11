module com.example.a02 {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;


    opens com.example.a02 to javafx.fxml;
    exports com.example.a02;
}