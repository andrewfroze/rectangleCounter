package com.training.an;

import java.util.List;

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
}
