package com.uopeople.studenttaskmanagerunit6.app;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.time.LocalDate;

public class TaskManagerLayout extends Application {

    @Override
    public void start(Stage stage) {

        // Header
        Label heading = new Label("Student Task Manager");
        heading.setStyle(
                "-fx-font-size: 25px;"
                        + "-fx-font-weight: bold;"
                        + "-fx-text-fill: white;"
        );

        Label subtitle = new Label(
                "Manage assignments and exams"
        );
        subtitle.setStyle(
                "-fx-font-size: 14px;"
                        + "-fx-text-fill: white;"
        );

        VBox header = new VBox(6, heading, subtitle);
        header.setPadding(new Insets(22));
        header.setStyle("-fx-background-color: #243447;");

        // Task entry section
        Label formHeading = new Label("Add a task");
        formHeading.setStyle(
                "-fx-font-size: 18px;"
                        + "-fx-font-weight: bold;"
                        + "-fx-text-fill: #202A35;"
        );

        Label nameLabel = new Label("Task name");
        nameLabel.setStyle("-fx-font-weight: bold;");

        TextField taskNameField = new TextField();
        taskNameField.setPromptText("Enter task name...");
        taskNameField.setPrefHeight(38);
        taskNameField.setTooltip(
                new Tooltip("Enter a descriptive task name")
        );

        VBox nameBox = new VBox(6, nameLabel, taskNameField);
        HBox.setHgrow(nameBox, Priority.ALWAYS);

        Label deadlineLabel = new Label("Deadline");
        deadlineLabel.setStyle("-fx-font-weight: bold;");

        DatePicker deadlinePicker = new DatePicker();
        deadlinePicker.setPromptText("Select date");
        deadlinePicker.setPrefHeight(38);
        deadlinePicker.setMaxWidth(Double.MAX_VALUE);
        deadlinePicker.setTooltip(
                new Tooltip("Choose the task deadline")
        );

        VBox deadlineBox = new VBox(6, deadlineLabel, deadlinePicker);
        deadlineBox.setPrefWidth(190);

        HBox inputRow = new HBox(18, nameBox, deadlineBox);
        inputRow.setAlignment(Pos.CENTER_LEFT);

        Button addButton = new Button("Add Task");
        addButton.setPrefHeight(38);
        addButton.setMinWidth(115);
        addButton.setStyle(
                "-fx-background-color: #245C45;"
                        + "-fx-text-fill: white;"
                        + "-fx-font-size: 14px;"
                        + "-fx-font-weight: bold;"
        );

        Button completeButton = new Button("Mark Complete");
        completeButton.setPrefHeight(38);
        completeButton.setMinWidth(145);
        completeButton.setStyle(
                "-fx-background-color: #344F70;"
                        + "-fx-text-fill: white;"
                        + "-fx-font-size: 14px;"
                        + "-fx-font-weight: bold;"
        );

        HBox buttonRow = new HBox(12, addButton, completeButton);

        Label entryStatus = new Label("Ready to manage your tasks.");
        entryStatus.setStyle(
                "-fx-text-fill: #243447;"
                        + "-fx-font-size: 13px;"
        );

        VBox form = new VBox(
                13,
                formHeading,
                inputRow,
                buttonRow,
                entryStatus
        );
        form.setPadding(new Insets(20));
        form.setStyle("-fx-background-color: #F2F5F8;");

        // Sample task list
        Label listHeading = new Label("Your Tasks");
        listHeading.setStyle(
                "-fx-font-size: 19px;"
                        + "-fx-font-weight: bold;"
                        + "-fx-text-fill: #202A35;"
        );

        ListView<String> taskList = new ListView<>();
        taskList.getItems().add(
                "Programming Assignment\n"
                        + "Deadline: 2026-10-20\n"
                        + "Status: Pending"
        );
        taskList.setPrefHeight(190);
        taskList.setStyle(
                "-fx-control-inner-background: white;"
                        + "-fx-font-size: 14px;"
        );

        taskList.setCellFactory(list -> new ListCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item);
                    setPadding(new Insets(12));
                    setTextFill(Color.web("#202A35"));
                    setStyle("-fx-font-size: 14px;");
                }
            }
        });

        VBox taskSection = new VBox(12, listHeading, taskList);
        taskSection.setPadding(new Insets(20));
        VBox.setVgrow(taskList, Priority.ALWAYS);

        // Static status for the screenshot demonstration
        Label backgroundStatus = new Label(
                "Background service active. Task Manager is running."
        );
        backgroundStatus.setWrapText(true);
        backgroundStatus.setPadding(new Insets(15, 20, 15, 20));
        backgroundStatus.setMaxWidth(Double.MAX_VALUE);
        backgroundStatus.setStyle(
                "-fx-background-color: #E1E9F0;"
                        + "-fx-text-fill: #243447;"
                        + "-fx-font-size: 13px;"
        );

        // Main layout
        VBox center = new VBox(form, taskSection);
        VBox.setVgrow(taskSection, Priority.ALWAYS);

        BorderPane root = new BorderPane();
        root.setTop(header);
        root.setCenter(center);
        root.setBottom(backgroundStatus);
        root.setStyle("-fx-background-color: white;");

        Scene scene = new Scene(root, 850, 650, Color.WHITE);

        stage.setTitle("Student Task Manager");
        stage.setMinWidth(700);
        stage.setMinHeight(550);
        stage.setScene(scene);
        stage.show();

        // Preview-only button behavior
        addButton.setOnAction(event -> {
            String name = taskNameField.getText().trim();
            LocalDate deadline = deadlinePicker.getValue();

            if (name.isEmpty() || deadline == null) {
                entryStatus.setText(
                        "Enter a task name and select a deadline."
                );
                return;
            }

            taskList.getItems().add(
                    name + "\n"
                            + "Deadline: " + deadline + "\n"
                            + "Status: Pending"
            );

            taskNameField.clear();
            deadlinePicker.setValue(null);
            entryStatus.setText("Sample task added to preview.");
        });

        completeButton.setOnAction(event -> {
            int selected = taskList.getSelectionModel()
                    .getSelectedIndex();

            if (selected < 0) {
                entryStatus.setText("Select a task from the list first.");
                return;
            }

            String item = taskList.getItems().get(selected);
            taskList.getItems().set(
                    selected,
                    item.replace("Status: Pending", "Status: Completed")
            );
            entryStatus.setText("Sample task marked as completed.");
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
