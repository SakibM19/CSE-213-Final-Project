package com.example.cse213finalproject.sakib;

import com.example.cse213finalproject.commonClass.SceneSwitch;
import javafx.event.Event;
import javafx.scene.control.Alert;

public class CustomerVouchersView
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backOnMouseClickedButton(Event event) {
        SceneSwitch.switchScene("/com/example/cse213finalproject/sakib/CustomerDashboardView.fxml", event);
    }

    @javafx.fxml.FXML
    public void voucherOnMouseClickedButton(Event event) {


        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("No Voucher Available ATM.");
        a.showAndWait();
    }
}