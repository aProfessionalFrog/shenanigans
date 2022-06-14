package com.trashthing;

import java.util.*;
import java.util.concurrent.TimeUnit;


public class Main {
    //i hate comments
    public static void main(String[] args) {

        int playerLevel = 1;
        String playerName;
        double playerHealth = 10.0;
        String randomWord;

        Scanner Pinput = new Scanner(System.in);
        Random generator = new Random();
        TimeUnit time = TimeUnit.valueOf("SECONDS");

        System.out.println("Please choose a name for your character");
        List<String> exclamations = Arrays.asList("admirable", "amazing", "astonishing", "awesome", "brilliant", "cool", "excellent", "fabulous", "fantastic", "incredible", "magnificent", "marvelous", "outstanding", "phenomenal", "remarkable", "superb", "surprising", "terrific", "tremendous", "wondrous", "astounding", "awe-inspiring", "divine", "dynamite", "groovy", "miraculous", "staggering", "startling", "stupendous", "super", "swell", "unheard-of");
        Random rand = new Random();
        playerName = Pinput.nextLine() + " the " + exclamations.get(rand.nextInt(exclamations.size()-1));
        System.out.println("The " + exclamations.get(rand.nextInt(exclamations.size())) + " tale of " + playerName + " begins today!");

        public static void waitFor (TimeUnit time,int x){
            try {
                time.SECONDS.sleep((ling) x);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

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
