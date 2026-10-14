package com.uopeople.studenttaskmanagerunit6.model;

import java.time.LocalDate;

public class ExamTask implements Task {

    private final String taskName;
    private final LocalDate deadline;
    private boolean completed;

    public ExamTask(String taskName, LocalDate deadline) {
        if (taskName == null || taskName.isBlank()) {
            throw new IllegalArgumentException(
                    "Task name cannot be empty."
            );
        }

        if (deadline == null) {
            throw new IllegalArgumentException(
                    "Deadline cannot be null."
            );
        }

        this.taskName = taskName;
        this.deadline = deadline;
        this.completed = false;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public LocalDate getDeadline() {
        return deadline;
    }

    @Override
    public boolean isCompleted() {
        return completed;
    }

    @Override
    public void markCompleted() {
        completed = true;
    }

    @Override
    public String getTaskType() {
        return "Exam";
    }

    @Override
    public void displayTaskDetails() {
        System.out.println(
                "Exam Task: " + taskName
                        + " | Exam Date: " + deadline
                        + " | Status: "
                        + (completed ? "Completed" : "Pending")
        );
    }
}