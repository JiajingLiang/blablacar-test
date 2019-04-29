package com.blablacar;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class CmdExtractor {

    public Lawn extractLawn(String line) throws InvalidInputException {
        try {
            if(line == null) {
                throw new InvalidInputException("Invalid input for Lawn parameters");
            }

            String[] strArr = line.split(" ");
            if (strArr.length != 2) {
                throw new InvalidInputException("Invalid input for Lawn parameters");
            }

            int rightX = Integer.valueOf(strArr[0]);
            int upperY = Integer.valueOf(strArr[1]);
            return new Lawn(rightX, upperY);
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Invalid input for Lawn parameters", e);
        }
    }

    public Mower extractMower(String line) throws InvalidInputException {
        try {
            if(line == null) {
                throw new InvalidInputException("Invalid input for Lawn parameters");
            }

            String[] strArr = line.split(" ");
            if (strArr.length != 3) {
                throw new InvalidInputException("Invalid input for Mower parameters");
            }

            int x = Integer.valueOf(strArr[0]);
            int y = Integer.valueOf(strArr[1]);
            Orientation orientation = Optional.ofNullable(Orientation
                    .fromString(strArr[2]))
                    .orElseThrow(() -> new InvalidInputException("Invalid input for Mower parameters"));
            return new Mower(x, y, orientation);
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Invalid input for Lawn parameters", e);
        }
    }

    public List<Instruction> extractInstructions(String line) {
        return Arrays.stream(line.split(""))
                .map(Instruction::fromString)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
