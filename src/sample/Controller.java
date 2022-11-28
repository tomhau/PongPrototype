package sample;


import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;


public class Controller {

    @FXML
    Button b_left, b_right;

    @FXML
    Canvas background;



    @FXML
    public void handleLeft(Event e){

        GraphicsContext gc = background.getGraphicsContext2D();

        gc.setFill(Color.PAPAYAWHIP);

        gc.fillRect(300,500,150,40);

    }

    @FXML
    public void handleRight(Event e){
        GraphicsContext gc = background.getGraphicsContext2D();

        gc.clearRect(300,500,150,40);

    }






}
