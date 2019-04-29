package com.blablacar;


import org.junit.Assert;
import org.junit.Test;

public class OrientationUTest {

    @Test
    public void testFromString() throws Exception {
        Assert.assertEquals(Orientation.EAST, Orientation.fromString("E"));
        Assert.assertEquals(Orientation.SOUTH, Orientation.fromString("S"));
        Assert.assertEquals(Orientation.WEST, Orientation.fromString("W"));
        Assert.assertEquals(Orientation.NORTH, Orientation.fromString("N"));
        Assert.assertNull(Orientation.fromString("X"));
    }

}
