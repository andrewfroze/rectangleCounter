package com.training.an;

import java.util.ArrayList;
import java.util.List;

public class DotsStorage {
    private static List<Dot> inputDots = new ArrayList<>();

    static {
        inputDots.add(new Dot(0,0));
        inputDots.add(new Dot(1,0));
        inputDots.add(new Dot(2,0));
        inputDots.add(new Dot(0,1));
        inputDots.add(new Dot(1,1));
        inputDots.add(new Dot(2,1));
        inputDots.add(new Dot(0,2));
        inputDots.add(new Dot(1,2));
        inputDots.add(new Dot(2,2));
    }

    public static List<Dot> getInputDots() {
        return inputDots;
    }


}
