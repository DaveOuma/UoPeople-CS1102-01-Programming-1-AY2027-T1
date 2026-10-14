
package com.uopeople.studenttaskmanagerunit6.model;

import java.time.LocalDate;

public interface Task {

    String getTaskName();

    LocalDate getDeadline();

    boolean isCompleted();

    void markCompleted();

    String getTaskType();

    void displayTaskDetails();
}
