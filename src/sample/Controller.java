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
    // Paddle paddle = new Paddle(Color.BROWN,300,500,150,40);
    // Ball ball = new Ball(Color.RED, 0,0,30,30);

    Game game = new Game();



    @FXML
    public void handleLeft(Event e){
        System.out.println("current position of the paddle "+game.getPaddle().getX()+","+game.getPaddle().getY());
        // slette den oprindelige paddle
        erasePaddle();
        // flytte paddlen til venstre
        game.getPaddle().moveLeft();
        // tegne paddlen (igen)
        drawPaddle();
    }

    @FXML
    public void handleRight(Event e){
        System.out.println("current position of the paddle "+game.getPaddle().getX()+","+game.getPaddle().getY());
        // slette den oprindelige paddle
        erasePaddle();
        // flytte paddlen til højre
        game.getPaddle().moveRight();
        // tegne paddlen (igen)
        drawPaddle();
    }

    @FXML
    public void handleStart(Event e){
        init();
        drawBall();
        drawPaddle();
    }

    public synchronized void drawBall(){
        GraphicsContext gc = foreground.getGraphicsContext2D();
        gc.setFill(game.getBall().getColor());
        gc.fillOval(game.getBall().getX(),game.getBall().getY(),game.getBall().getW(),game.getBall().getH());
    }

    public synchronized void drawPaddle(){
        GraphicsContext gc = background.getGraphicsContext2D();
        gc.setFill(game.getPaddle().getColor());
        gc.fillRect(game.getPaddle().getX(),game.getPaddle().getY(),game.getPaddle().getW(),game.getPaddle().getH());
    }

    public synchronized void eraseBall(){
        GraphicsContext gc = foreground.getGraphicsContext2D();
        gc.clearRect(game.getBall().getX(),game.getBall().getY(),game.getBall().getW(),game.getBall().getH());

    }

    public synchronized void erasePaddle(){
        GraphicsContext gc = background.getGraphicsContext2D();
        gc.clearRect(game.getPaddle().getX(),game.getPaddle().getY(),game.getPaddle().getW(),game.getPaddle().getH());

    }



    public void init(){
        Timer timer = new Timer();
        TimerTask task;

        task = new TimerTask(){
            @Override
            public void run(){



                // slette den oprindelige bold
                eraseBall();
                // flytte bolden
                game.getBall().move();

                boolean hit = game.ballHitWall();

                System.out.println("hit="+hit);

                // tegne bolden
                drawBall();
            }
        };

        timer.schedule(task,1000, 100);


    }



}
