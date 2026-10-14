
package com.uopeople.studenttaskmanagerunit6.app;

import com.uopeople.studenttaskmanagerunit6.model.AssignmentTask;
import com.uopeople.studenttaskmanagerunit6.model.ExamTask;
import com.uopeople.studenttaskmanagerunit6.model.Task;

import java.time.LocalDate;

public class OOPDemo {

    public static void main(String[] args) {
        Task assignment = new AssignmentTask(
                "Unit 6 JavaFX Assignment",
                LocalDate.of(2026, 10, 14)
        );

        Task exam = new ExamTask(
                "Programming 1",
                LocalDate.of(2026, 10, 20)
        );

        assignment.displayTaskDetails();
        exam.displayTaskDetails();
    }
}
