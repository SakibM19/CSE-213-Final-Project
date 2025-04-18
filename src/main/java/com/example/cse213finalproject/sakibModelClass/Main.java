package com.example.cse213finalproject.sakibModelClass;

import com.example.cse213finalproject.util.BinaryFileHelper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] arg ){
        List<Customer> customers = new ArrayList<>();

        customers.add(new Customer("Alice", "alice@example.com", "pass123", "c121", 1234567890, "Uttara", "Dhanmondi"));
        customers.add(new Customer("Bob", "bob@example.com", "bobpass12","c424", 1987654321, "Banani", "Mirpur"));
        customers.add(new Customer("Charlie", "charlie@example.com", "charlie123", "c363", 1122334455, "Gulshan", "Mohakhali"));
        customers.add(new Customer("Diana", "diana@example.com", "diana456", "c484", 1098765432, "Mohammadpur", "Bashundhara"));
        customers.add(new Customer("Ethan", "ethan@example.com", "ethan789", "c212", 1231231231, "Banasree", "Tejgaon"));

        // Print all customers
        for (Customer customer : customers) {
            System.out.println(customer);
        }

        File bookingFile = new File("data/user/customer.bin");
        BinaryFileHelper.writeAllObjects(bookingFile, customers);
    }
}
