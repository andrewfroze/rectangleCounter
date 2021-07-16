package com.training.an;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Objects;

public class DotPair {
    private final Dot dot1;
    private final Dot dot2;
    private final double tanToHorizon;
    private final double length;

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
        this.length = Math.sqrt(Math.pow(dot2.getX() - dot1.getX(), 2) + Math.pow(dot2.getY() - dot1.getY(), 2));
        this.tanToHorizon = ((double) this.dot2.getY() - this.dot1.getY()) / (this.dot2.getX() - this.dot1.getX());
    }

    public Dot getDot1() {
        return dot1;
    }

    public Dot getDot2() {
        return dot2;
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
            inputDots.stream().filter(dot2 -> dot1.getX() == dot2.getX() && dot1.getY() < dot2.getY())
                    .forEach(dot2 -> verticalPairs.add(new DotPair(dot1, dot2)));
        }
        return verticalPairs;
    }

    public static Set<DotPair> getAllPairs (List<Dot> inputDots) {
        Set<DotPair> allPairs = new HashSet<>();
        for (Dot dot1: inputDots) {
            inputDots.stream().filter(dot2 -> !dot1.equals(dot2))
                    .forEach(dot2 -> allPairs.add(new DotPair(dot1, dot2)));
        }
        return allPairs;
    }

    public double getTan() {
        return tanToHorizon == Double.POSITIVE_INFINITY ? Double.NEGATIVE_INFINITY : tanToHorizon;
    }

    public double getLength() {
        return length;
    }
}
