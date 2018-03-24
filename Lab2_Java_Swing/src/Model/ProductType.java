package Model;

import java.util.Random;

public enum ProductType {
    VEHICLE,
    MATCH;

    public static ProductType getRandom(){
        Random random = new Random();
        return ProductType.values()[random.nextInt(ProductType.values().length)];
    }
}
