package kz.gameRoom.gameRoom.model;


public class Car extends Toy {
    public Car() {
        this(15);
    }

    public Car(int cost) {
        super(cost, "model.Car");
    }
}
