package com.example.cse213finalproject.sakib;

import com.example.cse213finalproject.commonClass.SceneSwitch;
import javafx.event.Event;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LogInViewController implements SceneSwitch
{
    @javafx.fxml.FXML
    private TextField enterIdTextField;
    @javafx.fxml.FXML
    private PasswordField enterPasswordPasswordField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void loginOnMouseClickedButton(Event event) {
        SceneSwitch.switchScene("/com/example/cse213finalproject/sakib/CustomerDashboardView.fxml", event);

    }
}