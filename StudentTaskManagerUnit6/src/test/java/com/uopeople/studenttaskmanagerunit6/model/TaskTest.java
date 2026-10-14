
package com.uopeople.studenttaskmanagerunit6.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void assignmentTaskStoresItsDetails() {
        LocalDate deadline = LocalDate.of(2026, 10, 20);

        Task task = new AssignmentTask("Programming Assignment", deadline);

        assertEquals("Programming Assignment", task.getTaskName());
        assertEquals(deadline, task.getDeadline());
        assertEquals("Assignment", task.getTaskType());
        assertFalse(task.isCompleted());
    }

    @Test
    void examTaskStoresItsDetails() {
        LocalDate deadline = LocalDate.of(2026, 10, 25);

        Task task = new ExamTask("Programming Exam", deadline);

        assertEquals("Programming Exam", task.getTaskName());
        assertEquals(deadline, task.getDeadline());
        assertEquals("Exam", task.getTaskType());
        assertFalse(task.isCompleted());
    }

    @Test
    void markingTaskCompleteChangesItsStatus() {
        Task task = new AssignmentTask(
                "Unit 6 Assignment",
                LocalDate.of(2026, 10, 20)
        );

        task.markCompleted();

        assertTrue(task.isCompleted());
    }

    @Test
    void blankTaskNameIsRejected() {
        LocalDate deadline = LocalDate.of(2026, 10, 20);

        assertThrows(
                IllegalArgumentException.class,
                () -> new AssignmentTask("   ", deadline)
        );
    }

    @Test
    void nullDeadlineIsRejected() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new ExamTask("Programming Exam", null)
        );
    }
}
