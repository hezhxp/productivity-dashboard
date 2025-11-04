package com.productivity.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TasksController {
    @FXML
    private ListView<String> taskList;
    @FXML
    private TextField taskInput;
    @FXML
    private Button addButton;
    @FXML
    private Button removeButton;

    private final ObservableList<String> tasks = FXCollections.observableArrayList();
    private final Path saveFile = Path.of("tasks.txt");

    @FXML
    public void initialize() {
        loadTasks();
        taskList.setItems(tasks);
    }

    @FXML
    private void addTask() {
        String task = taskInput.getText().trim();
        if (!task.isEmpty()) {
            tasks.add(task);
            taskInput.clear();
            saveTasks();
        }
    }

    @FXML
    private void removeTask() {
        String selected = taskList.getSelectionModel().getSelectedItem();
        if (selected != null) {
            tasks.remove(selected);
            saveTasks();
        }
    }

    private void saveTasks() {
        try {
            Files.write(saveFile, tasks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadTasks() {
        if (Files.exists(saveFile)) {
            try {
                List<String> lines = Files.readAllLines(saveFile);
                tasks.setAll(lines);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
