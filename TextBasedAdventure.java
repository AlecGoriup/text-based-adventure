import java.util.Random;
import java.util.Scanner;

public class TextBasedAdventure {
    boolean hasCandyCane = false;
    boolean hasHammer = false;
    Scanner keyboardInput = new Scanner(System.in);

    public void execute() {
        System.out.println("Welcome to Escape from Ikea! Press enter when you are ready to start...");
        keyboardInput.nextLine();
        System.out.println("You are trapped in a Ikea!");
        start();
    }

    public void start() {
        chanceToExplode();
        System.out.println("You find yourself in a showroom. What would you like to do?\n1. Go up the esculator \n2. Go down the esculator");
        int input = keyboardInput.nextInt();
        if (input == 1) {
            goUp();
        }
        else if (input == 2) {
            goDown();
        }
    }

    public void goUp() {
        chanceToExplode();
        System.out.println("Oh no! You run into a giant! Fight or flight?\n1. Fight \n2. Flight");
        int input = keyboardInput.nextInt();
        if (input == 1) {
            fight();
        }
        else if (input == 2) {
            start();
        }  
    }

    public void goDown() {
        chanceToExplode();
        if (!hasCandyCane || !hasHammer) {
            System.out.println("You find a sword and a hammer on the ground! Which would you like?");
            String input = keyboardInput.nextLine();
            if (input.equals("sword")) {
                hasCandyCane = true;
            } else if (input.equals("hammer")) {
                hasHammer = true;
            } else {
                System.out.println("Invalid input.");
            }
        } else {
            System.out.println("There's nothing here...");
        }
        start();
    }
    public void fight() {
        chanceToExplode();
        if (hasCandyCane || hasHammer) {
            System.out.println("You defeat the giant with your weapon and run out of the Ikea!");
        } else {
            System.out.println("You get stomped by the giant and red stuff goes everywhere.");
            
            
        }
    }

    public void chanceToExplode() {
        Random rand = new Random();
        int chanceToExplode = rand.nextInt(1000 - 1) + 1;
        if (chanceToExplode == 420) {
            System.out.println("You spontaniously exploded! Get well soon!");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new TextBasedAdventure().execute();
    }
}