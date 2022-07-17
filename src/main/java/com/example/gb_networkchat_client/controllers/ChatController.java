package com.example.gb_networkchat_client.controllers;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import com.example.gb_networkchat_client.models.Network;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ChatController {

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
    private Network network;

    @FXML
    void sendMessageInChat() {
        String message = messageText.getText().trim();
        messageText.clear();
        if (message.isEmpty()) {
            return;
        }

        //appendMessage(message);
        network.sendMessage(message);
    }

    public void appendMessage(String message) {
        message = message + "  " + simpleDateFormat.format(new Date());
        messagesArea.getItems().add(message);
    }

    @FXML
    void initialize() {
        simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        userList.setItems(FXCollections.observableArrayList("Екатерина", "Александр", "Юлия", "Дария"));
        sendButton.setOnAction(event -> sendMessageInChat());
        messageText.setOnAction(event -> sendMessageInChat());
    }

    public void setNetwork(Network network) {
        this.network = network;
    }
}
