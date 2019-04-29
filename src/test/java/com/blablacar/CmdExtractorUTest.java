package com.blablacar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CmdExtractorUTest {

    private CmdExtractor cmdExtractor;

    @Before
    public void init() {
        this.cmdExtractor = new CmdExtractor();
    }

    @Test(expected = InvalidInputException.class)
    public void testExtractLawnWithInvalidInput0() throws Exception {
        this.cmdExtractor.extractLawn(null);
    }

    @Test(expected = InvalidInputException.class)
    public void testExtractLawnWithInvalidInput1() throws Exception {
        this.cmdExtractor.extractLawn("3");
    }

    @Test(expected = InvalidInputException.class)
    public void testExtractLawnWithInvalidInput2() throws Exception {
        this.cmdExtractor.extractLawn("3 S");
    }

    @Test
    public void testExtractLawn() throws Exception {
        Lawn lawn = this.cmdExtractor.extractLawn("3 4");
        Assert.assertEquals(0, lawn.getLeftX());
        Assert.assertEquals(3, lawn.getRightX());
        Assert.assertEquals(0, lawn.getLowerY());
        Assert.assertEquals(4, lawn.getUpperY());
    }

    @Test(expected = InvalidInputException.class)
    public void testExtractMowerWithInvalidInput0() throws Exception {
        this.cmdExtractor.extractMower(null);
    }

    @Test(expected = InvalidInputException.class)
    public void testExtractMowerWithInvalidInput1() throws Exception {
        this.cmdExtractor.extractMower("3");
    }

    @Test(expected = InvalidInputException.class)
    public void testExtractMowerWithInvalidInput2() throws Exception {
        this.cmdExtractor.extractMower("3 S E");
    }

    @Test(expected = InvalidInputException.class)
    public void testExtractMowerWithInvalidInput3() throws Exception {
        this.cmdExtractor.extractMower("3 3 X");
    }

    @Test
    public void testExtractMower() throws Exception {
        Mower mower = this.cmdExtractor.extractMower("3 4 E");
        Assert.assertEquals(3, mower.getX());
        Assert.assertEquals(4, mower.getY());
        Assert.assertEquals(Orientation.EAST, mower.getOrientation());
    }

    @Test
    public void testExtractInstructionsWithInvalidInput() throws Exception {
        List<Instruction> instructions = this.cmdExtractor.extractInstructions("REF");

        Assert.assertEquals(2, instructions.size());
        Assert.assertEquals(Instruction.RIGHT, instructions.get(0));
        Assert.assertEquals(Instruction.FORWARD, instructions.get(1));
    }

    @Test
    public void testExtractInstructions() throws Exception {
        List<Instruction> instructions = this.cmdExtractor.extractInstructions("LFR");

        Assert.assertEquals(3, instructions.size());
        Assert.assertEquals(Instruction.LEFT, instructions.get(0));
        Assert.assertEquals(Instruction.FORWARD, instructions.get(1));
        Assert.assertEquals(Instruction.RIGHT, instructions.get(2));
    }
}
