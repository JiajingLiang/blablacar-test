package com.blablacar;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;

public class MainUTest {

    @Test
    public void testRunForFile() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("test.txt").getFile());

        Main.runForFile(new FileReader(file));
    }
}
