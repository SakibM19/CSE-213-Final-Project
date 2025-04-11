module com.example.cse213finalproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cse213finalproject to javafx.fxml;
    exports com.example.cse213finalproject;
    exports sakib;
    opens sakib to javafx.fxml;
}