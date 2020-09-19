package model;

public abstract class Index {

    private static int _increament = 1;
    private final int id;

    public Index() {
        this.id = _increament++;
    }

    public int getId() {
        return id;
    }

}
