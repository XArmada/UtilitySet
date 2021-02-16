package com.github.xarmada.utilityset;

import java.util.Random;

public class MathUtils {
    private static final Random RANDOM = new Random();

    
    public static int random(int min, int max) {
        if (max <= min) return min;

        return RANDOM.nextInt(max - min) + min;
    }
}
