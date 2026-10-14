
package com.uopeople.studenttaskmanagerunit6.service;

import com.uopeople.studenttaskmanagerunit6.model.AssignmentTask;
import com.uopeople.studenttaskmanagerunit6.model.Task;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskFileServiceTest {

    @TempDir
    Path tempDir;

    @Test
    void writesRequiredHeaderAndTaskDetails() throws IOException {
        Path csvFile = tempDir.resolve("tasks.csv");
        TaskFileService service = new TaskFileService(csvFile);

        Task task = new AssignmentTask(
                "Programming Assignment",
                LocalDate.of(2026, 10, 20)
        );

        service.saveTasks(List.of(task));

        String csv = Files.readString(csvFile, StandardCharsets.UTF_8);

        assertTrue(csv.startsWith(
                "Task Name, Deadline, Status" + System.lineSeparator()
        ));

        assertTrue(csv.contains(
                "Programming Assignment, 2026-10-20, Pending"
        ));
    }

    @Test
    void savesCompletedTaskWithCorrectStatus() throws IOException {
        Path csvFile = tempDir.resolve("completed-tasks.csv");
        TaskFileService service = new TaskFileService(csvFile);

        Task task = new AssignmentTask(
                "Unit 6 Assignment",
                LocalDate.of(2026, 10, 20)
        );

        task.markCompleted();
        service.saveTasks(List.of(task));

        String csv = Files.readString(csvFile, StandardCharsets.UTF_8);

        assertTrue(csv.contains(
                "Unit 6 Assignment, 2026-10-20, Completed"
        ));
    }

    @Test
    void escapesCommasAndQuotationMarksInTaskNames() throws IOException {
        Path csvFile = tempDir.resolve("special-characters.csv");
        TaskFileService service = new TaskFileService(csvFile);

        Task task = new AssignmentTask(
                "Review, \"Unit 6\"",
                LocalDate.of(2026, 10, 20)
        );

        service.saveTasks(List.of(task));

        String csv = Files.readString(csvFile, StandardCharsets.UTF_8);

        assertTrue(csv.contains(
                "\"Review, \"\"Unit 6\"\"\", 2026-10-20, Pending"
        ));
    }

    @Test
    void writesHeaderWhenTaskListIsEmpty() throws IOException {
        Path csvFile = tempDir.resolve("empty-tasks.csv");
        TaskFileService service = new TaskFileService(csvFile);

        service.saveTasks(List.of());

        String csv = Files.readString(csvFile, StandardCharsets.UTF_8);

        assertEquals(
                "Task Name, Deadline, Status" + System.lineSeparator(),
                csv
        );
    }
}
