package model;

public class Fruit extends Index {

    private String name;
    private Double price;
    private Integer quantity;
    private String origin;

    public Fruit() {
    }

    public Fruit(String name, Double price, Integer quantity, String origin) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-10s %-10s", name, price, quantity);
    }

}
