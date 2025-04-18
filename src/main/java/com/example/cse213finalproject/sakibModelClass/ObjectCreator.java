package com.example.cse213finalproject.sakibModelClass;

import com.example.cse213finalproject.alvee.model.CustomerQuery;
import com.example.cse213finalproject.util.BinaryFileHelper;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObjectCreator {
    public static void main(String[] args) {
        // Create lists to hold objects
        List<Customer> customers = new ArrayList<>();
        List<Order> orders = new ArrayList<>();
        List<Booking> bookings = new ArrayList<>();
        List<CustomerQuery> customerQueries = new ArrayList<>();

        // Create 10 Customer objects
        for (int i = 1; i <= 10; i++) {
            customers.add(new Customer(
                    "Customer " + i,
                    "customer" + i + "@example.com",
                    "password" + i,
                    "CUST00" + i,
                    1234567890 + i,
                    "Location " + i,
                    "Destination " + i
            ));
        }

        // Create 10 Order objects
        LocalDate today = LocalDate.now();
        Random random = new Random();
        for (int i = 1; i <= 10; i++) {
            LocalDate pickupDate = today.plusDays(i);
            LocalDate dropOffDate = pickupDate.plusDays(random.nextInt(5) + 1);

            orders.add(new Order(
                    "Customer " + i,
                    Order.generateOrderID(),
                    Booking.generateBookingID(),
                    "VEH00" + i,
                    "CUST00" + i,
                    pickupDate,
                    dropOffDate,
                    50.0f + random.nextInt(50) // Random daily rate between 50-100
            ));
        }

        // Create 10 Booking objects
        for (int i = 1; i <= 10; i++) {
            LocalDate pickupDate = today.plusDays(i);
            LocalDate dropOffDate = pickupDate.plusDays(random.nextInt(5) + 1);

            bookings.add(new Booking(
                    500 + random.nextInt(1000), // Random total cost
                    "Customer " + i,
                    "Vehicle Model " + i,
                    "VEH00" + i,
                    "CUST00" + i,
                    Booking.generateBookingID(),
                    pickupDate,
                    dropOffDate
            ));
        }



        // Create 10 CustomerQuery objects
        for (int i = 1; i <= 10; i++) {
            customerQueries.add(new CustomerQuery(
                    "REQ00" + i,
                    "Customer " + i,
                    "Query Subject " + i,
                    "This is a detailed description of query number " + i
            ));
        }

        List<Vehicle> vehicles = new ArrayList<>();

        // Create 10 Vehicle objects with realistic data
        vehicles.add(new Vehicle("VH001", "Camry", "Sedan", "Toyota", 5, 50.0f));
        vehicles.add(new Vehicle("VH002", "Civic", "Sedan", "Honda", 5, 45.0f));
        vehicles.add(new Vehicle("VH003", "F-150", "Pickup Truck", "Ford", 3, 70.0f));
        vehicles.add(new Vehicle("VH004", "Sienna", "Minivan", "Toyota", 7, 65.0f));
        vehicles.add(new Vehicle("VH005", "Model 3", "Electric", "Tesla", 5, 90.0f));
        vehicles.add(new Vehicle("VH006", "Silverado", "Pickup Truck", "Chevrolet", 3, 75.0f));
        vehicles.add(new Vehicle("VH007", "Odyssey", "Minivan", "Honda", 8, 68.0f));
        vehicles.add(new Vehicle("VH008", "Accord", "Sedan", "Honda", 5, 48.0f));
        vehicles.add(new Vehicle("VH009", "Wrangler", "SUV", "Jeep", 5, 85.0f));
        vehicles.add(new Vehicle("VH010", "Rogue", "SUV", "Nissan", 5, 60.0f));

        // Print some sample objects to verify
        System.out.println("Sample Customer: " + customers.get(0));
        System.out.println("Sample Order: " + orders.get(0));
        System.out.println("Sample Booking: " + bookings.get(0));
        System.out.println("Sample CustomerQuery: " + customerQueries.get(0));

        BinaryFileHelper.writeAllObjects(new File("data/alvee/customer-query.bin"), customerQueries);
        BinaryFileHelper.writeAllObjects(new File("data/sakib/booking.bin"), bookings);
        BinaryFileHelper.writeAllObjects(new File("data/user/customer.bin"), customers);
        BinaryFileHelper.writeAllObjects(new File("data/sakib/vehicle.bin"), vehicles);

        // You can now use these lists as needed
        // For example: processCustomers(customers), saveOrders(orders), etc.
    }
}