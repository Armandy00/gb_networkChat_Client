package com.example.gb_networkchat_client;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class HelloController {

        private SimpleDateFormat simpleDateFormat;

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private Label labelName;

        @FXML
        private TextField messageText;

        @FXML
        private ListView<String> messagesArea;

        @FXML
        void sendMessageInChat(ActionEvent event) {
                String message  = messageText.getText().trim();

                if (message.length() != 0) {
                        message = "Я:  " + message + "  " + simpleDateFormat.format(new Date());
                        messagesArea.getItems().add(message);
                        messageText.clear();

                }

        }

        @FXML
        void initialize() {
                simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        }

}
