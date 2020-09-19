package model;

public class OrderLine extends Fruit {

    private int code;
    private double amount;

    public OrderLine(int code, String name, Double price, Integer quantity) {
        super(name, price, quantity, "");
        this.code = code;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
