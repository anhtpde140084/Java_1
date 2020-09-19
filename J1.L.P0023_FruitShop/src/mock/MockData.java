package mock;

import java.util.LinkedList;
import java.util.List;
import model.Fruit;

public class MockData {

    public static List<Fruit> createFruits() {
        return new LinkedList<Fruit>() {
            {
                add(new Fruit("Coconut", 2.0, 10, "Thailand"));
                add(new Fruit("Orange", 3.0, 10, "China"));
                add(new Fruit("Apple", 4.0, 1, "US"));
                add(new Fruit("Shit", 15.0, 69, "Viet Nam"));
                add(new Fruit("Grape", 6.0, 2, "France"));
                add(new Fruit("Bomb", 9999.0, 999, "Viet Nam"));
            }
        };
    }

}
