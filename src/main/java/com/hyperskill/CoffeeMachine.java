package com.hyperskill;

import java.util.Scanner;

import static com.hyperskill.TypeCoffee.*;

public class CoffeeMachine {
    private final Scanner scanner = new Scanner(System.in);
    private final Storage storage;
    private int money;
    public MachineState state;

    public CoffeeMachine(Storage storage, int money) {
        this.storage = storage;
        this.money = money;
    }

    public void machineStart() {
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        this.state = MachineState.getType( scanner.next() );
        switch (state) {
            case BUY -> this.buyCaffe();
            case FILL -> this.fillIngredients();
            case TAKE -> this.takeMoney();
            case REMAINING -> this.showStorage();
        }
    }

    private void showStorage() {
        String informationStorage = "\nThe coffee machine has:\n" +
                this.storage.getWater() + " ml of water\n" +
                this.storage.getMilk() + " ml of milk\n" +
                this.storage.getCaffe() + " g of coffee beans\n" +
                this.storage.getCups() + " disposable cups\n" +
                "$" + this.money + " of money";

        System.out.println(informationStorage);
    }

    private void buyCaffe() {
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        TypeCoffee option = TypeCoffee.getType(scanner.next());
        switch (option) {
            case ESPRESSO -> this.prepareCoffee(ESPRESSO);
            case LATTE -> this.prepareCoffee(LATTE);
            case CAPPUCCINO -> this.prepareCoffee(CAPPUCCINO);
            case NOT_EXIT -> System.out.println("Option Not Exist");
        }
    }

    private void prepareCoffee(TypeCoffee typeCoffee) {
        if (this.validateResources( typeCoffee )) {
            System.out.println("I have enough resources, making you a coffee!\n");
            this.storage.setWater( typeCoffee.getWater() == 0 ? this.storage.getWater() : this.storage.getWater() - typeCoffee.getWater() );
            this.storage.setMilk( typeCoffee.getMilk() == 0 ? this.storage.getMilk() : this.storage.getMilk() - typeCoffee.getMilk() );
            this.storage.setCaffe( typeCoffee.getCoffee() == 0 ? this.storage.getCaffe() : this.storage.getCaffe() - typeCoffee.getCoffee() );
            this.storage.setCups( this.storage.getCups() - 1 );
            this.money += typeCoffee.getPrice();
        }
    }

    private boolean validateResources(TypeCoffee typeCoffee) {
        if (this.storage.getWater() < typeCoffee.getWater()) {
            System.out.println("Sorry, not enough water!");
            return false;
        }
        if (this.storage.getMilk() < typeCoffee.getMilk()) {
            System.out.println("Sorry, not enough milk!");
            return false;
        }
        if (this.storage.getCaffe() < typeCoffee.getCoffee()) {
            System.out.println("Sorry, not enough caffe!");
            return false;
        }
        if (this.storage.getCups() == 0) {
            System.out.println("Sorry, not enough cups!");
            return false;
        }
        return true;
    }


    private void fillIngredients() {
        System.out.println("\nWrite how many ml of water you want to add: ");
        this.storage.setWater( this.storage.getWater() + scanner.nextInt() );
        System.out.println("Write how many ml of milk you want to add: ");
        this.storage.setMilk( this.storage.getMilk() + scanner.nextInt() );
        System.out.println("Write how many grams of coffee beans you want to add: ");
        this.storage.setCaffe( this.storage.getCaffe() + scanner.nextInt() );
        System.out.println("Write how many disposable cups you want to add: ");
        this.storage.setCups( this.storage.getCups() + scanner.nextInt() );
    }

    private void takeMoney() {
        if (this.money == 0) {
            System.out.println("The money has been withdrawn");
            return;
        }
        System.out.println("I gave you $" + money);
        this.money = 0;
    }
}