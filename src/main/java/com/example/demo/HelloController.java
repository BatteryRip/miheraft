package com.example.demo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void buttonClick(ActionEvent event) {
        Button buttonPage = (Button) event.getSource();
        String buttonName = buttonPage.getText();
        if (buttonName.equals("Добавить")) {

        }
        if (buttonName.equals("Изменить")) {

        }
        if (buttonName.equals("Отчеты")) {

        }
        if (buttonName.equals("Категории поиска")) {

        }
    }

    @FXML
    void initialize() {

    }

}
