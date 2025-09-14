package com.example.cse213finalproject.sakib;

import com.example.cse213finalproject.sakibModelClass.Booking;
import com.example.cse213finalproject.util.BinaryFileHelper;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CustomerCurrentBookingStatusViewController
{
    @javafx.fxml.FXML
    private Label currentStatusLabel;
    @javafx.fxml.FXML
    private Label dropoffDateLabel;
    @javafx.fxml.FXML
    private Label pickupDateLabel;
    @javafx.fxml.FXML
    private Label totalCostLabel;
    @javafx.fxml.FXML
    private Label bookingIdLabel;
    @javafx.fxml.FXML
    private Label vehicleIdLabel;

    @javafx.fxml.FXML
    private TableView trackBookingTableView;
    @javafx.fxml.FXML
    private TextField idForTrackingTextField;
    @javafx.fxml.FXML
    private TableColumn activeBookingIdTableColumn;

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
        switchScene("/com/example/cse213finalproject/sakib/CustomerTrackBookingView.fxml", event);
    }


    private void switchScene(String fxmlFile, Event event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void trackBookingOnMouseClickedButton(Event event) {
        List<Booking> bookingList = BinaryFileHelper.readAllObjects(bookingFile);
        for(Booking b: bookingList){
            if(b.getBookingID().equals(idForTrackingTextField.getText())){
                currentStatusLabel.setText("Waiting to be approved");
                bookingIdLabel.setText(b.getBookingID());
                dropoffDateLabel.setText(b.getDropOffDate().toString());
                pickupDateLabel.setText(b.getPickupDate().toString());
                vehicleIdLabel.setText(b.getVehicleModel());
                totalCostLabel.setText(Integer.toString(b.getTotalCost()));


            }
        }


    }
}