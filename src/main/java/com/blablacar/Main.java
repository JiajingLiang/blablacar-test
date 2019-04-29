package com.blablacar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main {

    private static CmdExtractor cmdExtractor = new CmdExtractor();

    public static void main(String args[]) {
        if(args.length != 1) {
            System.out.println("Input file must be provided!");
        }

        try {
            runForFile(new FileReader(args[0]));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void runForFile(FileReader fileReader) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(fileReader);

            // read first line
            String line = reader.readLine();
            final Lawn lawn = cmdExtractor.extractLawn(line);

            // read the rest lines of the file
            line = reader.readLine();
            int counter = 0;
            Mower mower = null;
            List<Instruction> instructions = null;

            while (line != null) {
                if (counter % 2 == 0) {
                    mower = cmdExtractor.extractMower(line);
                } else {
                    instructions = cmdExtractor.extractInstructions(line);
                    mower.takeInstructions(instructions, lawn);
                    System.out.println(mower.toString());
                }

                // read next line
                line = reader.readLine();
                counter++;
            }
            reader.close();
        } catch (IOException | InvalidInputException e) {
            e.printStackTrace();
        }
    }
}
