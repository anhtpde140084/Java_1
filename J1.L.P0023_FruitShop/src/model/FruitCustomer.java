package model;

import java.util.LinkedHashMap;
import java.util.Map;

public class FruitCustomer extends Customer<OrderLine> {

    private final Map<Integer, OrderLine> shoppingCart = new LinkedHashMap<>();

    public FruitCustomer() {

    }

    @Override
    public void clearShoppingCartItems() {
        shoppingCart.clear();
    }

    @Override
    public void addItem(OrderLine item) {
        if (shoppingCart.containsKey(item.getCode())) {
            OrderLine dulicatedFruit = shoppingCart.get(item.getCode());
            dulicatedFruit.setQuantity(dulicatedFruit.getQuantity() + item.getQuantity());
            shoppingCart.put(dulicatedFruit.getCode(), dulicatedFruit);
        } else {
            shoppingCart.put(item.getCode(), item);
        }
    }

    @Override
    public boolean remove(OrderLine item) {
        shoppingCart.remove(item.getCode());
        return true;
    }

    @Override
    public Map<Integer, OrderLine> getShoppingCarts() {
        return shoppingCart;
    }

    @Override
    public OrderLine getItem(OrderLine od) {
        return shoppingCart.get(od.getCode());
    }

}
