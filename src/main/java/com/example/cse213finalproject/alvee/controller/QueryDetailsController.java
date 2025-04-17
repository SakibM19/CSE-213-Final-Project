package com.example.cse213finalproject.alvee.controller;

import com.example.cse213finalproject.alvee.model.CustomerQuery;
import com.example.cse213finalproject.util.BinaryFileHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class QueryDetailsController
{
    @javafx.fxml.FXML
    private Label queryLabel;
    @javafx.fxml.FXML
    private TextField idTextField;
    @javafx.fxml.FXML
    private TextField responseTextField;
    private CustomerQuery cq;



    @javafx.fxml.FXML
    public void initialize() {

//        this.queries = queries;
    }


    @javafx.fxml.FXML
    public void handleSendButtonOnClick(ActionEvent actionEvent) {
        if (cq == null) return;

        cq.setRespond(responseTextField.getText());
        cq.setStatus("Resolved");

        File file = new File("data/alvee/customer-queries.bin");
        List<CustomerQuery> queries = BinaryFileHelper.readAllObjects(file);

        for (int i = 0; i < queries.size(); i++) {
            if (queries.get(i).getRequestId().equals(cq.getRequestId())) {
                queries.set(i, cq);
                break;
            }
        }

        // Save back to file
        BinaryFileHelper.writeAllObjects(file, queries);
    }

    @javafx.fxml.FXML
    public void handleBackButtonOnClick(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/cse213finalproject/alvee/query-request-list.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("CSR Dashboard");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Optional: replace with proper alert or logging
        }
    }

    @javafx.fxml.FXML
    public void handleSearchButtonOnClick(ActionEvent actionEvent) {
        File file = new File("data/alvee/customer-queries.bin");
        List<CustomerQuery> queries = BinaryFileHelper.readAllObjects(file);
        for (CustomerQuery cq: queries) {
            if (cq.getRequestId().equals(idTextField.getText())){
                queryLabel.setText(cq.getQueryDescription());
                responseTextField.setText(cq.getRespond());
                this.cq = cq;
                return;
            }
        }
    }
}