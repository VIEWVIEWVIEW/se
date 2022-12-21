module com.example.a02 {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;

    opens com.example.a02;
    exports com.example.a02;
}