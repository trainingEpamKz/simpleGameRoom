package kz.gameRoom.gameRoom.model;


import kz.gameRoom.gameRoom.Price;

public abstract class Toy {
    private double cost;
    private String name;

    public Toy (String name) {
        this.cost = Price.getPrice(this.getClass());
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
