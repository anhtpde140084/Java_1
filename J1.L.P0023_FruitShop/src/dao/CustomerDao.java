package dao;

import java.util.List;
import model.Customer;

public class CustomerDao {

    public void add(Customer customer) {
        FruitDatabase db = FruitDatabase.getConnection();
        db.getCustomers().add(customer);
    }

    public List<Customer> getCustomers() {
        FruitDatabase db = FruitDatabase.getConnection();
        return db.getCustomers();
    }
}
