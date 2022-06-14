package com.trashthing;

import java.sql.Time;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class Main {
    //i hate comments
    public static void main(String[] args) throws InterruptedException {

        int playerLevel = 1;
        String playerName;
        double playerHealth = 10.0;
        String randomWord;
        boolean invalid = true;

        Scanner Pinput = new Scanner(System.in);
        Random generator = new Random();


        System.out.println("Please choose a name for your character");
        List<String> exclamations = Arrays.asList("admirable", "amazing", "astonishing", "awesome", "brilliant", "cool", "excellent", "fabulous", "fantastic", "incredible", "magnificent", "marvelous", "outstanding", "phenomenal", "remarkable", "superb", "surprising", "terrific", "tremendous", "wondrous", "astounding", "awe-inspiring", "divine", "dynamite", "groovy", "miraculous", "staggering", "startling", "stupendous", "super", "swell", "unheard-of");
        Random rand = new Random();
        playerName = Pinput.nextLine() + " the " + exclamations.get(rand.nextInt(exclamations.size() - 1));
        System.out.println("The " + exclamations.get(rand.nextInt(exclamations.size())) + " tale of " + playerName + " begins today!");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("You approach the mouth of a cave.");
        System.out.println("Do you dare to enter? y/n");
        while (invalid) {
            if (Pinput.nextLine().toLowerCase().contains("y")) {
                System.out.println("You enter the cave fearlessly. However, you made the wrong decision.\n Just seconds after you entered the cave, a bear cub came out and attacked you.");
                invalid = false;
                double damage = ((double) Math.round((generator.nextDouble() * 2 + 1) * 10)) / 10;
                playerHealth -= damage;
                    TimeUnit.MILLISECONDS.sleep(100);
                System.out.print("You took " + damage + " damage.\n [");
                int roundedHealth = (int) Math.round(playerHealth);
                for (int i = 0; i < 10; i++) {
                    if (i < roundedHealth) {
                        System.out.print("♡");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.print("] " + playerHealth + "/10");

            } else if (Pinput.nextLine().toLowerCase().contains("n")) {
                System.out.println("");
                invalid = false;
            } else {
                System.out.println("That is not an option");
            }
        }
        invalid = true;


        /*Random generator = new Random();
        Scanner Pinput;
        String PInput;
        int moneyzzzz;
        Pinput = new Scanner(System.in);
        PInput = Pinput.nextLine();
        if (PInput.contains("money")) {
            moneyzzzz = generator.nextInt(500000);
            System.out.println("You stumble upon the thieves secret cache. You find " + moneyzzzz + " dollars!");
        }*/
    }
}
