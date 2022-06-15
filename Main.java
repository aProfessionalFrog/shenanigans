package com.company;

import javafx.scene.Scene;
import processing.core.PApplet;
import processing.core.PSurface;

public class Main extends PApplet {

    int frameX;
    int frameY;
    int maxX= 400;
    int maxY= 400;
    float playerX = maxX/2;
    float playerY = maxY/2;
    boolean left, right, up, down, draggable = false, firstFrame=false;

    public static void main(String[] args) {
        PApplet.main("com.company.Main");
    }

    public void settings() {
        size(maxX, maxY);
    }

    public void setup() {

    }

    public void draw() {
        background(250);
        noStroke();
        drawPlayer();
        if (firstFrame=false){
            firstFrame=true;
            
        }
        if (draggable) {
            frameX = getJFrame(getSurface()).getX();
            frameY = getJFrame(getSurface()).getY();
            playerY=Math.round(maxY/2);
        } else {
              surface.setLocation(frameX, frameY);
        }
    }

    static final javax.swing.JFrame getJFrame(final PSurface surface) {
        return (javax.swing.JFrame) ((processing.awt.PSurfaceAWT.SmoothCanvas) surface.getNative()).getFrame();
    }

    public void drawPlayer() {
        if (up) {
            playerY -= 5;
                if (playerY>=0.001&&playerY<=maxY-0.001) {
                    frameY += 5;
                }
        }
        if (left) {
            playerX -= 5;
            if (playerX>=0.001&&playerX<=maxX-0.001) {
                frameX += 5;
            }
        }
        if (right) {
            playerX += 5;
            if (playerX>=0.001&&playerX<=maxX-0.001) {
                frameX -= 5;
            }
        }
        if (down) {
            playerY += 5;
            if (playerY>=0.001&&playerY<=maxY-0.001) {
                frameY -= 5;
            }
        }


        fill(0, 230, 172);
        rectMode(CENTER);
        playerX = constrain(playerX, 0, width);
        playerY = constrain(playerY, 0, height);
        rect(playerX, playerY, 30, 30);
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
        if (key == 'p') {
            draggable = !draggable;
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
