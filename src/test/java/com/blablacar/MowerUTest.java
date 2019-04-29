package com.blablacar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MowerUTest {

    private Lawn lawn;

    @Before
    public void init() {
        this.lawn = new Lawn(8, 6);
    }

    @Test
    public void turnRight() throws Exception {
        Mower mower = new Mower(4, 5, Orientation.fromString("E"));

        mower.takeInstruction(Instruction.fromString("R"), this.lawn);
        Assert.assertEquals(4, mower.getX());
        Assert.assertEquals(5, mower.getY());
        Assert.assertEquals(Orientation.SOUTH, mower.getOrientation());

        mower.takeInstruction(Instruction.fromString("R"), this.lawn);
        Assert.assertEquals(4, mower.getX());
        Assert.assertEquals(5, mower.getY());
        Assert.assertEquals(Orientation.WEST, mower.getOrientation());

        mower.takeInstruction(Instruction.fromString("R"), this.lawn);
        Assert.assertEquals(4, mower.getX());
        Assert.assertEquals(5, mower.getY());
        Assert.assertEquals(Orientation.NORTH, mower.getOrientation());

        mower.takeInstruction(Instruction.fromString("R"), this.lawn);
        Assert.assertEquals(4, mower.getX());
        Assert.assertEquals(5, mower.getY());
        Assert.assertEquals(Orientation.EAST, mower.getOrientation());
    }

    @Test
    public void turnLeft() throws Exception {
        Mower mower = new Mower(4, 5, Orientation.fromString("E"));

        mower.takeInstruction(Instruction.fromString("L"), this.lawn);
        Assert.assertEquals(4, mower.getX());
        Assert.assertEquals(5, mower.getY());
        Assert.assertEquals(Orientation.NORTH, mower.getOrientation());

        mower.takeInstruction(Instruction.fromString("L"), this.lawn);
        Assert.assertEquals(4, mower.getX());
        Assert.assertEquals(5, mower.getY());
        Assert.assertEquals(Orientation.WEST, mower.getOrientation());

        mower.takeInstruction(Instruction.fromString("L"), this.lawn);
        Assert.assertEquals(4, mower.getX());
        Assert.assertEquals(5, mower.getY());
        Assert.assertEquals(Orientation.SOUTH, mower.getOrientation());

        mower.takeInstruction(Instruction.fromString("L"), this.lawn);
        Assert.assertEquals(4, mower.getX());
        Assert.assertEquals(5, mower.getY());
        Assert.assertEquals(Orientation.EAST, mower.getOrientation());
    }

    @Test
    public void forwardToEast() throws Exception {
        Mower mower = new Mower(7, 5, Orientation.fromString("E"));

        mower.takeInstruction(Instruction.fromString("F"), this.lawn);
        Assert.assertEquals(8, mower.getX());
        Assert.assertEquals(5, mower.getY());
        Assert.assertEquals(Orientation.EAST, mower.getOrientation());

        mower.takeInstruction(Instruction.fromString("F"), this.lawn);
        Assert.assertEquals(8, mower.getX());
        Assert.assertEquals(5, mower.getY());
        Assert.assertEquals(Orientation.EAST, mower.getOrientation());
    }

    @Test
    public void forwardToSouth() throws Exception {
        Mower mower = new Mower(4, 1, Orientation.fromString("S"));

        mower.takeInstruction(Instruction.fromString("F"), this.lawn);
        Assert.assertEquals(4, mower.getX());
        Assert.assertEquals(0, mower.getY());
        Assert.assertEquals(Orientation.SOUTH, mower.getOrientation());

        mower.takeInstruction(Instruction.fromString("F"), this.lawn);
        Assert.assertEquals(4, mower.getX());
        Assert.assertEquals(0, mower.getY());
        Assert.assertEquals(Orientation.SOUTH, mower.getOrientation());
    }

    @Test
    public void forwardToWest() throws Exception {
        Mower mower = new Mower(1, 5, Orientation.fromString("W"));

        mower.takeInstruction(Instruction.fromString("F"), this.lawn);
        Assert.assertEquals(0, mower.getX());
        Assert.assertEquals(5, mower.getY());
        Assert.assertEquals(Orientation.WEST, mower.getOrientation());

        mower.takeInstruction(Instruction.fromString("F"), this.lawn);
        Assert.assertEquals(0, mower.getX());
        Assert.assertEquals(5, mower.getY());
        Assert.assertEquals(Orientation.WEST, mower.getOrientation());
    }

    @Test
    public void forwardToNorth() throws Exception {
        Mower mower = new Mower(4, 5, Orientation.fromString("N"));

        mower.takeInstruction(Instruction.fromString("F"), this.lawn);
        Assert.assertEquals(4, mower.getX());
        Assert.assertEquals(6, mower.getY());
        Assert.assertEquals(Orientation.NORTH, mower.getOrientation());

        mower.takeInstruction(Instruction.fromString("F"), this.lawn);
        Assert.assertEquals(4, mower.getX());
        Assert.assertEquals(6, mower.getY());
        Assert.assertEquals(Orientation.NORTH, mower.getOrientation());
    }

    @Test
    public void takeInstructions() throws Exception {
        Mower mower1 = new Mower(1, 2, Orientation.fromString("N"));

        List<Instruction> instructions1 = Arrays.asList(Instruction.fromString("L"), Instruction.fromString("F"),
                Instruction.fromString("L"), Instruction.fromString("F"),
                Instruction.fromString("L"), Instruction.fromString("F"),
                Instruction.fromString("L"), Instruction.fromString("F"), Instruction.fromString("F"));

        mower1.takeInstructions(instructions1, new Lawn(5, 5));
        Assert.assertEquals(1, mower1.getX());
        Assert.assertEquals(3, mower1.getY());
        Assert.assertEquals(Orientation.NORTH, mower1.getOrientation());


        Mower mower2 = new Mower(3, 3, Orientation.fromString("E"));

        List<Instruction> instructions2 = Arrays.asList(Instruction.fromString("F"), Instruction.fromString("F"), Instruction.fromString("R"),
                Instruction.fromString("F"), Instruction.fromString("F"), Instruction.fromString("R"),
                Instruction.fromString("F"), Instruction.fromString("R"), Instruction.fromString("R"),
                Instruction.fromString("F"));

        mower2.takeInstructions(instructions2, new Lawn(5, 5));
        Assert.assertEquals(5, mower2.getX());
        Assert.assertEquals(1, mower2.getY());
        Assert.assertEquals(Orientation.EAST, mower2.getOrientation());
    }

    @Test
    public void takeInstructions2() throws Exception {
        Mower mower = new Mower(4, 4, Orientation.fromString("E"));

        List<Instruction> instructions = Arrays.asList(Instruction.fromString("F"), Instruction.fromString("F"), Instruction.fromString("R"),
                Instruction.fromString("F"), Instruction.fromString("F"), Instruction.fromString("R"),
                Instruction.fromString("F"), Instruction.fromString("R"), Instruction.fromString("R"),
                Instruction.fromString("F"));

        mower.takeInstructions(instructions, new Lawn(5, 5));
        Assert.assertEquals(5, mower.getX());
        Assert.assertEquals(2, mower.getY());
        Assert.assertEquals(Orientation.EAST, mower.getOrientation());
    }
}
