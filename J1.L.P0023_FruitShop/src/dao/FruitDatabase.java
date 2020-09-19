package dao;

import java.util.LinkedList;
import java.util.List;
import model.Customer;
import model.Fruit;

public class FruitDatabase {

    /**
     * Hold Data of Fruit Table
     */
    private final List<Fruit> fruits = new LinkedList<>();
    /**
     * Hold Data of Customer Table
     */
    private final List<Customer> customers = new LinkedList<>();
    /**
     * Hold database connection instance
     */
    private static FruitDatabase _instance;

    /**
     * Not allowed to create new object by constructor
     */
    private FruitDatabase() {
    }

    public List<Fruit> getFruits() {
        return fruits;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public static FruitDatabase getConnection() {
        if (_instance == null) {
            _instance = new FruitDatabase();
        }
        return _instance;
    }

}
