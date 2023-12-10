package Polymorphism.Task_01;

public class Circle extends Shape{

    private double radius;

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
}
