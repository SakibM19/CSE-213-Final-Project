package com.example.cse213finalproject.sakib;

import com.example.cse213finalproject.sakibModelClass.Booking;
import com.example.cse213finalproject.sakibModelClass.Customer;
import com.example.cse213finalproject.sakibModelClass.Vehicle;
import com.example.cse213finalproject.util.BinaryFileHelper;
import javafx.event.Event;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;


public class CustomerPlaceOrderInformationViewController
{
    @javafx.fxml.FXML
    private ComboBox<Integer> seatsWantedComboBox;
    @javafx.fxml.FXML
    private DatePicker dropoffDatePicker;
    @javafx.fxml.FXML
    private DatePicker pickupDatePicker;
    @javafx.fxml.FXML
    private TextField dropoffLocationTextField;
    @javafx.fxml.FXML
    private ComboBox<String> vehicleTypeWantedComboBox;
    @javafx.fxml.FXML
    private TextField pickupLocationTextField;

    @javafx.fxml.FXML
    public void initialize() {

        seatsWantedComboBox.getItems().addAll(2, 5, 7);
        vehicleTypeWantedComboBox.getItems().addAll("Sedan","SUV");
    }

    @javafx.fxml.FXML
    public void backOnMouseClickedButton(Event event) {
        switchScene("/com/example/cse213finalproject/sakib/CustomerDashboardView.fxml", event);
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
    public void placeOrderOnMouseClickedButton(Event event) {

    }

    @javafx.fxml.FXML
    public void createBookingOnMouseClickedButton(Event event) {
        File customerFile = new File("data/user/customer.bin");
        File bookingFile = new File("data/sakib/booking.bin");
        File vehicleFile = new File("data/sakib/vehicle.bin");

        // Get pickup and dropoff locations from input
        String pickupLocation = pickupLocationTextField.getText();
        String dropoffLocation = dropoffLocationTextField.getText();

        // Get selected dates
        LocalDate pickupDate = pickupDatePicker.getValue();
        LocalDate dropoffDate = dropoffDatePicker.getValue();

        // Get vehicle type and seats
        String vehicleType = vehicleTypeWantedComboBox.getValue();
        Integer seats = seatsWantedComboBox.getValue();


        // Read customers
        List<Customer> customers = BinaryFileHelper.readAllObjects(customerFile);
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }

        // Read vehicles
        List<Vehicle> vehicles = BinaryFileHelper.readAllObjects(vehicleFile);
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
            return;
        }

        // Find matching vehicle (by type and seat)
        Vehicle selectedVehicle = null;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType) && vehicle.getSeatCapacity() == seats) {
                selectedVehicle = vehicle;
                break;
            }
        }

        if (selectedVehicle == null) {
            System.out.println("No matching vehicle found.");
            return;
        }

        // Use first customer for demo purposes
       // Customer customer = customers.get(0);
        // Create a customer object for placing an order
        Customer customer = new Customer(
                "John Doe",           // Customer Name
                "johndoe@example.com", // Customer Email
                "password123",         // Customer Password
                "C12345",              // Customer ID
                1234567890,            // Customer Phone Number
                "New York"             // Pickup Location
        );

// Optionally, set a drop-off location if applicable
        customer.setDropOffLocation("Los Angeles"); // Drop-off Location


        // Calculate rental days
       // long days = java.time.temporal.ChronoUnit.DAYS.between(pickupDate, dropoffDate);
        // if (days <= 0) days = 1; // minimum 1 day

        // Calculate cost
        //int totalCost = (int) (selectedVehicle.getPerDayCost() * days);
        int totalCost = 123;

        // Create and save booking
        Booking booking = new Booking();
        booking.setBookingID(Booking.generateBookingID());
        booking.setCustomerId(customer.getId());
        booking.setCustomerName(customer.getName());
        booking.setVehicleID(selectedVehicle.getVehicleID());
        booking.setVehicleName(selectedVehicle.getVehicleModel());
        booking.setPickupDate(pickupDate);
        booking.setDropOffDate(dropoffDate);
        booking.setTotalCost(totalCost);

        BinaryFileHelper.saveObject(bookingFile, booking);
        System.out.println("Booking created and saved: " + booking);
    }

    @javafx.fxml.FXML
    public void defaultLocationOnMouseClickedButton(Event event) {
    }
}