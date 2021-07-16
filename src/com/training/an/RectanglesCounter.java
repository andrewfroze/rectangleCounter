package com.training.an;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public class RectanglesCounter {

    public static int countNonDiagonalRectangles(List<Dot> inputDots) {
        List<DotPair> verticalPairs = DotPair.getVerticalPairs(inputDots);
        int rectanglesNumber = 0;
        for (DotPair pair1 : verticalPairs) {
            for (DotPair pair2 : verticalPairs) {
                if (!pair1.equals(pair2)
                        && pair1.getLength() == pair2.getLength()
                        && pair1.getDot1().getY() == pair2.getDot1().getY()
                        && pair1.getDot1().getX() > pair2.getDot1().getX()) {
                    rectanglesNumber++;
                }
            }
        }
        return rectanglesNumber;
    }

    public static int countAllRectangles(List<Dot> inputDots) {
        int rectanglesCounter = 0;
        Set<DotPair> allPairs = DotPair.getAllPairs(inputDots);
        Map<Double, List<DotPair>> pairsByAngles = new HashMap<>();
        for (DotPair pair : allPairs) {
            if (pairsByAngles.containsKey(pair.getTan())) {
                pairsByAngles.get(pair.getTan()).add(pair);
            } else {
                pairsByAngles.put(pair.getTan(), new ArrayList<>(Collections.singleton(pair)));
            }
        }
        for (DotPair pair: allPairs) {
            if (pair.getTan() >= 0 && pairsByAngles.containsKey(-1 / pair.getTan())) {
                for (DotPair pairPerpendicular1 : pairsByAngles.get(-1 / pair.getTan())) {
                    for (DotPair pairPerpendicular2 : pairsByAngles.get(-1 / pair.getTan())) {
                        if (pairPerpendicular1.getDot1().equals(pair.getDot1())
                                && pairPerpendicular2.getDot1().equals(pair.getDot2())
                                && pairPerpendicular1.getLength() == pairPerpendicular2.getLength()) {
                            rectanglesCounter++;
                        }
                    }
                }
            }
        }
        return rectanglesCounter;
    }
}
