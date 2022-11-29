package sample;


import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;


public class Controller {

    @FXML
    Button b_left, b_right,b_start;

    @FXML
    Canvas background,foreground;


    // The model
    Paddle paddle = new Paddle(Color.BROWN,300,500,150,40);

    @FXML
    public void handleLeft(Event e){
        GraphicsContext gc = background.getGraphicsContext2D();
        // sletter den oprindelige paddle
        gc.clearRect(paddle.getX(),paddle.getY(),paddle.getW(),paddle.getH());
        // flytte paddlen til venstre
        paddle.moveLeft();
        // tegne paddlen (igen)
        gc.setFill(paddle.getColor());
        gc.fillRect(paddle.getX(),paddle.getY(),paddle.getW(),paddle.getH());

    }

    @FXML
    public void handleRight(Event e){
        GraphicsContext gc = background.getGraphicsContext2D();

       //  gc.clearRect(300,500,150,40);

    }

    @FXML
    public void handleStart(Event e){
        GraphicsContext gc = background.getGraphicsContext2D();
        gc.setFill(paddle.getColor());
        gc.fillRect(paddle.getX(),paddle.getY(),paddle.getW(),paddle.getH());
    }





}
