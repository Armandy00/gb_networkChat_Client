module com.example.gb_networkchat_client {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gb_networkchat_client to javafx.fxml;
    exports com.example.gb_networkchat_client;
}