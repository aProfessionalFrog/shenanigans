package com.company;
import processing.core.PApplet;
import processing.core.PSurface;

import static java.lang.Float.valueOf;
//https://www.msn.com/en-us/news/us/an-elementary-school-thought-it-was-serving-milk-to-students-turns-out-it-was-floor-sealant/ar-AAYxAs1?ocid=winp1taskbar&cvid=57c2fe01f84d444481a94afae70264e6
public class Main extends PApplet {

    int frameX;
    int frameY;
    int LframeY;
    int maxX = 600;
    int maxY = 400;
    double playerX = maxX / 2;
    double LplayerY;
    double playerY = maxY / 2;
    boolean left, right, up, down, draggable = false, firstFrame = true, wCanBeDown = true,firstHit=true;
    double playerYVelocity;
    int gridHeight=30;

    public static void main(String[] args) {
        PApplet.main("com.company.Main");

    }

    public void settings() {
        size(maxX, maxY);
    }

    public void setup() {

    }


    public void draw() {
        background(0);
        noStroke();
        drawPlayer();
        if (firstFrame) {
            firstFrame = false;
            frameX = getJFrame(getSurface()).getX();
            frameY = getJFrame(getSurface()).getY();
        } else {
            if (draggable) {
                frameX = getJFrame(getSurface()).getX();
                frameY = getJFrame(getSurface()).getY();
                playerY = Math.round(maxY / 2);
            } else {
                surface.setLocation(frameX, frameY);
            }
        }
        text(String.valueOf((float)Math.round(valueOf(frameRate)*10)/10),4f , 14f);
    }

    static final javax.swing.JFrame getJFrame(final PSurface surface) {
        return (javax.swing.JFrame) ((processing.awt.PSurfaceAWT.SmoothCanvas) surface.getNative()).getFrame();
    }


    public void drawPlayer() {
        playerYVelocity -= 0.4598364923;
        //window movement
        if(LframeY==frameY){
            frameX = getJFrame(getSurface()).getX();
            frameY = getJFrame(getSurface()).getY();
        }

        if(playerX>= maxX-0.001) {
        frameX+=maxX-5;
        playerX =1;
        }
        if(playerX<= 0.001) {
            frameX-=maxX-5;
            playerX =maxX;
        }
        if (playerY >= maxY - 0.001) {
            playerYVelocity = 0;
        }
        if (playerY <= 0.001) {
            playerYVelocity = -0.1;
            playerY += 1;
        }
        if (playerY==LplayerY){
            playerYVelocity=0;
        }
        LplayerY=playerY;
        playerY -= playerYVelocity;
        if (left) {
                playerX -= 5;
            if (playerX >= 0.001 && playerX <= maxX - 0.001) {
                frameX += 5;
            }
        }
        if (right) {
                playerX += 5;
            if (playerX >= 0.001 && playerX <= maxX - 0.001) {
                frameX -= 5;
            }
        }
        if (down) {
            if (playerY >= 0.001 && playerY <= maxY - 0.001) {
                playerY += 5;
            }
        }

        LframeY=frameY;

        fill(0, 230, 172);
        rectMode(CENTER);
        playerX = constrain((float) playerX, 0, width);
        playerY = constrain((float) playerY, 0, height-gridHeight);
        rect((float) playerX, (float) playerY, (gridHeight/3)*2, (gridHeight/3)*2);
    }

    public void keyPressed() {
        if (key == 'w' || key == 'W' || key == 32) {
                if (playerY==LplayerY) {
                    playerY -= 1.2;
                    playerYVelocity += 11;
                    //up = true;
            }
        }
        if (key == 'a' || key == 'A') {
            left = true;
        }
        if (key == 's' || key == 'S') {
            down = true;
        }
        if (key == 'd' || key == 'D') {
            right = true;
        }
        if (key == 'p' || key == 'P') {
            draggable = !draggable;
            firstHit=true;
        }
    }

    public void keyReleased() {
        if (key == 'w' || key == 'W' || key == 32) {
            //up = false;
        }
        if (key == 'a' || key == 'A') {
            left = false;
        }
        if (key == 's' || key == 'S') {
            down = false;
        }
        if (key == 'd' || key == 'D') {
            right = false;
        }
    }
}
