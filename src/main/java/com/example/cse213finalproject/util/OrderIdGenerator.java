package com.example.cse213finalproject.util;

import java.io.*;

public class OrderIdGenerator {
    private static final String ORDER_ID_FILE = "data/sakib/orders.bin";
    private static final String INSPECTION_ID_FILE = "data/sakib/inspections.bin";


    public static String generateOrderId() {
        int lastOrderNumber = readLastOrderNumber(ORDER_ID_FILE);
        lastOrderNumber++;
        writeLastOrderNumber(ORDER_ID_FILE, lastOrderNumber);
        return String.format("O%03d", lastOrderNumber);
    }

    public static String generateInspectionId() {
        int lastOrderNumberIns = readLastOrderNumber(INSPECTION_ID_FILE);
        lastOrderNumberIns++;
        writeLastOrderNumber(INSPECTION_ID_FILE, lastOrderNumberIns);
        return String.format("in%03d", lastOrderNumberIns);
    }

    private static int readLastOrderNumber(String path) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(path))) {
            return dis.readInt();
        } catch (IOException e) {
            return 0;
        }
    }

    private static void writeLastOrderNumber(String path, int number) {
        try {
            // Ensure the directories exist
            File file = new File(path);
            file.getParentFile().mkdirs();

            try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
                dos.writeInt(number);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
