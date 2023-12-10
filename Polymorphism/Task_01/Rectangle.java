package Polymorphism.Task_01;

public class Rectangle extends Shape{
    private double length;
    private double width;

    @Override
    double calculateArea() {
        return length * width;
    }

}
