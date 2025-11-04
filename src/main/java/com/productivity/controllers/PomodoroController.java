package com.productivity.controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class PomodoroController {
    @FXML
    private Label timerLabel;
    @FXML
    private Button startButton;
    @FXML
    private Button resetButton;

    private Timeline timeline;
    private int seconds = 25 * 60; // 25 minutes default
    private boolean running = false;

    @FXML
    public void initialize() {
        updateLabel();
    }

    @FXML
    private void startTimer() {
        if (running) return;
        running = true;
        timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), e -> {
                    seconds--;
                    updateLabel();
                    if (seconds <= 0) {
                        timeline.stop();
                        running = false;
                        timerLabel.setText("Break time!");
                    }
                })
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    @FXML
    private void resetTimer() {
        if (timeline != null) timeline.stop();
        running = false;
        seconds = 25 * 60;
        updateLabel();
    }

    private void updateLabel() {
        int mins = seconds / 60;
        int secs = seconds % 60;
        timerLabel.setText(String.format("%02d:%02d", mins, secs));
    }
}
