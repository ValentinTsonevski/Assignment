package Polymorphism.Task_02;

public abstract class Item {
    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void displayInfo() {
        System.out.printf("Information about the product: %s %.2f %n",getName(),getPrice());
    }
}
