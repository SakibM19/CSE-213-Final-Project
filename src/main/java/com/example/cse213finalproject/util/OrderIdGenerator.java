package com.example.cse213finalproject.util;

import java.io.*;

public class OrderIdGenerator {
    private static final String FILE_PATH = "data/sakib/something.bin";

    public static String generateOrderId() {
        int lastOrderNumber = readLastOrderNumber();
        lastOrderNumber++;
        writeLastOrderNumber(lastOrderNumber);
        return String.format("O%03d", lastOrderNumber);
    }

    private static int readLastOrderNumber() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_PATH))) {
            return dis.readInt();
        } catch (IOException e) {
            return 0; // Start from 0 if file doesn't exist or is unreadable
        }
    }

    private static void writeLastOrderNumber(int number) {
        try {
            // Ensure the directories exist
            File file = new File(FILE_PATH);
            file.getParentFile().mkdirs(); // Creates the folders if they don't exist

            try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
                dos.writeInt(number);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
