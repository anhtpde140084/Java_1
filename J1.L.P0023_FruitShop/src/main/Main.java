package main;

import dao.CustomerDao;
import dao.FruitDao;
import java.util.Scanner;
import mock.MockData;

public class Main {

    public static void main(String[] args) {
        final FruitDao fruitDao = new FruitDao();
        final Scanner sc = new Scanner(System.in);
        FruitShopManagement fruitShopManagement
                = new FruitShopManagement(sc, fruitDao);
        fruitShopManagement.setCustomerDao(new CustomerDao());
        // Add test data
        MockData.createFruits().forEach(fr -> {
            fruitDao.addFruit(fr);
        });
        fruitShopManagement.run();
    }
}
