module api {
    requires javafx.controls;
    requires javafx.fxml;

    opens api to javafx.fxml;
    exports api;
}
