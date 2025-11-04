package com.productivity.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.StackPane;
import java.io.IOException;

public class DashboardController {

    @FXML
    private StackPane contentArea;

    @FXML
    protected void initialize() {
        loadView("tasks.fxml");
    }

    @FXML
    protected void onTasksClicked(ActionEvent event) {
        loadView("tasks.fxml");
    }

    @FXML
    protected void onPomodoroClicked(ActionEvent event) {
        loadView("pomodoro.fxml");
    }

    @FXML
    protected void onNotesClicked(ActionEvent event) {
        loadView("notes.fxml");
    }

    private void loadView(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com.productivity/" + fxml));
            contentArea.getChildren().clear();
            contentArea.getChildren().add(loader.load());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
