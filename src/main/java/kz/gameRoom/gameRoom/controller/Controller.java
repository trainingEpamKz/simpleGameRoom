package kz.gameRoom.gameRoom.controller;


import kz.gameRoom.gameRoom.*;
import kz.gameRoom.gameRoom.model.*;
import kz.gameRoom.gameRoom.model.balls.Ball;
import kz.gameRoom.gameRoom.model.blocks.Block;
import kz.gameRoom.gameRoom.model.cars.Car;
import kz.gameRoom.gameRoom.model.cars.LargeCar;
import kz.gameRoom.gameRoom.model.cars.MediumCar;
import kz.gameRoom.gameRoom.model.cars.SmallCar;
import kz.gameRoom.gameRoom.model.dolls.Doll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {
    private int maxToys;
    private double maxMoneys;
    private double money;
    private List<Toy> gameRoom;
    private ToysFabric toysFabric;
    private List<Toy> toys;
    private List<Class<? extends Toy>> tClasses =
            new ArrayList<Class<? extends Toy>>
                    (Arrays.asList(Doll.class, SmallCar.class,
                            MediumCar.class, LargeCar.class,
                            Ball.class, Block.class));

    private boolean addToyToGameRoom(Toy toy) {
        if (gameRoom.size() < maxToys && money
                + toy.getCost() <= maxMoneys) {
            gameRoom.add(toy);
            return true;
        } else return false;
    }

    private Toy getToy() {
        return toysFabric.getRandomToy();
    }


    private String getOutput(List<Toy> toys) {
        String result = "\nOutput:\n";
        for (Toy toy : toys) {
            result += toy.toString() + "\n";
        }
        result += getResult(toys);
        return result;
    }

    private String getResult(List<Toy> toys) {
        return "\nUsed moneys: " + getTotalCost(toys) +
                " of total: " + maxMoneys +
                "\nUsed toys: " + toys.size() +
                " of total: " + maxToys;
    }

    private double getTotalCost(List<Toy> toys) {
        double result = 0;
        for (Toy toy : toys) {
            result += toy.getCost();
        }
        return result;
    }

    public Controller(int maxToys, double maxMoneys) {
        Price price = new Price(tClasses);
        this.maxToys = maxToys;
        this.maxMoneys = maxMoneys;
        this.gameRoom = new ArrayList<Toy>();
        this.toys = new ArrayList<Toy>();
        this.toysFabric = new ToysFabric(tClasses);
    }

    public void fillGameRoom () {
        while(true) {
            Toy toy = getToy();
            if (!addToyToGameRoom(toy)) break;
            money += toy.getCost();
        }
    }

    public String getOutput() {
        return getOutput(gameRoom);
    }

    public String getResult() {
        return getResult(gameRoom);
    }

    public void sortByCost() {
        gameRoom.sort(new SortByCost());
    }

    public void sortByName() {
        gameRoom.sort(new SortByName());
    }

    public String findByCost(double startCost, double endCost) {
        toys.clear();
        for (Toy toy : gameRoom) {
            if (toy.getCost() >= startCost && toy.getCost() <= endCost) {
                toys.add(toy);
            }
        }
        return getOutput(toys);
    }

}
