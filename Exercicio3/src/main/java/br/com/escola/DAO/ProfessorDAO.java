package br.com.escola.DAO;

import br.com.escola.conexao.Conexao;
import br.com.escola.entidade.Classe;
import br.com.escola.entidade.Professor;


import javax.persistence.EntityManager;
import java.util.List;

public class ProfessorDAO {

    public Professor salvar(Professor professor) {
        EntityManager em = new Conexao().getEmf(); // tipo driverManager.conection do JDBC
        try {
            em.getTransaction().begin();
            if (professor.getTid() == null) { // id n existe - id novo
                em.persist(professor);
            } else { // se o id existir - atualizar
                em.merge(professor);// isso aqui atualiza
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback(); // deu ruim, vamos voltar ao estado inicial
            System.out.println(e);
        } finally {
            em.close();
        }
        return professor;
    }

    public Professor procurarPelaId(Integer id) {
        EntityManager em = new Conexao().getEmf();
        Professor professor = null;
        try {
            professor = em.find(Professor.class, id);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        return professor;
    }

    public List<Professor> procuraTudo() {
        EntityManager em = new Conexao().getEmf();
        List<Professor> professor = null;
        try {
//usando jpql
            String query = "from Professor ";
            professor = em.createQuery(query).getResultList();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        return professor;
    }

    public Professor remove(Integer id) {
        EntityManager em = new Conexao().getEmf();
        Professor professor = null;
        try {
            professor = em.find(Professor.class, id);//find metodo do entity manager pra pegar o atributo da professor
            em.getTransaction().begin();
            em.remove(professor);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            em.getTransaction().rollback();//restaura tudo do jeito que tava se der ruim
        } finally {
            em.close();
        }
        return professor;
    }
}
