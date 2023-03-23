package com.example.virtualshop;

public class Client {
    private int id;
    private double basicDiscount;
    private double additionalVolumeDiscountAbove10000;
    private double additionalVolumeDiscountAbove30000;


    public Client() {
    }

    public Client(int id, double basicDiscount, double additionalVolumeDiscountAbove10000, double additionalVolumeDiscountAbove30000) {
        this.id = id;
        this.basicDiscount = basicDiscount;
        this.additionalVolumeDiscountAbove10000 = additionalVolumeDiscountAbove10000;
        this.additionalVolumeDiscountAbove30000 = additionalVolumeDiscountAbove30000;
    }

    public int getId() {
        return id;
    }

    public Client setId(int id) {
        this.id = id;
        return this;
    }

    public double getBasicDiscount() {
        return basicDiscount;
    }

    public Client setBasicDiscount(double basicDiscount) {
        this.basicDiscount = basicDiscount;
        return this;
    }

    public double getAdditionalVolumeDiscountAbove10000() {
        return additionalVolumeDiscountAbove10000;
    }

    public Client setAdditionalVolumeDiscountAbove10000(double additionalVolumeDiscountAbove10000) {
        this.additionalVolumeDiscountAbove10000 = additionalVolumeDiscountAbove10000;
        return this;
    }

    public double getAdditionalVolumeDiscountAbove30000() {
        return additionalVolumeDiscountAbove30000;
    }

    public Client setAdditionalVolumeDiscountAbove30000(double additionalVolumeDiscountAbove30000) {
        this.additionalVolumeDiscountAbove30000 = additionalVolumeDiscountAbove30000;
        return this;
    }
}
