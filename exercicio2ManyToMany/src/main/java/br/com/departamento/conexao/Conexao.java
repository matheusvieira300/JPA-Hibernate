package br.com.departamento.conexao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("many");

    public static EntityManager getEmf() {
        return emf.createEntityManager();
    }
}
