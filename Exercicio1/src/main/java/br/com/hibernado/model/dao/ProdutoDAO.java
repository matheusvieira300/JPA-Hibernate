package br.com.hibernado.model.dao;

import br.com.hibernado.conection.Conexao;
import br.com.hibernado.model.Produto;

import javax.persistence.EntityManager;

import java.util.List;


public class ProdutoDAO {

    public Produto salvar (Produto produto){
        EntityManager em = new Conexao().getEmf();
        try {
           em.getTransaction().begin();
           if(produto.getId() == null){ // id n existe - id novo
               em.persist(produto);
           } else { // se o id existir - atualizar
               em.merge(produto);
           }
           em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback(); // deu ruim, vamos voltar ao estado inicial
            System.out.println(e);
        } finally {
            em.close();
        }
        return produto;
    }
    public Produto procurarPelaId(Integer id){
        EntityManager em = new Conexao().getEmf();
        Produto produto = null;
        try{
            produto = em.find(Produto.class, id);
        } catch (Exception e){
            System.out.println(e);
        } finally {
            em.close();
        }
        return produto;
    }

    public List<Produto> findAll(){
        EntityManager em = new Conexao().getEmf();
        List<Produto> produto = null;
        try {
//usando jpql
            String query = "from Produto ";
            produto = em.createQuery(query).getResultList();
        } catch (Exception e){
            System.out.println(e);
        } finally {
            em.close();
        }
        return produto;
    }

    public Produto remove(Integer id){
        EntityManager em = new Conexao().getEmf();
        Produto produto = null;
        try {
            produto = em.find(Produto.class, id);
            em.getTransaction().begin();
            em.remove(produto);
            em.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return produto;
    }
}
