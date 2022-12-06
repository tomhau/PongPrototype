package sample;

import javafx.scene.paint.Color;

public class Ball {

    private Color color;

    private int x;

    private int y;

    private int w;

    private int h;


    private int DX = 5;
    private int DY = 5;

    public Ball(Color color, int x, int y, int w, int h) {

        this.color = color;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }



    public void setDY(int dy){
        this.DY = dy;
    }


    public Color getColor(){
        return color;
    }


    public int getX() {

        return x;
    }

    public int getY() {

        return y;
    }

    public int getW() {

        return w;
    }

    public int getH() {

        return h;
    }

    // This is too simple can only move down and from left to right

    public synchronized void move(){
        System.out.println("current position of the ball "+this.getX()+","+this.getY());


       setX(x+DX);
       setY(y+DY);
    }
}
