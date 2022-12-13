package com.example.a02;

import jakarta.persistence.EntityManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        /** select all organisations from the database and print them to the console */
        EntityManager entityManager = EntityManagerFactorySingleton.getEntityManager();


        /**
        entityManager.getTransaction().begin();
        // get organisation where name = "org1"
        Organisation org1 = entityManager.find(Organisation.class, 151);
        System.out.println(org1.getName());
         **/

    }

    public static void main(String[] args) {
        launch();
    }
}