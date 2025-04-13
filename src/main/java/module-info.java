module com.example.cse213finalproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.jfr;


    opens com.example.cse213finalproject to javafx.fxml;
    exports com.example.cse213finalproject;
    exports com.example.cse213finalproject.sakib;
    opens com.example.cse213finalproject.sakib to javafx.fxml;
}