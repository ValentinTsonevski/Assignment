package Polymorphism.Task_02;

public class PromotionalItem extends Item{

    private int discountPercentage;

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    @Override
    public void displayInfo() {
        System.out.printf("Discount price: %d %n",discountPercentage);
    }
}
