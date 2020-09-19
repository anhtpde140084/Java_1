package main;

import dao.CustomerDao;
import dao.FruitDao;
import java.util.List;
import java.util.Scanner;
import model.Fruit;
import model.OrderLine;
import model.Customer;
import model.FruitCustomer;
import util.InputUtil;

public class FruitShopManagement {
    
    private final Scanner sc;
    private final FruitDao fruitDao;
    private CustomerDao customerDao;
    
    public FruitShopManagement(Scanner sc, FruitDao fruitDao) {
        this.sc = sc;
        this.fruitDao = fruitDao;
    }
    
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    /**
     * addFruit
     *
     * Allow user to input fruit data then add to database
     */
    private void addFruit() {
        String fruitName = InputUtil.getStringInput(sc, "Enter Fruit Name:", "You must input fruit name!");
        String origin = InputUtil.getStringInput(sc, "Enter Origin:", "You must input origin!");
        Double price = InputUtil.getDouble(sc, "Enter Price:");
        int quantity = InputUtil.getInt(sc, "Enter quantity:");
        Fruit fruit = new Fruit(fruitName, price, quantity, origin);
        final boolean addFruitResult = fruitDao.addFruit(fruit);
        if (addFruitResult) {
            System.out.println("New fruit was added successfully :)");
        }
    }

    /**
     * Display a list of all available fruits have quantity large than 0
     */
    private void displayFruits() {
        System.out.println("List of Fruit:");
        System.out.println(String.format("%-10s %-15s %-10s %-10s",
                "|++ Item ++", "| ++ Fruit Name ++ ", "| ++ Origin ++ ", "| ++ Price ++ |"));
        List<Fruit> fruits = fruitDao.getAvailableFruits();
        if (fruits.isEmpty()) {
            System.err.println("We are updating fruits!");
            return;
        }
        fruits.forEach(fr -> {
            System.out.println(String.format("\t%-2s \t%-15s \t%-10s \t%-10s\t - Q: %s",
                    fr.getId(), fr.getName(), fr.getOrigin(), fr.getPrice(), fr.getQuantity()));
        });
    }
    
    private void chooseFruit() {
        Customer<OrderLine> shoppingCartDb = new FruitCustomer();
        while (true) {
            displayFruits();
            int id = InputUtil.getInt(sc, "Enter Item Number:");
            Fruit f = fruitDao.getFruitById(id);
            if (f == null) {
                System.err.println("Wrong Fruit Item!");
                chooseFruit();
                return;
            }
            System.out.println(String.format("You selected: %s", f.getName()));
            int quantity = InputUtil.getInt(sc, "Please input quantity:");
            OrderLine ol = new OrderLine(f.getId(), f.getName(), f.getPrice(), quantity);
            if (quantity > f.getQuantity()) {
                System.err.println("Sorry, your fruit you choose is Out of Stock");
                return;
            }
            shoppingCartDb.addItem(ol);
            String choice = InputUtil.getStringInput(sc, "Do you want to order now (Y/N)", "Y/N");
            if (choice.equalsIgnoreCase("Y")) {
                displayShoppingCart(shoppingCartDb);
                String customerName = InputUtil.getStringInput(sc, "Enter your name:", "Please enter your name again");
                shoppingCartDb.setName(customerName);
                customerDao.add(shoppingCartDb);
                f.setQuantity(f.getQuantity() - ol.getQuantity());
                fruitDao.updateFruit(f);
                break;
            }
        }
        
    }
    
    private void displayShoppingCart(Customer<OrderLine> c) {
        double total = 0;
        System.out.println(String.format("%-5s %-5s %-5s",
                "Product | ", "Quantity | ", "Price | ", " Amount"));
        total = c.getShoppingCarts().values().stream().map((fr) -> {
            double amount = fr.getPrice() * fr.getQuantity();
            System.out.println(String.format("%-15s%-10s%-5s",
                    fr.getName(), fr.getQuantity(), amount));
            return amount;
        }).map((amount) -> amount).reduce(total, (accumulator, _item) -> accumulator + _item);
        System.out.println("Total: " + total + "$");
    }
    
    private void viewOrders() {
        List<Customer> customersOrder = customerDao.getCustomers();
        if (customersOrder.isEmpty()) {
            System.err.println("No orders!");
            return;
        }
        customersOrder.forEach(c -> {
            System.out.println(String.format("Customer:%s", c.getName()));
            System.out.println("Product | Quantity | Price | Amount");
            FruitCustomer fc = (FruitCustomer) c;
            fc.getShoppingCarts().values().forEach(e -> {
                System.out.println(String.format("%s\t%d\t%f$\t%f$", e.getName(), e.getQuantity(), e.getPrice(), e.getQuantity() * e.getPrice()));
            });
        });
    }
    
    private void showMenu() {
        System.out.println("FRUIT SHOP SYSTEM");
        System.out.println("1. Create Fruit");
        System.out.println("2. View Orders");
        System.out.println("3. Shopping (for buyer)");
        System.out.println("4. Exit");
    }
    
    public void run() {
        while (true) {
            showMenu();
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    addFruit();
                    break;
                case "2":
                    viewOrders();
                    break;
                case "3":
                    chooseFruit();
                    break;
                default:
                    System.exit(1);
            }
        }
    }
    
}
