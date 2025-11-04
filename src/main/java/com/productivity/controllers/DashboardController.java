package com.productivity.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class DashboardController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void switchToPomodoro(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com.productivity/pomodoro.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToTasks(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com.productivity/tasks.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToNotes(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com.productivity/notes.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
