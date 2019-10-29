package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-background-color: lavender;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: darkred;");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Paint");
        stage.setWidth(500);
        stage.setHeight(400);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
