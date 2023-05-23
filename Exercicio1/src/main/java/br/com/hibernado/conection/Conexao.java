package br.com.hibernado.conection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernado");

    public static EntityManager getEmf() {
        return emf.createEntityManager();
    }
}
