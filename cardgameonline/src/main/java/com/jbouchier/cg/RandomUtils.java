package com.jbouchier.cg;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static int nextRandom(int exclusiveMax) {
        return ThreadLocalRandom.current().nextInt(exclusiveMax);
    }
}
