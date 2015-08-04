package kz.gameRoom.gameRoom;


import kz.gameRoom.gameRoom.model.Toy;

import java.util.Random;

public class ToysFabric {
    private Class[] classes;
    private Random rand = new Random(47);

    public ToysFabric(Class<? extends Toy> ... classes) {
        this.classes = classes;
    }

    public Toy getRandomToy() {
        try {
            return (Toy) classes[rand.nextInt(classes.length)].newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
