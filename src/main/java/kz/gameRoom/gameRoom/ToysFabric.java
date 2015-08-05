package kz.gameRoom.gameRoom;

import kz.gameRoom.gameRoom.model.Toy;

import java.util.List;
import java.util.Random;

public class ToysFabric {
    private List<Class<? extends Toy>> tClasses;
    private Random rand = new Random(47);

    public ToysFabric(List<Class<? extends Toy>> tClasses) {
        this.tClasses = tClasses;
    }

    public Toy getRandomToy() {
        return genRandomToy();
    }

    private Toy genRandomToy() {
        try {
            return tClasses.get(rand.nextInt(tClasses.size())).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
