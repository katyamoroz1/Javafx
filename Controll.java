package sample;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javafx.stage.Stage;

import javax.imageio.*;
import java.io.File;

public class Controll {
    public Controll() {}

    @FXML
    private Button btn;

    @FXML
    private Canvas canvas;

    @FXML
    private ColorPicker pickColour;

    @FXML
    private Button btn2;

    @FXML
    private void click (ActionEvent event) {
        try {
            Image snapshot = canvas.snapshot(null, null);

            ImageIO.write(SwingFXUtils.fromFXImage(snapshot, null), "png", new File("paint.png"));
        } catch (Exception e) {
           System.out.println("Failed to save image: " + e);
        }
    };

    @FXML
    private void open (ActionEvent event){
        FileChooser openFile = new FileChooser();
        openFile.setTitle("Open File");
        File file = openFile.showOpenDialog(new Stage());
        if (file != null) {
            try {
                InputStream io = new FileInputStream(file);
                Image img = new Image(io);
                GraphicsContext gc = canvas.getGraphicsContext2D();
                gc.drawImage(img, 0, 0);
            } catch (IOException ex) {
                System.out.println("Error!");
            }
        }
    }


    public void initialize() {


        GraphicsContext gc = canvas.getGraphicsContext2D();

        canvas.setOnMouseDragged(e-> {
            gc.setStroke(pickColour.getValue());
            gc.lineTo(e.getX(), e.getY());
            gc.stroke();
            });
        canvas.setOnMouseReleased(e->{
            gc.setStroke(pickColour.getValue());
            gc.lineTo(e.getX(), e.getY());
            gc.stroke();
            gc.closePath();});
        canvas.setOnMousePressed(e->{
            gc.setStroke(pickColour.getValue());
            gc.beginPath();
            gc.lineTo(e.getX(), e.getY());});

    }

}
