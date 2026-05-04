package com.example.cse213finalproject.sakib;

import com.example.cse213finalproject.sakibModelClass.FavouriteVehicle;
import com.example.cse213finalproject.sakibModelClass.Vehicle;
import com.example.cse213finalproject.util.BinaryFileHelper;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CustomerFavouriteVehicleViewController {

    @javafx.fxml.FXML
    private TableColumn<Vehicle, Float> totalCostTableColumn;
    @javafx.fxml.FXML
    private TextField enterVehicleIdTextField;
    @javafx.fxml.FXML
    private TableColumn<Vehicle, String> vehicleModelTableColumn;
    @javafx.fxml.FXML
    private TableColumn<FavouriteVehicle, String> vehicleIdFavouriteTableColumn;
    @javafx.fxml.FXML
    private TableView<FavouriteVehicle> favouriteVehicleTableView;
    @javafx.fxml.FXML
    private TableColumn<Vehicle, String> vehicleIdTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Vehicle, String> vehicleTypeTableColumn;
    @javafx.fxml.FXML
    private TableView<Vehicle> pastOrderVehicleListTableView;
    @javafx.fxml.FXML
    private TableColumn<Vehicle, String> brandFavouriteTableColumn;

    private final File favouriteVehicle = new File("data/sakib/favourite.bin");
    private final File vehicleFile = new File("data/sakib/fleet.bin");

    @javafx.fxml.FXML
    public void initialize() {
        vehicleIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("vehicleID"));
        vehicleTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        vehicleModelTableColumn.setCellValueFactory(new PropertyValueFactory<>("vehicleModel"));
        totalCostTableColumn.setCellValueFactory(new PropertyValueFactory<>("perDayCost"));
        brandFavouriteTableColumn.setCellValueFactory(new PropertyValueFactory<>("brand"));

        vehicleIdFavouriteTableColumn.setCellValueFactory(new PropertyValueFactory<>("favouriteID"));

        loadVehicleData();

        loadFavouriteData();
    }

    private void loadVehicleData() {

        List<Vehicle> vehicles = BinaryFileHelper.readAllObjects(vehicleFile);
        pastOrderVehicleListTableView.getItems().clear();
        pastOrderVehicleListTableView.getItems().addAll(vehicles);

    }

    private void loadFavouriteData() {
        List<FavouriteVehicle> favouriteList = BinaryFileHelper.readAllObjects(favouriteVehicle);
        favouriteVehicleTableView.getItems().clear();
        favouriteVehicleTableView.getItems().addAll(favouriteList);


    }

    @javafx.fxml.FXML
    public void addToFavouriteOnMouseClickedButton(Event event) {
        String favID = enterVehicleIdTextField.getText();
        FavouriteVehicle newFav = new FavouriteVehicle(favID);

        BinaryFileHelper.saveObject(favouriteVehicle, newFav);
        loadFavouriteData();
        enterVehicleIdTextField.clear();


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
}
