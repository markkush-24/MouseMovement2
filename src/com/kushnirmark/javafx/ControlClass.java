package com.kushnirmark.javafx;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;

public class ControlClass extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        URL xml = getClass().getResource("/com/kushnirmark/javafx/hello-view.fxml");
        loader.setLocation(xml);
        Parent root = loader.load();

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Pane pane;

    private boolean traceMouse = false;

    public void initialize() {
        this.progressBar.setProgress(0.0d);
        pane.setOnMouseMoved(e -> {
            if (traceMouse) {
                progressBar.setProgress(progressBar.getProgress() + 0.001);
            }
        });
    }

    public void clickedStart(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount() == 1) {
            traceMouse = true;
        }

    }

    public void clickedStop(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount() == 1) {
            traceMouse = false;
        }
    }

}
