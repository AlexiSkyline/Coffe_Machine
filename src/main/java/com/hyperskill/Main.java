package com.hyperskill;

public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage(400, 540, 120, 9);
        CoffeeMachine coffeeMachine = new CoffeeMachine(storage, 550);

        while ( coffeeMachine.state != MachineState.EXIT ) {
            coffeeMachine.machineStart();
        }
    }
}