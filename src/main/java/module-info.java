module com.example.cse213finalproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    // For FXML controllers
    opens com.example.cse213finalproject.alvee.controller to javafx.fxml;

    // Export controller so others (FXML loader) can use it
    exports com.example.cse213finalproject.alvee.controller;

    opens com.example.cse213finalproject.alvee.model to javafx.fxml, javafx.base;

    // ✅ Export application package so JavaFX can instantiate HelloApplication
    exports com.example.cse213finalproject;
}
