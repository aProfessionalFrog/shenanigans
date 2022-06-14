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
                    TimeUnit.SECONDS.sleep(1);
                System.out.print("You took " + damage + " damage.\n [");
                int roundedHealth = (int) Math.round(playerHealth);
                for (int i = 0; i < 10; i++) {
                    if (i < roundedHealth) {
                        System.out.print("♡");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println("] " + playerHealth + "/10 health");
TimeUnit.SECONDS.sleep(1);
System.out.println("Do you attack the cub? y/n");
                invalid = true;
                while (invalid) {
                    if (Pinput.nextLine().toLowerCase().contains("y")) {
                        System.out.println("The mother hears the cub's cry and strikes you down in one blow.");
                        invalid = false;
                        damage = playerHealth;
                        playerHealth =0;
                        TimeUnit.SECONDS.sleep(1);
                        System.out.print("You took " + damage + " damage.\n [          ");
                        System.out.println("] " + playerHealth + "/10 health");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("You were killed by the bear cub's mother. Although you died, the locals honored your bravery. (good ending)");
                    } else {
                        System.out.println("You run away like a coward.");
                        System.out.println("You took " + playerHealth+" emotional damage.\n [          ] 0/10 health");
                        invalid = false;
                        System.out.println("You died of embarrassment. (bad ending)");
                    }
                }
            } else {
                        System.out.println("You run away like a coward.");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("You took " + playerHealth+" damage.\n [          ] 0/10 health");
                System.out.println("The locals see you as a coward and kill you for your lack of bravery. (bad ending)");
                invalid = false;
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
