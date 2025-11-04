package com.productivity.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class NotesController {

    @FXML
    private TextArea notesArea;
    @FXML
    private Button saveButton;

    private final Path notesFile = Path.of("notes.txt");

    @FXML
    public void initialize() {
        loadNotes();
    }

    @FXML
    private void saveNotes() {
        try {
            Files.writeString(notesFile, notesArea.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadNotes() {
        try {
            if (Files.exists(notesFile)) {
                notesArea.setText(Files.readString(notesFile));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void switchToDashboard(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com.productivity/dashboard.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
