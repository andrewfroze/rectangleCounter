package com.training.an;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DotPair {
    private Dot dot1;
    private Dot dot2;

    public DotPair(Dot dot1, Dot dot2) {
        if (dot1.getY() < dot2.getY()) {
            this.dot1 = dot1;
            this.dot2 = dot2;
        } else if (dot1.getY() > dot2.getY()) {
            this.dot1 = dot2;
            this.dot2 = dot1;
        } else if (dot1.getX() <= dot2.getX()) {
            this.dot1 = dot1;
            this.dot2 = dot2;
        } else {
            this.dot1 = dot2;
            this.dot2 = dot1;
        }
    }

    public Dot getDot1() {
        return dot1;
    }

    public void setDot1(Dot dot1) {
        this.dot1 = dot1;
    }

    public Dot getDot2() {
        return dot2;
    }

    public void setDot2(Dot dot2) {
        this.dot2 = dot2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DotPair dotPair = (DotPair) o;
        return (dot1.equals(dotPair.dot1) && dot2.equals(dotPair.dot2)) ||
                (dot1.equals(dotPair.dot2) && dot2.equals(dotPair.dot1));
    }

    @Override
    public int hashCode() {
        return Objects.hash(dot1, dot2);
    }

    public static List<DotPair> getVerticalPairs(List<Dot> inputDots) {
        List<DotPair> verticalPairs = new ArrayList<>();
        for (Dot dot1 : inputDots) {
            for (Dot dot2 : inputDots) {
                if (dot1.getX() == dot2.getX() && dot1.getY() < dot2.getY()) {
                    verticalPairs.add(new DotPair(dot1, dot2));
                }
            }
        }
        return verticalPairs;
    }

    public double getLength () {
        int deltaX = Math.abs(dot2.getX() - dot1.getX());
        int deltaY = Math.abs(dot2.getY() - dot1.getY());
        return Math.sqrt(Math.pow(deltaX,2) + Math.pow(deltaY,2));
    }
}
