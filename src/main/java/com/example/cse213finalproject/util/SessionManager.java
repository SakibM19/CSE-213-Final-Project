package com.example.cse213finalproject.util;

import com.example.cse213finalproject.alvee.model.CSR;
import com.example.cse213finalproject.alvee.model.Inspector;
import com.example.cse213finalproject.sakibModelClass.Customer;

public class SessionManager {
    private static CSR loggedInCSR;
    private static Customer loggedInCustomer;
    private static Inspector loggedInInspector;

    public static Inspector getLoggedInInspector() {
        return loggedInInspector;
    }

    public static void setLoggedInInspector(Inspector loggedInInspector) {
        SessionManager.loggedInInspector = loggedInInspector;
    }

    public static CSR getLoggedInCSR() {
        return loggedInCSR;
    }

    public static void setLoggedInCSR(CSR csr) {
        loggedInCSR = csr;
    }

    public static Customer getLoggedInCustomer() {
        return loggedInCustomer;
    }

    public static void setLoggedInCustomer(Customer loggedInCustomer) {
        SessionManager.loggedInCustomer = loggedInCustomer;
    }
}

