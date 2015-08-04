package kz.gameRoom.gameRoom;


import kz.gameRoom.gameRoom.controller.Controller;

/**
 * @author DK
 * @version 1.0.0
 *
 */
public class Run {
    public static void main(String[] args) {
        Controller ctrl = new Controller(10, 120);
        ctrl.fillGameRoom();
        System.out.println(ctrl.getOutput());
        ctrl.sortByCost();
        System.out.println(ctrl.getOutput());
        System.out.println(ctrl.findByCost(6, 12));
    }
}
