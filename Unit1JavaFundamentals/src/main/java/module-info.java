module com.uopeople.unit1javafundamentals {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.uopeople.unit1javafundamentals to javafx.fxml;
    exports com.uopeople.unit1javafundamentals;
}