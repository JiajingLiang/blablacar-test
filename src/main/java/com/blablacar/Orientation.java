package com.blablacar;

public enum Orientation {
    EAST("E"),
    SOUTH("S"),
    WEST("W"),
    NORTH("N");

    private String value;

    Orientation(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Orientation fromString(String text) {
        for (Orientation orientation : Orientation.values()) {
            if (orientation.getValue().equalsIgnoreCase(text)) {
                return orientation;
            }
        }
        return null;
    }
}
