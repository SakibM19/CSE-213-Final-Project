package com.example.cse213finalproject.alvee.controller;

import com.example.cse213finalproject.alvee.model.CsrInteractionHistory;
import com.example.cse213finalproject.alvee.model.CustomerQuery;
import com.example.cse213finalproject.alvee.model.ReservationRequest;
import com.example.cse213finalproject.sakibModelClass.Booking;
import com.example.cse213finalproject.sakibModelClass.Vehicle;
import com.example.cse213finalproject.util.BinaryFileHelper;
import com.example.cse213finalproject.util.OrderIdGenerator;
import com.example.cse213finalproject.util.SceneSwitcher;
import com.example.cse213finalproject.util.SessionManager;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

public class ReservationRequestListController {

    @javafx.fxml.FXML
    private Text carNameText;
    @javafx.fxml.FXML
    private Text startDateText;
    @javafx.fxml.FXML
    private DatePicker endDatePicker;
    @javafx.fxml.FXML
    private DatePicker startDatePicker;
    @javafx.fxml.FXML
    private Text customerNameText;
    @javafx.fxml.FXML
    private Text endDateText;
    @javafx.fxml.FXML
    private TextField bookingIdTextField;
    private Booking b;
    private List<Booking> bookingList;
    @javafx.fxml.FXML
    private ComboBox<String> availableCarComboBox;
    private List<Vehicle> vehicleList;
    private List<CsrInteractionHistory> csrInteractionHistoryList;

    @javafx.fxml.FXML
    public void initialize() {
        File vehicleFile = new File("data/sakib/fleet.bin");

        File csrHistoryFile = new File("data/alvee/csr-interaction-history.bin");
        this.csrInteractionHistoryList = BinaryFileHelper.readAllObjects(csrHistoryFile);

        this.vehicleList = BinaryFileHelper.readAllObjects(vehicleFile);

        for (Vehicle v : vehicleList) {
            if (v.getStatus().equals("Available")) {
                availableCarComboBox.getItems().add(v.getVehicleModel());
            }
        }

        File file = new File("data/sakib/booking.bin");
        this.bookingList = BinaryFileHelper.readAllObjects(file);
    }


    @javafx.fxml.FXML
    public void handleBackButtonOnClick(ActionEvent actionEvent) {
        SceneSwitcher.switchScene((Node) actionEvent.getSource(), "CSR-dashboard.fxml", "Dashboard");
    }

    @javafx.fxml.FXML
    public void handleUpdateButtonOnClick(ActionEvent actionEvent) {
        if (b == null) return;

        String selectedModel = availableCarComboBox.getValue();
        for (Vehicle v : vehicleList) {
            if (v.getVehicleModel().equals(selectedModel)) {
//                b.setVehicleID(v.getVehicleID());
                break;
            }
        }

//        b.setVehicleName(availableCarComboBox.getValue());
        b.setPickupDate(startDatePicker.getValue());
        b.setDropOffDate(endDatePicker.getValue());


        for (int i = 0; i < bookingList.size(); i++) {
            if (bookingList.get(i).getBookingID().equals(b.getBookingID())) {
                bookingList.set(i, b);
                break;
            }
        }

        // Save back to file
        File file = new File("data/sakib/booking.bin");
        BinaryFileHelper.writeAllObjects(file, bookingList);

//        carNameText.setText(b.getVehicleName());
        startDateText.setText(b.getPickupDate().toString());
        endDateText.setText(b.getDropOffDate().toString());
        b = null;

        CsrInteractionHistory csrInteractionHistory = new CsrInteractionHistory(
                OrderIdGenerator.generateInspectionHistoryId(),
                "Modify Booking",
                LocalDate.now(),
                SessionManager.getLoggedInCSR().getEmployeeID()
        );
        csrInteractionHistoryList.add(csrInteractionHistory);
        File csrHistoryFile = new File("data/alvee/csr-interaction-history.bin");
        BinaryFileHelper.writeAllObjects(csrHistoryFile, csrInteractionHistoryList);
    }


    @javafx.fxml.FXML
    public void handleSearchButtonOnClick(ActionEvent actionEvent) {

        for (Booking b : bookingList) {
            if (bookingIdTextField.getText().equals(b.getBookingID())) {
                customerNameText.setText(b.getCustomerName());
//                carNameText.setText(b.getVehicleName());
                startDateText.setText(b.getPickupDate().toString());
                endDateText.setText(b.getDropOffDate().toString());
                this.b = b;
                break;
            }
        }

    }
}