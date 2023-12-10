package Encapsulation;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private int money;
    private List<Product> bag = new ArrayList<>();

    public Person(String name, int money, List<Product> bag) {
        setName(name);
        setMoney(money);
        setBag(bag);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    private void setMoney(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public List<Product> getBag() {
        return bag;
    }

    private void setBag(List<Product> bag) {
        this.bag = bag;
    }

    public void buyProduct(Product product) {
        if (getMoney() - product.getCost() >= 0) {
            setMoney(this.money - product.getCost());
            this.bag.add(product);

            System.out.printf("%s bought %s%n", getName(), product.getName());
        } else {
            System.out.printf("%s can't afford %s%n", getName(), product.getName());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (bag.isEmpty()) {
            sb.append(name).append(" -Nothing bought");
        } else {
            sb.append(name).append(" - ");

            for (int i = 0; i < bag.size(); i++) {
                sb.append(bag.get(i));

                if (i < bag.size() - 1) {
                    sb.append(", ");
                }
            }
        }
        return sb.toString();
    }

}
