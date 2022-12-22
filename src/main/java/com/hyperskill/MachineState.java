package com.hyperskill;

public enum MachineState {
    ON, OFF, MAIN, BUY, FILL, TAKE, REMAINING, EXIT;

    public static MachineState getType(String type) {
        return switch (type) {
            case "buy" -> BUY;
            case "fill" -> FILL;
            case "take" -> TAKE;
            case "remaining" -> REMAINING;
            case "exit" -> EXIT;
            default -> MAIN;
        };
    }
}