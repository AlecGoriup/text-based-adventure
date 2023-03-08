import java.util.Random;
import java.util.Scanner;

public class TextBasedAdventure {
    boolean hasSword = false;
    boolean hasHammer = false;
    Scanner keyboardInput = new Scanner(System.in);

    public void execute() {
        System.out.println("Welcome to Escape from the Cave! Press enter when you are ready to start...");
        keyboardInput.nextLine();
        System.out.println("You are trapped in a cave!");
        start();
    }

    public void start() {
        chanceToExplode();
        System.out.println("You find yourself in a large room. What would you like to do?\n1. Go left \n2. Go right");
        int input = keyboardInput.nextInt();
        if (input == 1) {
            goLeft();
        }
        else if (input == 2) {
            goRight();
        }
    }

    public void goLeft() {
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

    public void goRight() {
        chanceToExplode();
        if (!hasSword || !hasHammer) {
            System.out.println("You find a sword on the ground!");
            hasSword = true;
            hasHammer = true;
        }
        else {
            System.out.println("There's nothing here...");
        }
        start();
    }

    public void fight() {
        chanceToExplode();
        if (hasSword || hasHammer) {
            System.out.println("You defeat the giant with your weapon and run out of the cave!");
        } else {
            System.out.println("You get stomped by the giant and red stuff goes everywhere.");
            
            
        }
    }

    public void chanceToExplode() {
        Random rand = new Random();
        int chanceToExplode = rand.nextInt(0, 10000);
        if (chanceToExplode == 420) {
            System.out.println("You spontaniously exploded! Get well soon!");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new TextBasedAdventure().execute();
    }
}