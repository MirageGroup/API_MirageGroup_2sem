module gui {
    requires java.desktop;
    requires java.sql;

    opens gui to javax.swing;
    exports gui;
}
