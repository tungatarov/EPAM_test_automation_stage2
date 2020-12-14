package Threads.enums;

import java.util.Random;

public enum ShipCapacity {
    MIDDLE(10),
    LARGE(20);

    int capacity;
    private static final ShipCapacity[] VALUES = values();
    private static final Random RANDOM = new Random();

    ShipCapacity(int capacity){
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public static ShipCapacity getRandomCapacity()  {
        return VALUES[RANDOM.nextInt(VALUES.length)];
    }
}
