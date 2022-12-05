package sample;


import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;


import java.util.Timer;
import java.util.TimerTask;


public class Controller {

    @FXML
    Button b_left, b_right,b_start;

    @FXML
    Canvas background,foreground;


    // The models (so far)
    Paddle paddle = new Paddle(Color.BROWN,300,500,150,40);
    Ball ball = new Ball(Color.RED, 0,0,30,30);



    @FXML
    public void handleLeft(Event e){
        System.out.println("current position of the paddle "+paddle.getX()+","+paddle.getY());
        // slette den oprindelige paddle
        erasePaddle();
        // flytte paddlen til venstre
        paddle.moveLeft();
        // tegne paddlen (igen)
        drawPaddle();
    }

    @FXML
    public void handleRight(Event e){
        System.out.println("current position of the paddle "+paddle.getX()+","+paddle.getY());
        // slette den oprindelige paddle
        erasePaddle();
        // flytte paddlen til højre
        paddle.moveRight();
        // tegne paddlen (igen)
        drawPaddle();
    }

    @FXML
    public void handleStart(Event e){
        init();
        drawBall();
        drawPaddle();
    }

    public void drawBall(){
        GraphicsContext gc = foreground.getGraphicsContext2D();
        gc.setFill(ball.getColor());
        gc.fillOval(ball.getX(),ball.getY(),ball.getW(),ball.getH());
    }

    public void drawPaddle(){
        GraphicsContext gc = background.getGraphicsContext2D();
        gc.setFill(paddle.getColor());
        gc.fillRect(paddle.getX(),paddle.getY(),paddle.getW(),paddle.getH());
    }

    public void eraseBall(){
        GraphicsContext gc = foreground.getGraphicsContext2D();
        gc.clearRect(ball.getX(),ball.getY(),ball.getW(),ball.getH());

    }

    public void erasePaddle(){
        GraphicsContext gc = background.getGraphicsContext2D();
        gc.clearRect(paddle.getX(),paddle.getY(),paddle.getW(),paddle.getH());

    }



    public void init(){
        Timer timer = new Timer();
        TimerTask task;

        task = new TimerTask(){
            @Override
            public void run(){

                System.out.println("current position of the ball "+ball.getX()+","+ball.getY());


                // slette den oprindelige bold
                eraseBall();
                // flytte bolden
                ball.move();
                // tegne bolden
                drawBall();
            }
        };

        timer.schedule(task,1000, 1000);


    }



}
