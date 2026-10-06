module com.uopeople.unit5vehiclemanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.uopeople.unit5vehiclemanagementsystem to javafx.fxml;
    exports com.uopeople.unit5vehiclemanagementsystem;
}