module com.example.cse213finalproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.jfr;

    opens com.example.cse213finalproject to javafx.fxml;
    opens com.example.cse213finalproject.sakib to javafx.fxml;
    opens com.example.cse213finalproject.alvee.controller to javafx.fxml;
    opens com.example.cse213finalproject.alvee.model to javafx.fxml, javafx.base;

    exports com.example.cse213finalproject;
    exports com.example.cse213finalproject.sakib;
}
