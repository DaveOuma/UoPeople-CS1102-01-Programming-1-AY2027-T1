module com.uopeople.assignment_unit_2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.uopeople.assignment_unit_2 to javafx.fxml;
    exports com.uopeople.assignment_unit_2;
}