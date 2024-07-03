package com.example.demo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DeleteNotification {

    public static String notificationID;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label notification;

    @FXML
    void initialize() {
        notification.setText("Строка под идентификатором " + notificationID + " была удалена.");
    }

}
