package model;

import java.util.Map;

public interface IShoppingCart<T> {

    void clearShoppingCartItems();

    void addItem(T item);

    boolean remove(T item);

    Map<Integer, T> getShoppingCarts();

    T getItem(T t);

}
