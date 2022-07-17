package com.example.gb_networkchat_client;

import com.example.gb_networkchat_client.controllers.ChatController;
import com.example.gb_networkchat_client.models.Network;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Чат для общения!");
        stage.setScene(scene);
        stage.setX(800);
        stage.setY(500);
        stage.show();

        /*Socket socket = new Socket("localhost", 8186);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        out.writeUTF("Мороженка!");*/

        Network network = new Network();
        ChatController chatController = fxmlLoader.getController();
        chatController.setNetwork(network);
        network.connect();
        network.waitMessage(chatController);
    }

    public static void main(String[] args) {
        launch();
    }
}