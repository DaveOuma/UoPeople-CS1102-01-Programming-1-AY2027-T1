module com.uopeople.unit4onlineshoppingcart {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.uopeople.unit4onlineshoppingcart to javafx.fxml;
    exports com.uopeople.unit4onlineshoppingcart;
}