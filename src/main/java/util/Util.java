package util;

import java.util.Random;

public class Util {

    public static long uniqueId() {
        Random random =new Random();
        return Math.abs(random.nextLong());
    }
}
