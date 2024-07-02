package com.example.demo;

import javafx.beans.property.SimpleStringProperty;

public class Equipment {
    public static final String ID = "ID";
    public static final String CATEGORY = "Категория";
    public static final String LINE = "Линейка";
    public static final String NAME = "Название";
    public static final String SERIAL_NUMBER = "Серийный_номер";
    public static final String DESCRIPTION = "Описание";
    public static final String MARKET_PRICE = "Рыночная_цена";
    public static final String PURCHASE_PRICE = "Закупочная_Цена";
    public static final String COMMENTS = "Комментарии";

    private SimpleStringProperty id;
    private SimpleStringProperty category;
    private SimpleStringProperty line;
    private SimpleStringProperty name;
    private SimpleStringProperty serialNumber;
    private SimpleStringProperty description;
    private SimpleStringProperty marketPrice;
    private SimpleStringProperty purchasePrice;
    private String comments;

    public Equipment(String id, String category, String line, String name, String serialNumber, String description, String marketPrice, String purchasePrice, String comments)
    {
        this.id = new SimpleStringProperty(id);
        this.category = new SimpleStringProperty(category);
        this.line = new SimpleStringProperty(line);
        this.name = new SimpleStringProperty(name);
        this.serialNumber = new SimpleStringProperty(serialNumber);
        this.description = new SimpleStringProperty(description);
        this.marketPrice = new SimpleStringProperty(marketPrice);
        this.purchasePrice = new SimpleStringProperty(purchasePrice);
        this.comments = comments;
    }
    public String getID() {
        return id.get();
    }
    public String getCategory() {
        return category.get();
    }
    public String getLine() {
        return line.get();
    }
    public String getName() {
        return name.get();
    }
    public String getSerialNumber() {
        return serialNumber.get();
    }
    public String getDescription() {
        return description.get();
    }
    public String getMarketPrice() {
        return marketPrice.get();
    }
    public String getPurchasePrice() {
        return purchasePrice.get();
    }
    public String getComments() {
        return comments;
    }
}
