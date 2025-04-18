package com.example.cse213finalproject.sakib;

import javafx.event.Event;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

import java.io.IOException;

public class CustomerFavouriteVehicleViewController
{
    @javafx.fxml.FXML
    private TableColumn totalCostTableColumn;
    @javafx.fxml.FXML
    private TextField enterVehicleIdTextField;
    @javafx.fxml.FXML
    private TableColumn pastOrderIdTableColumn;
    @javafx.fxml.FXML
    private TableColumn vehicleModelTableColumn;
    @javafx.fxml.FXML
    private TextField enterOrderIdTextField;
    @javafx.fxml.FXML
    private TableColumn vehicleIdFavouriteTableColumn;
    @javafx.fxml.FXML
    private TableView favouriteVehicleTableView;
    @javafx.fxml.FXML
    private TableColumn vehicleModelFavouriteTableColumn;
    @javafx.fxml.FXML
    private TableColumn pickupDateTableColumn;
    @javafx.fxml.FXML
    private TableColumn vehicleIdTableColumn;
    @javafx.fxml.FXML
    private TableColumn vehicleTypeTableColumn;
    @javafx.fxml.FXML
    private TableColumn lastOrderIdTableColumn;
    @javafx.fxml.FXML
    private TableView pastOrderVehicleListTableView;
    @javafx.fxml.FXML
    private TableColumn vehicleTypeFavouriteTableColumn;
    @javafx.fxml.FXML
    private TableColumn averageCostTableColumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backOnMouseClickedButton(Event event) {
        switchScene("/com/example/cse213finalproject/sakib/CustomerDashboardView.fxml", event);
    }

    @javafx.fxml.FXML
    public void addToFavouriteOnMouseClickedButton(Event event) {
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
}