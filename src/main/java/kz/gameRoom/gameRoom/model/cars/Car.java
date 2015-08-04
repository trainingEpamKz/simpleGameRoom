package kz.gameRoom.gameRoom.model.cars;


import kz.gameRoom.gameRoom.model.Toy;

public abstract class Car extends Toy {
    public Car() {
        this("Car");
    }

    public Car(String name) {
        super(name);
    }
}
