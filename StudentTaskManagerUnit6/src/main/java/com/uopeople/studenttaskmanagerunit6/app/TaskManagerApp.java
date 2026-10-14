
package com.uopeople.studenttaskmanagerunit6.app;

import com.uopeople.studenttaskmanagerunit6.model.AssignmentTask;
import com.uopeople.studenttaskmanagerunit6.model.ExamTask;
import com.uopeople.studenttaskmanagerunit6.model.Task;
import com.uopeople.studenttaskmanagerunit6.service.TaskFileService;
import com.uopeople.studenttaskmanagerunit6.service.BackgroundStatusService;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class TaskManagerApp extends Application {

    private final TaskFileService fileService = new TaskFileService();
    private final BackgroundStatusService backgroundService = new BackgroundStatusService();

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();

        // Application heading
        Label heading = new Label("Student Task Manager");
        heading.setStyle(
                "-fx-font-size: 24px; "
                        + "-fx-font-weight: bold; "
                        + "-fx-text-fill: white;"
        );

        VBox header = new VBox(heading);
        header.setStyle(
                "-fx-background-color: #17365D; "
                        + "-fx-padding: 18;"
        );
        root.setTop(header);

        // Task name input
        TextField taskNameField = new TextField();
        taskNameField.setPromptText("Enter task name");
        taskNameField.setTooltip(
                new Tooltip("Enter a descriptive task name.")
        );

        // Task type selection
        ComboBox<String> taskTypeBox = new ComboBox<>();
        taskTypeBox.getItems().addAll("Assignment", "Exam");
        taskTypeBox.setValue("Assignment");
        taskTypeBox.setTooltip(
                new Tooltip("Choose the type of task.")
        );

        // Deadline selection
        DatePicker deadlinePicker = new DatePicker();
        deadlinePicker.setPromptText("Select deadline");
        deadlinePicker.setTooltip(
                new Tooltip("Choose the task deadline.")
        );

        // Add task button
        Button addButton = new Button("Add Task");
        addButton.setTooltip(
                new Tooltip("Add the task and save it to tasks.csv.")
        );

        HBox entryRow = new HBox(
                10,
                taskNameField,
                taskTypeBox,
                deadlinePicker,
                addButton
        );

        // Task list heading
        Label listHeading = new Label("Your Tasks");
        listHeading.setStyle(
                "-fx-font-size: 18px; -fx-font-weight: bold;"
        );

        // Task list
        ListView<Task> taskList = new ListView<>();
        taskList.setPlaceholder(
                new Label("No tasks yet. Add your first task.")
        );

        taskList.setCellFactory(list -> new ListCell<>() {
            @Override
            protected void updateItem(Task task, boolean empty) {
                super.updateItem(task, empty);

                if (empty || task == null) {
                    setText(null);
                } else {
                    String status = task.isCompleted()
                            ? "Completed"
                            : "Pending";

                    setText(
                            task.getTaskType()
                                    + ": " + task.getTaskName()
                                    + " | Deadline: " + task.getDeadline()
                                    + " | " + status
                    );
                }
            }
        });

        // Mark completed button
        Button completeButton = new Button("Mark Selected Complete");
        completeButton.setTooltip(
                new Tooltip(
                        "Mark the selected task as completed and save it."
                )
        );

        // Status message
        Label statusLabel = new Label(
                "Ready. Add a task to get started."
        );
        statusLabel.setStyle(
                "-fx-font-size: 13px; -fx-text-fill: #17365D;"
        );


        Label backgroundStatusLabel = new Label(
                "Background service starting..."
        );
        backgroundStatusLabel.setStyle(
                "-fx-font-size: 13px; -fx-text-fill: #355E3B;"
        );

        // Add task action
        addButton.setOnAction(event -> {
            String name = taskNameField.getText().trim();
            LocalDate deadline = deadlinePicker.getValue();

            if (name.isEmpty()) {
                statusLabel.setText("Enter a task name.");
                taskNameField.requestFocus();
                return;
            }

            if (deadline == null) {
                statusLabel.setText("Select a deadline.");
                deadlinePicker.requestFocus();
                return;
            }

            Task task;

            if ("Exam".equals(taskTypeBox.getValue())) {
                task = new ExamTask(name, deadline);
            } else {
                task = new AssignmentTask(name, deadline);
            }

            taskList.getItems().add(task);

            if (saveTasks(taskList.getItems(), statusLabel)) {
                taskNameField.clear();
                deadlinePicker.setValue(null);
                taskTypeBox.setValue("Assignment");
                taskList.refresh();

                statusLabel.setText(
                        "Task added and saved: " + name
                );
            } else {
                // Keep the task visible, but report that saving failed.
                taskList.refresh();
            }
        });

        // Mark task completed action
        completeButton.setOnAction(event -> {
            Task selectedTask =
                    taskList.getSelectionModel().getSelectedItem();

            if (selectedTask == null) {
                statusLabel.setText("Select a task first.");
                return;
            }

            if (selectedTask.isCompleted()) {
                statusLabel.setText("This task is already completed.");
                return;
            }

            selectedTask.markCompleted();
            taskList.refresh();

            if (saveTasks(taskList.getItems(), statusLabel)) {
                statusLabel.setText(
                        "Task completed and saved: "
                                + selectedTask.getTaskName()
                );
            }
        });

        // Main content layout
        VBox content = new VBox(
                12,
                entryRow,
                listHeading,
                taskList,
                completeButton,
                statusLabel,
                backgroundStatusLabel
        );

        content.setStyle(
                "-fx-padding: 18; -fx-background-color: #F4F7FB;"
        );

        VBox.setVgrow(taskList, Priority.ALWAYS);
        HBox.setHgrow(taskNameField, Priority.ALWAYS);

        root.setCenter(content);

        // Window configuration
        Scene scene = new Scene(root, 1000, 600);

        stage.setTitle("Student Task Manager");
        stage.setMinWidth(800);
        stage.setMinHeight(500);
        stage.setScene(scene);

        backgroundService.start(backgroundStatusLabel);

        stage.setOnCloseRequest(event -> backgroundService.stop());

        stage.show();
    }

    /**
     * Saves the complete task list to the CSV file.
     *
     * @return true if saving succeeds, otherwise false
     */
    private boolean saveTasks(
            ObservableList<Task> tasks,
            Label statusLabel
    ) {
        try {
            fileService.saveTasks(tasks);
            return true;
        } catch (IOException exception) {
            statusLabel.setText(
                    "Could not save tasks: " + exception.getMessage()
            );
            return false;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
