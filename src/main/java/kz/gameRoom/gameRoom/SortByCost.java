package kz.gameRoom.gameRoom;


import kz.gameRoom.gameRoom.model.Toy;

import java.util.Comparator;

public class SortByCost implements Comparator<Toy> {
    public int compare(Toy o1, Toy o2) {
        return ((Double) o1.getCost()).compareTo(o2.getCost());
    }
}
