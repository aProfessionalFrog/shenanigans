package com.trashthing;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner PInput = new Scanner(System.in);
        Random generator = new Random();
        boolean wrong = true;
        int guess;
        int guesses;
        while (true) {
            System.out.println("Choose a max number!");
            int maxnumber = Math.round(Integer.parseInt(PInput.nextLine()));
            System.out.println("Guess a number from 1 to " + maxnumber);
            int number = generator.nextInt(maxnumber + 1);
            wrong = true;
            guesses = 0;
            while (wrong) {
                guess = Math.round(Integer.parseInt(PInput.nextLine()));
                guesses++;
                if (guess > maxnumber) {
                    System.out.println("That is above the maximum number!");
                } else if (guess > number) {
                    System.out.println("Lower");
                } else if (guess < number) {
                    System.out.println("Higher");
                } else if (guess == number) {
                    System.out.println("🎉You got it in " + guesses + " guesses!🎉");
                    wrong = false;
                } else {
                    System.out.println("Something went wrong.");
                    guesses--;
                }
            }
        }
    }
}
