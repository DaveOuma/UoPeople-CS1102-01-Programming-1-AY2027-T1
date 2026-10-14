
package com.uopeople.studenttaskmanagerunit6.service;

import javafx.application.Platform;
import javafx.scene.control.Label;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class BackgroundStatusService {

    private final ScheduledExecutorService scheduler;

    public BackgroundStatusService() {
        scheduler = Executors.newSingleThreadScheduledExecutor(task -> {
            Thread thread = new Thread(task, "task-status-daemon");
            thread.setDaemon(true);
            return thread;
        });
    }

    public void start(Label backgroundStatusLabel) {
        scheduler.scheduleAtFixedRate(
                () -> Platform.runLater(
                        () -> backgroundStatusLabel.setText(
                                "Background service active. Task Manager is running."
                        )
                ),
                5,
                5,
                TimeUnit.SECONDS
        );
    }

    public void stop() {
        scheduler.shutdownNow();
    }
}
