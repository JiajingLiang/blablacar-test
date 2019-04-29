package com.blablacar;

public enum Instruction {
    LEFT("L"),
    RIGHT("R"),
    FORWARD("F");

    private String value;

    Instruction(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Instruction fromString(String text) {
        for (Instruction instruction : Instruction.values()) {
            if (instruction.getValue().equalsIgnoreCase(text)) {
                return instruction;
            }
        }
        return null;
    }
}
