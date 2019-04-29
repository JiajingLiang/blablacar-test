package com.blablacar;

import org.junit.Assert;
import org.junit.Test;

public class InstructionUTest {

    @Test
    public void testFromString() throws Exception {
        Assert.assertEquals(Instruction.LEFT, Instruction.fromString("L"));
        Assert.assertEquals(Instruction.RIGHT, Instruction.fromString("R"));
        Assert.assertEquals(Instruction.FORWARD, Instruction.fromString("F"));
        Assert.assertNull(Instruction.fromString("X"));
    }

}
