package machine;

import java.util.Scanner;

public class CoffeeMachine {

    private int waterQuantity = 400;
    private int milkQuantity = 540;
    private int beansQuantity = 120;
    private int cupsQuantity = 9;
    private int money = 550;



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        boolean machineOn = true;

        while (machineOn) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.next();

            if (action.toLowerCase().equals("buy")) {
                coffeeMachine.buy(scanner, coffeeMachine);
            }
            ;

            if (action.toLowerCase().equals("fill")) {
                coffeeMachine.fill(scanner, coffeeMachine);
            }
            ;

            if (action.toLowerCase().equals("take")) {
                coffeeMachine.take(scanner, coffeeMachine);
            }
            ;

            if (action.toLowerCase().equals("remaining")) {
                coffeeMachine.printState();
            }
            ;

            if (action.toLowerCase().equals("exit")) {
                machineOn = false;
            }
            ;

        }


    }

    public void printState() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d of water%n", this.waterQuantity);
        System.out.printf("%d of milk%n", this.milkQuantity);
        System.out.printf("%d of coffee beans%n", this.beansQuantity);
        System.out.printf("%d of disposable cups%n", this.cupsQuantity);
        System.out.printf("%d of money%n%n", this.money);
    }

    public void buy(Scanner scanner, CoffeeMachine coffeeMachine) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");

        String choice = scanner.next();


        if (choice.equals("1")) {
            coffeeMachine.buyProductAdjustInventory(0, 250, 16, 1, 4);

        } else if (choice.equals("2")) {
            coffeeMachine.buyProductAdjustInventory(75, 350, 20, 1, 7);

        } else if (choice.toLowerCase().equals("back")) {
          return;

        } else {
            coffeeMachine.buyProductAdjustInventory(100, 200, 12, 1, 6);

        }

    }

    public void buyProductAdjustInventory(int milk, int water, int beans, int cups, int money) {
        if (this.waterQuantity - water > 0 && this.milkQuantity - milk > 0 && this.beansQuantity - beans > 0
                && this.cupsQuantity - cups > 0) {
            this.waterQuantity = this.waterQuantity - water;
            this.milkQuantity = this.milkQuantity - milk;
            this.beansQuantity = this.beansQuantity - beans;
            this.cupsQuantity = this.cupsQuantity - cups;
            this.money = this.money + money;

            System.out.println("I have enough resources, making you a coffee!");
        } else {
            System.out.println("can't make a cup of coffee");
        }
    }

    public void fill(Scanner scanner, CoffeeMachine coffeeMachine) {
        System.out.println("Write how many ml of water do you want to add:");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        int beans = scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int cups = scanner.nextInt();

        this.waterQuantity = this.waterQuantity + water;
        this.milkQuantity = this.milkQuantity + milk;
        this.beansQuantity = this.beansQuantity + beans;
        this.cupsQuantity = this.cupsQuantity + cups;


    }

    public void take(Scanner scanner, CoffeeMachine coffeeMachine) {
        System.out.printf("I gave you %d%n", this.money);
        this.money -= this.money;

    }

}



/* PREVIOUS EXCERCISE */
// System.out.printf("%s%n%s%n%s%n%s%n%s%n%s%n%s",startCoffee,grindBeans,boilWater,addBeans,addCoffee,addMilk,ready);

// System.out.println("Write how many cups of coffee you will need: ");
// int numberOfCoffees = scanner.nextInt();

// System.out.printf("For %d cups of coffee you will need:%n",numberOfCoffees);
// System.out.printf("%d ml of water%n",numberOfCoffees*200);
// System.out.printf("%d ml of milk%n",numberOfCoffees*50);
// System.out.printf("%d g of coffee beans%n",numberOfCoffees*15);
/*
        System.out.println("Write how many ml of water the coffee machine has:");
                int water = scanner.nextInt();
                System.out.println("Write how many ml of milk the coffee machine has:");
                int milk = scanner.nextInt();
                System.out.println("Write how many grams of coffee beans the coffee machine has:");
                int beans = scanner.nextInt();
                System.out.println("Write how many cups of coffee you will need: ");
                int numberOfCoffees = scanner.nextInt();

                int canMake = Math.min(Math.min(water/200, milk/50), beans/15);
                if(water/(numberOfCoffees*200) > 0 && milk/(numberOfCoffees*50) > 0 && beans/(numberOfCoffees*15) > 0){
                int canMakeMore = numberOfCoffees-canMake;
                if(canMakeMore==0){
                System.out.println("Yes, I can make that amount of coffee");
                }else {
                System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)", canMakeMore);
                }
                }else{
                System.out.printf("No, I can make only %d cup(s) of coffee", canMake);
                }
*/