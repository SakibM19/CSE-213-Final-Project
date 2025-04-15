package com.example.cse213finalproject.sakib;

import com.example.cse213finalproject.commonClass.SceneSwitch;
import javafx.event.Event;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CustomerTrackBookingViewController implements SceneSwitch
{
    @javafx.fxml.FXML
    private TableView trackBookingTableView;
    @javafx.fxml.FXML
    private TableColumn activeBookingIdTableColumn;
    @javafx.fxml.FXML
    private TextField idForTrackingTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backOnMouseClickedButton(Event event) {
        SceneSwitch.switchScene("/com/example/cse213finalproject/sakib/CustomerDashboardView.fxml", event);
    }

    @javafx.fxml.FXML
    public void trackBookingOnMouseClickedButton(Event event) {
        SceneSwitch.switchScene("/com/example/cse213finalproject/sakib/CustomerCurrentBookingStatusView.fxml", event);
    }


}
