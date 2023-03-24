module app {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires java.sql;
    requires jakarta.persistence;

    opens app to javafx.fxml;
    exports app;
}
