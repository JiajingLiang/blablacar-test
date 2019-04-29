package com.blablacar;

import java.util.List;

public class Mower {
    private int x;
    private int y;
    private Orientation orientation;

    public Mower(int x, int y, Orientation orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void takeInstructions(List<Instruction> instructions, Lawn lawn) {
        for (Instruction instruction : instructions) {
            this.takeInstruction(instruction, lawn);
        }
    }


    public void takeInstruction(Instruction instruction, Lawn lawn) {
        switch (instruction) {
            case LEFT:
                this.turnLeft();
                break;
            case RIGHT:
                this.turnRight();
                break;
            case FORWARD:
                this.forward(lawn);
                break;
        }
    }

    private void turnLeft() {
        switch (this.orientation) {
            case EAST:
                this.orientation = Orientation.NORTH;
                break;
            case SOUTH:
                this.orientation = Orientation.EAST;
                break;
            case WEST:
                this.orientation = Orientation.SOUTH;
                break;
            case NORTH:
                this.orientation = Orientation.WEST;
                break;
        }

    }

    private void turnRight() {
        switch (this.orientation) {
            case EAST:
                this.orientation = Orientation.SOUTH;
                break;
            case SOUTH:
                this.orientation = Orientation.WEST;
                break;
            case WEST:
                this.orientation = Orientation.NORTH;
                break;
            case NORTH:
                this.orientation = Orientation.EAST;
                break;
        }

    }

    private void forward(Lawn lawn) {
        switch (this.orientation) {
            case EAST:
                if (this.x < lawn.getRightX()) {
                    this.x += 1;
                }
                break;
            case SOUTH:
                if (this.y > lawn.getLowerY()) {
                    this.y -= 1;
                }
                break;
            case WEST:
                if (this.x > lawn.getLeftX()) {
                    this.x -= 1;
                }
                break;
            case NORTH:
                if (this.y < lawn.getUpperY()) {
                    this.y += 1;
                }
                break;
        }
    }

    @Override
    public String toString() {
        return this.x + " " + this.y + " " + this.orientation.getValue();
    }
}
