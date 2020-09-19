package dao;

import java.util.List;
import java.util.stream.Collectors;
import model.Fruit;

public class FruitDao {

    /**
     * getFruits
     *
     * @return List Fruit
     *
     * Return fruits list available in database (quantity > 0)
     */
    public List<Fruit> getAvailableFruits() {
        FruitDatabase database = FruitDatabase.getConnection();
        return database.getFruits()
                .stream()
                .filter(fr -> fr.getQuantity() > 0)
                .collect(Collectors.toList());
    }

    /**
     * addFruit
     *
     * @param fruit
     *
     * Add new fruit to database
     * @return add status
     */
    public boolean addFruit(Fruit fruit) {
        FruitDatabase database = FruitDatabase.getConnection();
        return database.getFruits().add(fruit);
    }

    /**
     * updateFruit
     *
     * @param fruit
     *
     * Update one fruit
     */
    public void updateFruit(Fruit fruit) {
        FruitDatabase database = FruitDatabase.getConnection();
        database.getFruits()
                .stream()
                .filter(f -> f.getId() == fruit.getId())
                .map(fr -> fruit)
                .collect(Collectors.toList());
    }

    /**
     * getFruitById
     *
     * @param id
     * @return Fruit
     *
     * Find fruit in database by fruit id
     */
    public Fruit getFruitById(int id) {
        FruitDatabase database = FruitDatabase.getConnection();
        return database.getFruits()
                .stream()
                .filter(fr -> fr.getId() == id)
                .findAny().orElse(null);
    }

}
