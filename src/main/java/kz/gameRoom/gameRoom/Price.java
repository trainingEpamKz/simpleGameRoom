package kz.gameRoom.gameRoom;

import kz.gameRoom.gameRoom.model.Toy;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;


public class Price {
    private final static String SOURCE_PATH = "price.txt";
    private static Map<Class<? extends Toy>, Double> price;
    private List<Class<? extends Toy>> tClasses;

    private void getPriceFromFile() {
        try {
            Properties properties = new Properties();
            FileInputStream fis = new FileInputStream(SOURCE_PATH);
            properties.load(fis);
            for (int i = 0; i < tClasses.size(); i++) {
                price.put(tClasses.get(i), Double.valueOf(
                        properties.getProperty(
                                tClasses.get(i).getSimpleName())));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Price(List<Class<? extends Toy>> tClasses) {
        price = new HashMap<Class<? extends Toy>, Double>();
        this.tClasses = tClasses;
        getPriceFromFile();
    }

    public static double getPrice(Class<? extends Toy> tClass) {
        return price.get(tClass);
    }

}
