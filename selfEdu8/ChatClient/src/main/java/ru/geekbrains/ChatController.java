package ru.geekbrains;


import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;



import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;




public class ChatController implements Initializable {

    @FXML
    public TextArea chatArea;
    @FXML
    public ListView onlineUsers;
    @FXML
    public Button btnSendMessage;
    @FXML
    public TextField input;

    private MessageService messageService;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        messageService = new MessageService(chatArea);
        onlineUsers.setItems(FXCollections.observableArrayList("Vasya", "Petya", "Kolya"));
    }


    public void showHelp(ActionEvent actionEvent) throws URISyntaxException, IOException {
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(new URI("https://docs.google.com/document/d/1wr0YEtIc5yZtKFu-KITqYnBtp8KC28v2FEYUANL0YAM/edit#"));
    }

    public void exit(ActionEvent actionEvent) {
        Platform.exit();
    }


    public void mockAction(ActionEvent actionEvent) {

    }

    public void pressEnter(ActionEvent actionEvent) {
        sendMessage();
    }

    public void btnSend(ActionEvent actionEvent) {
        sendMessage();
    }

    private void sendMessage() {
        String msg = input.getText();
        if (msg.length() > 0) {
            messageService.sendMessage(msg);
//            chatArea.appendText(msg + System.lineSeparator());
            input.clear();
        }
    }

    private void showBroadcastMessage(String message) {
        chatArea.appendText(message + System.lineSeparator());
    }
}


