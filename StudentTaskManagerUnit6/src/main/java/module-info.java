
module com.uopeople.studenttaskmanagerunit6 {
    requires javafx.controls;
    requires javafx.fxml;

    exports com.uopeople.studenttaskmanagerunit6;
    exports com.uopeople.studenttaskmanagerunit6.app;
    exports com.uopeople.studenttaskmanagerunit6.model;

    opens com.uopeople.studenttaskmanagerunit6 to javafx.fxml;
}
