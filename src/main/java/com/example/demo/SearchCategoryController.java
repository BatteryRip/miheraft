package com.example.demo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SearchCategoryController {

    public static String category;
    public static String line;
    public static String maxMarket;
    public static String minMarket;
    public static String maxPurchase;
    public static String minPurchase;
    public static String serialNumber;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField categoryField;

    @FXML
    private TextField lineField;

    @FXML
    private TextField maxMarketField;

    @FXML
    private TextField maxPurchaseField;

    @FXML
    private TextField minMarketField;

    @FXML
    private TextField minPurchaseField;

    @FXML
    private Button save;

    @FXML
    private TextField serialNumberField;

    @FXML
    void initialize() {
        save.setOnAction(event -> {
            category = categoryField.getText();
            System.out.println("Категория изменена на "+ category);
            line = lineField.getText();
            System.out.println("Линейка изменена на "+ line);
            maxMarket = maxMarketField.getText();
            System.out.println("Максимальная рыночная цена изменена на "+ maxMarket);
            maxPurchase = maxPurchaseField.getText();
            System.out.println("Максимальная закупочная цена изменена на "+ maxPurchase);
            minMarket = minMarketField.getText();
            System.out.println("Минимальная рыночная цена изменена на "+ minMarket);
            minPurchase = minPurchaseField.getText();
            System.out.println("Минимальная закупочная цена изменена на "+ minPurchase);
            serialNumber = serialNumberField.getText();
            System.out.println("Серийный номер изменен на "+ serialNumber);
        });
    }
}
