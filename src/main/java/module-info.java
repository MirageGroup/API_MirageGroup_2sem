module api {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires java.sql;
    requires jakarta.persistence;

    opens api to javafx.fxml;
    exports api;
}
