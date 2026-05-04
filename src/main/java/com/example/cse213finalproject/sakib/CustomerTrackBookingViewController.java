package com.example.cse213finalproject.sakib;

import com.example.cse213finalproject.commonClass.SceneSwitch;
import com.example.cse213finalproject.sakibModelClass.Booking;
import com.example.cse213finalproject.util.BinaryFileHelper;
import javafx.collections.FXCollections;
import javafx.event.Event;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CustomerTrackBookingViewController implements SceneSwitch
{
    @javafx.fxml.FXML
    private TableView<Booking> trackBookingTableView;
    @javafx.fxml.FXML
    private TableColumn<Booking, String> activeBookingIdTableColumn;

    private File bookingFile = new File("data/sakib/booking.bin");

    @javafx.fxml.FXML
    public void initialize() {
        activeBookingIdTableColumn.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("bookingID"));
        loadBookingData();
    }

    public void loadBookingData(){
        List<Booking> bookingList = BinaryFileHelper.readAllObjects(bookingFile);
        trackBookingTableView.getItems().clear();
        trackBookingTableView.getItems().addAll(bookingList);

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
