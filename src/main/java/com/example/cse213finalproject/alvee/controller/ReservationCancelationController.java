package com.example.cse213finalproject.alvee.controller;

import com.example.cse213finalproject.alvee.model.CsrInteractionHistory;
import com.example.cse213finalproject.alvee.model.History;
import com.example.cse213finalproject.sakibModelClass.Booking;
import com.example.cse213finalproject.util.BinaryFileHelper;
import com.example.cse213finalproject.util.OrderIdGenerator;
import com.example.cse213finalproject.util.SceneSwitcher;
import com.example.cse213finalproject.util.SessionManager;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

public class ReservationCancelationController {
    @javafx.fxml.FXML
    private Text carNameText;
    @javafx.fxml.FXML
    private Text startDateText;
    @javafx.fxml.FXML
    private TextField bookingIdTextField;
    @javafx.fxml.FXML
    private Text customerNameText;
    @javafx.fxml.FXML
    private Text endDateText;
    private List<Booking> bookingList;
    private Booking b;
    private List<CsrInteractionHistory> csrInteractionHistoryList;

    @javafx.fxml.FXML
    public void initialize() {
        File bookingFile = new File("data/sakib/booking.bin");
        this.bookingList = BinaryFileHelper.readAllObjects(bookingFile);

        File csrHistoryFile = new File("data/alvee/csr-interaction-history.bin");
        this.csrInteractionHistoryList = BinaryFileHelper.readAllObjects(csrHistoryFile);
    }

    @javafx.fxml.FXML
    public void handleCancelBookingButtonOnClick(ActionEvent actionEvent) {
        if (b == null) return;

//                String historyId, String type, LocalDate date, String csrId
        CsrInteractionHistory csrInteractionHistory = new CsrInteractionHistory(
                OrderIdGenerator.generateInspectionHistoryId(),
                "Cancel Booking",
                LocalDate.now(),
                SessionManager.getLoggedInCSR().getEmployeeID()
        );

        boolean removed = false;
        for (Booking b : bookingList) {
            if (b.getBookingID().equals(this.b.getBookingID())) {
                bookingList.remove(b);
                removed = true;
                break;
            }
        }

        if (removed) {
            csrInteractionHistoryList.add(csrInteractionHistory);
            File csrHistoryFile = new File("data/alvee/csr-interaction-history.bin");
            BinaryFileHelper.writeAllObjects(csrHistoryFile, csrInteractionHistoryList);
        }

        File bookingFile = new File("data/sakib/booking.bin");
        BinaryFileHelper.writeAllObjects(bookingFile, bookingList);


        customerNameText.setText("");
        carNameText.setText("");
        startDateText.setText("");
        endDateText.setText("");
        bookingIdTextField.setText("");

        b = null; // Clear reference
    }

    @javafx.fxml.FXML
    public void handleBackButtonOnClick(ActionEvent actionEvent) {
        SceneSwitcher.switchScene((Node) actionEvent.getSource(), "CSR-dashboard.fxml", "Dashboard");
    }

    @javafx.fxml.FXML
    public void handleSearchButtonOnClick(ActionEvent actionEvent) {
//        for (Booking b : bookingList) {
//            if (bookingIdTextField.getText().equals(b.getBookingID())) {
//                customerNameText.setText(b.getCustomerName());
//                carNameText.setText(b.getVehicleName());
//                startDateText.setText(b.getPickupDate().toString());
//                endDateText.setText(b.getDropOffDate().toString());
//                this.b = b;
//                break;
//            }
//        }
    }
}