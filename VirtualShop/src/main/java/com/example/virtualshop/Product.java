package com.example.virtualshop;

public class Product {
    private String type;
    private double unitCost;
    private double markup;
    private double promotionalUnitPrice;
    private int quantity;
    private double baseUnitPrice;


    public Product() {
    }

    public Product(String type, double unitCost, double markup, double promotionalUnitPrice, int quantity, double baseUnitPrice) {
        this.type = type;
        this.unitCost = unitCost;
        this.markup = markup;
        this.promotionalUnitPrice = promotionalUnitPrice;
        this.quantity = quantity;
        this.baseUnitPrice = baseUnitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getBaseUnitPrice() {
        return baseUnitPrice;
    }

    public Product setBaseUnitPrice(double baseUnitPrice) {
        this.baseUnitPrice = baseUnitPrice;
        return this;
    }

    public Product setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getType() {
        return type;
    }

    public Product setType(String type) {
        this.type = type;
        return this;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public Product setUnitCost(double unitCost) {
        this.unitCost = unitCost;
        return this;
    }

    public double getMarkup() {
        return markup;
    }

    public Product setMarkup(double markup) {
        this.markup = markup;
        return this;
    }

    public double getPromotionalUnitPrice() {
        return promotionalUnitPrice;
    }

    public Product setPromotionalUnitPrice(double promotionalUnitPrice) {
        this.promotionalUnitPrice = promotionalUnitPrice;
        return this;
    }
}
