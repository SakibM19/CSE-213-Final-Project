package com.example.cse213finalproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
<<<<<<< HEAD
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/com/example/cse213finalproject/sakib/customerEmergencyAssistanceView.fxml"));
=======
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/com/example/cse213finalproject/sakib/logInView.fxml"));
>>>>>>> 4c8e9620474424a584e2476028ab900a178e95e9
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Rent A Car");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}