
package com.uopeople.studenttaskmanagerunit6.service;

import com.uopeople.studenttaskmanagerunit6.model.Task;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TaskFileService {

    private final Path filePath;

    public TaskFileService() {
        this(Path.of("tasks.csv"));
    }

    public TaskFileService(Path filePath) {
        if (filePath == null) {
            throw new IllegalArgumentException(
                    "File path cannot be null."
            );
        }

        this.filePath = filePath;
    }

    public void saveTasks(List<Task> tasks) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(
                filePath,
                StandardCharsets.UTF_8
        )) {
            writer.write("Task Name, Deadline, Status");
            writer.newLine();

            for (Task task : tasks) {
                writer.write(escapeCsv(task.getTaskName()));
                writer.write(", ");
                writer.write(task.getDeadline().toString());
                writer.write(", ");
                writer.write(
                        task.isCompleted() ? "Completed" : "Pending"
                );
                writer.newLine();
            }
        }
    }

    private String escapeCsv(String value) {
        String escaped = value.replace("\"", "\"\"");

        if (escaped.contains(",")
                || escaped.contains("\"")
                || escaped.contains("\n")
                || escaped.contains("\r")) {
            return "\"" + escaped + "\"";
        }

        return escaped;
    }
}
