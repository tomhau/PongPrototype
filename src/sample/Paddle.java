package sample;

import javafx.scene.paint.Color;

public class Paddle {

    private Color color;

    private int x;

    private int y;

    private int w;

    private int h;

    private final int STEP = 10;

    public Paddle(Color color, int x, int y, int w, int h) {

        this.color = color;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
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

    public void setX(int x){
        this.x = x;
    }

    public void moveLeft(){
        if((getX() - STEP) <= 0)
            return;
        setX(getX() - STEP);
    }

    public void moveRight(){
        setX(getX() + STEP);
    }
}
