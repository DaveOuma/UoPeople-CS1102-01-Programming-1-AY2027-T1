module com.uopeople.unit3menutrucker {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.uopeople.unit3menutrucker to javafx.fxml;
    exports com.uopeople.unit3menutrucker;
}