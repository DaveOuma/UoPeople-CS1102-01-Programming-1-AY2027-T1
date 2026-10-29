module com.uopeople.bookcatalogappunit8 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.uopeople.bookcatalogappunit8 to javafx.fxml;
    exports com.uopeople.bookcatalogappunit8;
}