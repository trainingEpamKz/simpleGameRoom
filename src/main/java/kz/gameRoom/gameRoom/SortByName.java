package kz.gameRoom.gameRoom;


import kz.gameRoom.gameRoom.model.Toy;

import java.util.Comparator;

public class SortByName implements Comparator<Toy> {
    public int compare(Toy o1, Toy o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
