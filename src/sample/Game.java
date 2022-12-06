package sample;

import javafx.scene.paint.Color;

public class Game {
    private final int XMIN = 0;

    private final int XMAX = 800;

    private final int YMIN = 0;

    private final int YMAX = 550;

    private Ball ball;

    private Paddle paddle;

    public Game(){
        paddle = new Paddle(Color.BROWN,300,500,150,40);
        ball = new Ball(Color.RED, 500,0,30,30);
    }


    public Ball getBall() {
        return ball;
    }

    public Paddle getPaddle() {
        return paddle;
    }


    public boolean ballHitWall(){
        boolean hit=false;

        if (this.getBall().getX()+ this.getBall().getW() >=XMAX){
            hit = true;

        }


        return hit;
    }










}
