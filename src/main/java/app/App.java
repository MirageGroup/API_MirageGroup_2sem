package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.Classes;

import java.io.IOException;
import jakarta.persistence.*;
import dao.Classdao;
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
        

        // teste do hibernate

        Classes novaSala = new Classes();
        novaSala.setName("sala1");
        // novaSala.setHour("19:20:20");
        System.out.println("iniciou");

        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("api");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        
        Classdao dao = new Classdao();
        dao.ProdutoDao(em);
        dao.cadastrar(novaSala);
        em.getTransaction().commit();

        em.close();
        

        launch();

    }

}