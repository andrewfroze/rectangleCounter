package com.training.an;

public class Main {

    public static void main(String[] args) {
        System.out.println("All rectangles number: " + RectanglesCounter.countAllRectangles(DotsStorage.getInputDots()));
        System.out.println("Vertical rectangles number: " + RectanglesCounter.countNonDiagonalRectangles(DotsStorage.getInputDots()));
    }
}
