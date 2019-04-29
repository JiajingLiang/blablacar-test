package com.blablacar;

public class Lawn {
    private int leftX;
    private int rightX;
    private int lowerY;
    private int upperY;

    public Lawn(int rightX, int upperY) {
        this.leftX = 0;
        this.rightX = rightX;
        this.lowerY = 0;
        this.upperY = upperY;
    }

    public int getLeftX() {
        return leftX;
    }

    public int getRightX() {
        return rightX;
    }

    public int getLowerY() {
        return lowerY;
    }

    public int getUpperY() {
        return upperY;
    }
}
