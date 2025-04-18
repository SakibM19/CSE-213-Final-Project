package com.example.cse213finalproject.sakib;

import com.example.cse213finalproject.sakibModelClass.Customer;
import com.example.cse213finalproject.util.SessionManager;
import javafx.event.Event;
import javafx.scene.control.TextField;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerDashboardViewController
{
    @javafx.fxml.FXML
    private TextField sendMessageToCustomerServiceTextField;
    @javafx.fxml.FXML
    private Text difaultPickupText;
    @javafx.fxml.FXML
    private Text userIdText;
    @javafx.fxml.FXML
    private Text addressText;
    @javafx.fxml.FXML
    private Text emailText;
    @javafx.fxml.FXML
    private Text nameText;
    @javafx.fxml.FXML
    private Text phoneNumberText;

    @javafx.fxml.FXML
    public void initialize() {
        Customer customer = SessionManager.getLoggedInCustomer();

        emailText.setText(customer.getEmail());
//        addressText.setText(customer.get);
        nameText.setText(customer.getName());
        userIdText.setText(customer.getId());
        phoneNumberText.setText(Integer.toString(customer.getPhoneNumber()));
        difaultPickupText.setText(customer.getPickUpLocation());
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
    public void couponsAndVouchersOnMouseClickedButton(Event event) {
        switchScene("CustomerOfferAndVouchersView.fxml", event);
    }

    @javafx.fxml.FXML
    public void feedbackOnMouseClickedButton(Event event) {
        switchScene("CustomerFeedbackBookingListView.fxml", event);
    }

    @javafx.fxml.FXML
    public void myFavouritesOnMouseClickedButton(Event event) {
        switchScene("CustomerFavouriteVehicleView.fxml", event);
    }

    @javafx.fxml.FXML
    public void emergencyAssistanceOnMouseClickedButton(Event event) {
        switchScene("CustomerEmergencyAssistanceView.fxml", event);
    }

    @javafx.fxml.FXML
    public void manageLocationOnMouseClickedButton(Event event) {
        switchScene("CustomerLocationSetAndEditView.fxml", event);
    }

    @javafx.fxml.FXML
    public void tracKBookingOnMouseClickedButton(Event event) {
        switchScene("CustomerTrackBookingView.fxml", event);
    }

    @javafx.fxml.FXML
    public void placeOrderOnMouseClickedButton(Event event) {
        switchScene("CustomerPlaceOrderInformationView.fxml", event);
    }

    @javafx.fxml.FXML
    public void paymentOnMouseClickedButton(Event event) {
        switchScene("CustomerOrderListForPaymentView.fxml", event);
    }

    @Deprecated
    public void logOutOnMouseClickedButton(Event event) {
    }

    public void setLoggedInCustomer(Customer customer) {

    }
}