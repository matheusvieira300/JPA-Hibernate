package br.com.escola.DAO;

import br.com.escola.conexao.Conexao;
import br.com.escola.entidade.Classe;

import javax.persistence.EntityManager;
import java.util.List;

public class ClasseDAO {

    public Classe salvar(Classe classe) {
        EntityManager em = new Conexao().getEmf(); // tipo driverManager.conection do JDBC
        try {
            em.getTransaction().begin();
            if (classe.getCid() == null) { // id n existe - id novo
                em.persist(classe);
            } else { // se o id existir - atualizar
                em.merge(classe);// isso aqui atualiza
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback(); // deu ruim, vamos voltar ao estado inicial
            System.out.println(e);
        } finally {
            em.close();
        }
        return classe;
    }

    public Classe procurarPelaId(Integer id) {
        EntityManager em = new Conexao().getEmf();
        Classe classe = null;
        try {
            classe = em.find(Classe.class, id);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        return classe;
    }

    public List<Classe> procuraTudo() {
        EntityManager em = new Conexao().getEmf();
        List<Classe> classe = null;
        try {
//usando jpql
            String query = "from Classe ";
            classe = em.createQuery(query).getResultList();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        return classe;
    }

    public Classe remove(Integer id) {
        EntityManager em = new Conexao().getEmf();
        Classe classe = null;
        try {
            classe = em.find(Classe.class, id);//find metodo do entity manager pra pegar o atributo da classe
            em.getTransaction().begin();
            em.remove(classe);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            em.getTransaction().rollback();//restaura tudo do jeito que tava se der ruim
        } finally {
            em.close();
        }
        return classe;
    }

}
