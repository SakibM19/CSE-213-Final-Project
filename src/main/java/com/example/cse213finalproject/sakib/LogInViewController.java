package com.example.cse213finalproject.sakib;

import com.example.cse213finalproject.alvee.controller.CsrDashboardController;
import com.example.cse213finalproject.alvee.controller.InspectorDashboardController;
import com.example.cse213finalproject.alvee.model.CSR;
import com.example.cse213finalproject.alvee.model.Inspector;
import com.example.cse213finalproject.commonClass.SceneSwitch;
import com.example.cse213finalproject.sakibModelClass.Customer;
import com.example.cse213finalproject.util.BinaryFileHelper;
import com.example.cse213finalproject.util.SessionManager;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class LogInViewController implements SceneSwitch
{
    @javafx.fxml.FXML
    private TextField enterIdTextField;
    @javafx.fxml.FXML
    private PasswordField enterPasswordPasswordField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void loginOnMouseClickedButton(Event event) {
        String enteredId = enterIdTextField.getText().trim();
        String enteredPassword = enterPasswordPasswordField.getText().trim();

        if (enteredId.isEmpty() || enteredPassword.isEmpty()) {
            // Optional alert
            return;
        }

        if (enteredId.startsWith("csr")) {
            // Load CSR from file
            List<CSR> csrList = BinaryFileHelper.readAllObjects(new File("data/user/csr.bin"));
            for (CSR csr : csrList) {
                if (enteredId.equals(csr.getEmployeeID()) && enteredPassword.equals(csr.getPassword())) {
                    try {
                        SessionManager.setLoggedInCSR(csr);
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/cse213finalproject/alvee/csr-dashboard.fxml"));
                        Parent root = loader.load();

                        // Pass the logged-in CSR to dashboard
                        CsrDashboardController controller = loader.getController();
                        controller.setLoggedInCSR(csr);

                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        stage.setScene(new Scene(root));
                        stage.setTitle("CSR Dashboard");
                        stage.show();
                        return;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else if (enteredId.contains("@")) {
            // Load Customer from file
            List<Customer> customerList = BinaryFileHelper.readAllObjects(new File("data/user/customer.bin"));
            for (Customer customer : customerList) {
                if (customer.getEmail().equalsIgnoreCase(enteredId) && customer.getPassword().equals(enteredPassword)) {
                    try {
//                        CSR loggedInCSR = SessionManager.getLoggedInCSR();
                        SessionManager.setLoggedInCustomer(customer);
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/cse213finalproject/sakib/CustomerDashboardView.fxml"));
                        Parent root = loader.load();

                        // Pass the logged-in Customer to dashboard
                        CustomerDashboardViewController controller = loader.getController();
                        controller.setLoggedInCustomer(customer);

                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        stage.setScene(new Scene(root));
                        stage.setTitle("Customer Dashboard");
                        stage.show();
                        return;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else if (enteredId.startsWith("ins")) {
            List<Inspector> inspectorList = BinaryFileHelper.readAllObjects(new File("data/user/inspector.bin"));
            for (Inspector ins : inspectorList) {
                if (enteredId.equals(ins.getEmployeeID()) && enteredPassword.equals(ins.getPassword())) {
                    try {
                        SessionManager.setLoggedInInspector(ins);
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/cse213finalproject/alvee/inspector-dashboard.fxml"));
                        Parent root = loader.load();

                        // Pass the logged-in CSR to dashboard
                        InspectorDashboardController controller = loader.getController();
                        controller.setLoggedInCSR(ins);

                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        stage.setScene(new Scene(root));
                        stage.setTitle("Inspector Dashboard");
                        stage.show();
                        return;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        // Optional: Invalid login alert
    }

}