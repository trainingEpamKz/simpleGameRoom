package kz.gameRoom.gameRoom.model;


public abstract class Toy {
    private double cost;
    private String name;

    public Toy (double cost, String name) {
        this.cost = cost;
        this.name = name;
    }

    @Override
    public String toString() {
        return "( " + name + " : " + cost + " )";
    }

    public double getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }
}
