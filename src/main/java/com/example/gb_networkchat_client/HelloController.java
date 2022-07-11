package com.example.gb_networkchat_client;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    private ListView<String> userList;

    @FXML
    private Button sendButton;

    @FXML
    void sendMessageInChat() {
        String message = messageText.getText().trim();

        if (message.isEmpty()) {
            return;
        }

        appendMessage(message);


    }

    private void appendMessage(String message) {
        message = "Я:  " + message + "  " + simpleDateFormat.format(new Date());
        messagesArea.getItems().add(message);
        messageText.clear();
    }

    @FXML
    void initialize() {
        simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        userList.setItems(FXCollections.observableArrayList("Екатерина", "Александр", "Юлия", "Дария"));
        sendButton.setOnAction(event -> sendMessageInChat());
        messageText.setOnAction(event -> sendMessageInChat());

    }

}
