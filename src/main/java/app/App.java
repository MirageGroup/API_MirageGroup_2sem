package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.Clazz;
import models.Student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import dao.ClazzDAO;
import dao.StudentDAO;
import factory.ConnectionFactory;
/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 1400, 800);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {

        Student student = new Student();
        student.setName("Bambam");
        StudentDAO dao = new StudentDAO();
        dao.save(student);

        student.setId(10);
        student.setName("Pedrão");
        dao.update(student);

        Clazz clazz = new Clazz();
        clazz.setName("Matematics");
        clazz.setTime("07:30:00");
        clazz.setWeekday("Terça");
        ClazzDAO dao1 = new ClazzDAO();
        dao1.save(clazz);

        launch();

    }

}