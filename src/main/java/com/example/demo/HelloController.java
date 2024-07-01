package com.example.demo;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloController {

    private void PageLoad(String fxmlString, int v, int v1, String title) {
        FXMLLoader funcFxmlLoader = new FXMLLoader(getClass().getResource(fxmlString));
        Scene funcScene = null;
        try {
            funcScene = new Scene(funcFxmlLoader.load(), v,v1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage funcStage = new Stage();
        funcStage.setTitle(title);
        funcStage.setResizable(false);
        funcStage.setScene(funcScene);
        funcStage.show();
    };

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonCategories;

    @FXML
    private Button buttonChange;

    @FXML
    private Button buttonReports;

    @FXML
    private Button buttonSearch;

    @FXML
    private TextField searchField;

    @FXML
    public TableView<Equipment> table;

    @FXML
    private TableColumn<Equipment, String> tableCategory;

    @FXML
    private TableColumn<Equipment, String> tableComments;

    @FXML
    private TableColumn<Equipment, String> tableDescription;

    @FXML
    private TableColumn<Equipment, String> tableID;

    @FXML
    private TableColumn<Equipment, String> tableLine;

    @FXML
    private TableColumn<Equipment, String> tableMarketPrice;

    @FXML
    private TableColumn<Equipment, String> tableName;

    @FXML
    private TableColumn<Equipment, String> tablePurchasePrice;

    @FXML
    private TableColumn<Equipment, String> tableSerialNumber;

    @FXML
    void initialize() {
        DatabaseHandler dbHandler = new DatabaseHandler();
        buttonCategories.setOnAction(event -> {
            PageLoad("search-category.fxml", 488, 263, "Категории");
        });
        buttonAdd.setOnAction(event -> {
            PageLoad("add.fxml", 700, 425, "Добавление");
        });
        buttonChange.setOnAction(event -> {
            PageLoad("change.fxml", 700, 425, "Изменение");
        });
        buttonSearch.setOnAction(event -> {
            try {
                dbHandler.searchQuery(searchField.getText());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
