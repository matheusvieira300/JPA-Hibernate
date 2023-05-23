package br.com.hibernado.model.dao;

import br.com.hibernado.conection.Conexao;
import br.com.hibernado.model.Fornecedor;
import br.com.hibernado.model.Produto;

import javax.persistence.EntityManager;
import java.util.List;

public class FornecedorDAO {

    public Fornecedor salvar (Fornecedor fornecedor){
        EntityManager em = new Conexao().getEmf(); // tipo driverManager.conection do JDBC
        try {
            em.getTransaction().begin();
            if(fornecedor.getId() == null){ // id n existe - id novo
                em.persist(fornecedor);
            } else { // se o id existir - atualizar
                em.merge(fornecedor);// isso aqui atualiza
            }
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback(); // deu ruim, vamos voltar ao estado inicial
            System.out.println(e);
        } finally {
            em.close();
        }
        return fornecedor;
    }
    public Fornecedor procurarPelaId(Integer id){
        EntityManager em = new Conexao().getEmf();
        Fornecedor fornecedor = null;
        try{
            fornecedor = em.find(Fornecedor.class, id);
        } catch (Exception e){
            System.out.println(e);
        } finally {
            em.close();
        }
        return fornecedor;
    }

    public List<Fornecedor> procuraTudo(){
        EntityManager em = new Conexao().getEmf();
        List<Fornecedor> fornecedor = null;
        try {
//usando jpql
            String query = "from Fornecedor ";
            fornecedor = em.createQuery(query).getResultList();
        } catch (Exception e){
            System.out.println(e);
        } finally {
            em.close();
        }
        return fornecedor;
    }

    public Fornecedor remove(Integer id){
        EntityManager em = new Conexao().getEmf();
        Fornecedor fornecedor = null;
        try {
            fornecedor = em.find(Fornecedor.class, id);//find metodo do entity manager pra pegar o atributo da classe
            em.getTransaction().begin();
            em.remove(fornecedor);
            em.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e);
            em.getTransaction().rollback();//restaura tudo do jeito que tava se der ruim
        } finally {
            em.close();
        }
        return fornecedor;
    }
}
