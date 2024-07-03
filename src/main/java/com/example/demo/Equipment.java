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
    private SimpleStringProperty comments;

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
        this.comments = new SimpleStringProperty(comments);
    }
    public String getId() {
        return id.get();
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getCategory() {
        return category.get();
    }

    public void setCategory(String category) {
        this.category.set(category);
    }

    public String getLine() {
        return line.get();
    }

    public void setLine(String line) {
        this.line.set(line);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getSerialNumber() {
        return serialNumber.get();
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber.set(serialNumber);
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public String getMarketPrice() {
        return marketPrice.get();
    }

    public void setMarketPrice(String marketPrice) {
        this.marketPrice.set(marketPrice);
    }

    public String getPurchasePrice() {
        return purchasePrice.get();
    }

    public void setPurchasePrice(String purchasePrice) {
        this.purchasePrice.set(purchasePrice);
    }

    public String getComments() {
        return comments.get();
    }

    public void setComments(String comments) {
        this.comments.set(comments);
    }
}
