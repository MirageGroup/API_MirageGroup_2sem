package dao;
import jakarta.persistence.*;
import models.Classes;

public class Classdao{
    private EntityManager em;
    

public void ProdutoDao(EntityManager em) {
        this.em = em;
    }

public void cadastrar(Classes sala) {
        this.em.persist(sala);
    }
}