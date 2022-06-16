package project;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Float.valueOf;

 //// This Is The Setup For The Window And Game \\\\
public class project extends PApplet {

    public int playerX = 40;
    public int GRAVITY = 1;
    public int TERMINAL_VELOCITY = 4;
    public int vertical_speed = 0;

    public int playerY = 40;
    boolean left, right, up, down;
    public boolean pressable;
    public int delay = 0;
    public List<Obstacle> enemyList = new ArrayList<>();
    public int enemyDelay = 50;
    public int count = 0;
    public Obstacle jon;
    int gridHeight=30;

    public static void main(String[] args) {
        PApplet.main("project.project");
    }
    public void settings() {
        size(500, 200);
    }

    public void setup() {
        pressable = true;
        jon = new Obstacle(500, 150, "rectangle",4);
        enemyList.add(jon);
    }

     //// This Is The Gravity For The Game \\\\
    public void fall () {
            vertical_speed = vertical_speed + GRAVITY;
            if (vertical_speed > TERMINAL_VELOCITY)
            {
                vertical_speed = TERMINAL_VELOCITY;
            }
            playerY = playerY + vertical_speed;
    }

    public void draw() {
        background(0);
        noStroke();
        drawPlayer();
        fall();
        fps();
        checkcolision();
        for (Obstacle check : enemyList) {
            check.update();
            fill(255, 255, 255);
            rect(check.xLoc, check.yLoc, check.xsize, check.ysize);
        }
        if (count == enemyDelay){
            count = 0;
            enemyList.add(new Obstacle(500, (int)(Math.random()*height), "rectangle", (int)(Math.random()*5)+1));
        } else {
            count++;
        }
        if (!pressable){
            delay++;
            if (delay == 20){
                delay = 0; // THIS IS WHAT RAPTOR ADDED
                pressable = true;
            }
        }
      ///// This Is The Fps Counter Code \\\\
    }

     public void fps() {
        fill(0, 230, 50);
        text(String.valueOf(Math.round(frameRate)),7f , 11f);
    }

    //// collision and physics \\\\
     public void checkcolision() {
         for (Obstacle check : enemyList) {
             if (playerX + 10 > check.xLoc && playerX + 10 < check.xLoc + check.xsize && playerX + 10 > check.xLoc && playerX + 10 < check.xLoc + check.xsize) {
                 //// take away + 10 for x\\\\
                 if (playerY > check.yLoc && playerY < check.yLoc + check.ysize && playerY + 10 > check.yLoc && playerY + 10 < check.yLoc + check.ysize) {
                     System.out.println("CollidedY");
                     exit();
                 }
             }
         }
     }

    //// PLayer Mechanics And the Color And Fill \\\\
    public void drawPlayer() {
       playerY++;

        if (up) {
            playerY -= 11;
        }
        if (left) {
            playerX -= 3;
        }
        if (right) {
            playerX += 3;
        }
        if (down) {
            playerY += 3;
        }
        if (playerY > height - 5) {
            playerY = height -5;
        }
        fill(0, 530, 550);
        rectMode(CENTER);
        playerX = constrain(playerX, 0, width);
        playerY = constrain(playerY, 0, height);
        rect(playerX, playerY, 10, 10);
        fill(0, 0, 0);
        rect(playerX, playerY, 5, 5);
    }

    public void keyPressed() {
        if (key == 'w') {
            up = true;
        }
        if (key == 'a') {
            left = true;
        }
        if (key == 's') {
            down = true;
        }
        if (key == 'd') {
            right = true;
        }
        if (key == ' ' && pressable) {
            pressable = false;
            vertical_speed = -14;
        }
    }

    public void keyReleased() {
        if (key == 'w') {
            up = false;
        }
        if (key == 'a') {
            left = false;
        }
        if (key == 's') {
            down = false;
        }
        if (key == 'd') {
            right = false;
        }
    }
}
