package com.company;
import processing.core.PApplet;
import processing.core.PSurface;

import static java.lang.Float.valueOf;

public class Main extends PApplet {

    int frameX;
    int frameY;
    int maxX = 400;
    int maxY = 400;
    double playerX = maxX / 2;
    double playerY = maxY / 2;
    boolean left, right, up, down, draggable = false, firstFrame = true, wCanBeDown = true, allowDown = true;
    double playerYVelocity;
    double frameYVelocity;

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
        text(String.valueOf(Math.round(valueOf(frameRate))),7f , 11f);
    }

    static final javax.swing.JFrame getJFrame(final PSurface surface) {
        return (javax.swing.JFrame) ((processing.awt.PSurfaceAWT.SmoothCanvas) surface.getNative()).getFrame();
    }


    public void drawPlayer() {
        playerYVelocity -= 0.1;
        frameYVelocity += 0.1;//gravity up

        if (playerY >= maxY - 1) {//fix
            playerYVelocity = 0;
            frameYVelocity = 0;
        }
        if (playerY <= 0.001) {
            playerYVelocity = 0;
            frameYVelocity=0;
            playerY += 1;
            frameY -= 1;
        }

        playerY -= playerYVelocity;
        frameY += playerYVelocity;
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
                frameY -= 5;
            }
        }

        fill(0, 230, 172);
        rectMode(CENTER);
        playerX = constrain((float) playerX, 0, width);
        playerY = constrain((float) playerY, 0, height);
        rect((float) playerX, (float) playerY, 30, 30);
    }

    public void keyPressed() {
        if (key == 'w' || key == 'W' || key == 32) {
            if (wCanBeDown) {
                wCanBeDown = false;
                allowDown = false;
                playerY -= 1.2;
                frameY += 1.2;
                playerYVelocity += 10;
                frameYVelocity -= 10;
                up = true;

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
        }
    }

    public void keyReleased() {
        if (key == 'w' || key == 'W' || key == 32) {
            wCanBeDown = true;
            allowDown = true;
            up = false;
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
