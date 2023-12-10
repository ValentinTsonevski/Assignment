package Encapsulation;

public class Product {
    private String name;
    private int cost;

    public Product(String name, int cost) {
        setName(name);
        setCost(cost);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    private void setCost(int cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("Monney cannot be negative");
        }
        this.cost = cost;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
