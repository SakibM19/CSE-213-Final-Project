package com.example.cse213finalproject.sakibModelClass;

import com.example.cse213finalproject.alvee.model.CSR;
import com.example.cse213finalproject.alvee.model.CustomerQuery;
import com.example.cse213finalproject.alvee.model.Inspector;
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
        List<Maintenance> maintenanceList = new ArrayList<>();

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

//            orders.add(new Order(
//                    "Customer " + i,
//                    Order.generateOrderID(),
//                    Booking.generateBookingID(),
//                    "VEH00" + i,
//                    "CUST00" + i,
//                    pickupDate,
//                    dropOffDate,
//                    50.0f + random.nextInt(50) // Random daily rate between 50-100
//            ));
       }
//
//        // Create 10 Booking objects
//        for (int i = 1; i <= 10; i++) {
//            LocalDate pickupDate = today.plusDays(i);
//            LocalDate dropOffDate = pickupDate.plusDays(random.nextInt(5) + 1);
//
//            bookings.add(new Booking(
//                    500 + random.nextInt(1000), // Random total cost
//                    "Customer " + i,
//                    "Vehicle Model " + i,
//                    "VH00" + i,
//                    "CUST00" + i,
//                    Booking.generateBookingID(),
//                    pickupDate,
//                    dropOffDate
//            ));
//        }



        // Create 10 CustomerQuery objects
        for (int i = 1; i <= 10; i++) {
            customerQueries.add(new CustomerQuery(
                    "REQ00" + i,
                    "Customer " + i,
                    "Query Subject " + i,
                    "This is a detailed description of query number " + i
            ));
        }

        List<CSR> CSRList = new ArrayList<>();

        // Create and add 5 CSR instances to the list
        CSRList.add(new CSR(
                "Sarah Johnson",
                "s.johnson@carrental.com",
                "secure123",
                "EMP1001",
                5550101,
                "csr1001",
                "Senior CSR"
        ));

        CSRList.add(new CSR(
                "Michael Chen",
                "m.chen@carrental.com",
                "mikey456",
                "EMP1002",
                5550102,
                "csr1002",
                "Rental Specialist"
        ));

        CSRList.add(new CSR(
                "Emily Rodriguez",
                "e.rodriguez@carrental.com",
                "emilyR789",
                "EMP1003",
                5550103,
                "csr1003",
                "Customer Support Lead"
        ));

        CSRList.add(new CSR(
                "David Wilson",
                "d.wilson@carrental.com",
                "dwilson!2023",
                "EMP1004",
                5550104,
                "csr1004",
                "VIP Relations"
        ));

        CSRList.add(new CSR(
                "Jessica Kim",
                "j.kim@carrental.com",
                "jessK!m42",
                "EMP1005",
                5550105,
                "csr1005",
                "New Accounts"
        ));

        List<Inspector> inspectorList = new ArrayList<>();

        // Create and add 5 CSR instances to the list
        inspectorList.add(new Inspector(
                "Sarah Johnson",
                "s.johnson@carrental.com",
                "secure123",
                "EMP1001",
                5550101,
                "ins1001",
                "Senior CSR"
        ));

        inspectorList.add(new Inspector(
                "Michael Chen",
                "m.chen@carrental.com",
                "mikey456",
                "EMP1002",
                5550102,
                "ins1002",
                "Rental Specialist"
        ));

        inspectorList.add(new Inspector(
                "Emily Rodriguez",
                "e.rodriguez@carrental.com",
                "emilyR789",
                "EMP1003",
                5550103,
                "ins1003",
                "Customer Support Lead"
        ));

        inspectorList.add(new Inspector(
                "David Wilson",
                "d.wilson@carrental.com",
                "dwilson!2023",
                "EMP1004",
                5550104,
                "ins1004",
                "VIP Relations"
        ));

        inspectorList.add(new Inspector(
                "Jessica Kim",
                "j.kim@carrental.com",
                "jessK!m42",
                "EMP1005",
                5550105,
                "ins1005",
                "New Accounts"
        ));

        List<Vehicle> vehicles = new ArrayList<>();
        // Toyota (4)
        vehicles.add(new Vehicle("VH031", "Avalon", "Sedan", "Toyota", 5, 52.0f));
        vehicles.add(new Vehicle("VH032", "4Runner", "SUV", "Toyota", 5, 76.0f));
        vehicles.add(new Vehicle("VH033", "Tacoma", "Pickup Truck", "Toyota", 4, 70.0f));
        vehicles.add(new Vehicle("VH034", "Venza", "Crossover", "Toyota", 5, 68.0f));

// Honda (4)
        vehicles.add(new Vehicle("VH035", "Insight", "Hybrid", "Honda", 5, 59.0f));
        vehicles.add(new Vehicle("VH036", "Ridgeline", "Pickup Truck", "Honda", 5, 72.0f));
        vehicles.add(new Vehicle("VH037", "Pilot", "SUV", "Honda", 7, 75.0f));
        vehicles.add(new Vehicle("VH038", "Fit", "Compact", "Honda", 5, 48.0f));

// Ford (4)
        vehicles.add(new Vehicle("VH039", "Edge", "SUV", "Ford", 5, 73.0f));
        vehicles.add(new Vehicle("VH040", "Fusion", "Sedan", "Ford", 5, 51.0f));
        vehicles.add(new Vehicle("VH041", "Ranger", "Pickup Truck", "Ford", 4, 69.0f));
        vehicles.add(new Vehicle("VH042", "Escape", "SUV", "Ford", 5, 65.0f));

// Chevrolet (4)
        vehicles.add(new Vehicle("VH043", "Trax", "Compact SUV", "Chevrolet", 5, 60.0f));
        vehicles.add(new Vehicle("VH044", "Impala", "Sedan", "Chevrolet", 5, 55.0f));
        vehicles.add(new Vehicle("VH045", "Blazer", "SUV", "Chevrolet", 5, 74.0f));
        vehicles.add(new Vehicle("VH046", "Colorado", "Pickup Truck", "Chevrolet", 4, 71.0f));

// Nissan (4)
        vehicles.add(new Vehicle("VH047", "Altima", "Sedan", "Nissan", 5, 50.0f));
        vehicles.add(new Vehicle("VH048", "Frontier", "Pickup Truck", "Nissan", 4, 68.0f));
        vehicles.add(new Vehicle("VH049", "Murano", "SUV", "Nissan", 5, 72.0f));
        vehicles.add(new Vehicle("VH050", "Versa", "Compact", "Nissan", 5, 45.0f));




        // Print some sample objects to verify
        System.out.println("Sample Customer: " + customers.get(0));
//        System.out.println("Sample Order: " + orders.get(0));
//        System.out.println("Sample Booking: " + bookings.get(0));
        System.out.println("Sample CustomerQuery: " + customerQueries.get(0));

        BinaryFileHelper.writeAllObjects(new File("data/alvee/customer-query.bin"), customerQueries);
//        BinaryFileHelper.writeAllObjects(new File("data/sakib/booking.bin"), bookings);
        BinaryFileHelper.writeAllObjects(new File("data/user/customer.bin"), customers);
        BinaryFileHelper.writeAllObjects(new File("data/sakib/fleet.bin"), vehicles);
        BinaryFileHelper.writeAllObjects(new File("data/user/csr.bin"), CSRList);
        BinaryFileHelper.writeAllObjects(new File("data/user/inspector.bin"), inspectorList);

        // You can now use these lists as needed
        // For example: processCustomers(customers), saveOrders(orders), etc.
    }
}