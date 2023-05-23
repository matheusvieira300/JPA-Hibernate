package br.com.departamento.DAO;

import br.com.departamento.conexao.Conexao;
import br.com.departamento.tabelas.Department;


import javax.persistence.EntityManager;
import java.util.List;

public class DepartmentDAO {


    public Department salvar (Department department){
        EntityManager em = new Conexao().getEmf(); // tipo driverManager.conection do JDBC
        try {
            em.getTransaction().begin();
            if(department.getId() == null){ // id n existe - id novo
                em.persist(department);
            } else { // se o id existir - atualizar
                em.merge(department);// isso aqui atualiza
            }
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback(); // deu ruim, vamos voltar ao estado inicial
            System.out.println(e);
        } finally {
            em.close();
        }
        return department;
    }
    public Department procurarPelaId(Integer id){
        EntityManager em = new Conexao().getEmf();
        Department department = null;
        try{
            department = em.find(Department.class, id);
        } catch (Exception e){
            System.out.println(e);
        } finally {
            em.close();
        }
        return department;
    }

    public List<Department> procuraTudo(){
        EntityManager em = new Conexao().getEmf();
        List<Department> department = null;
        try {
//usando jpql
            String query = "from Department ";
            department = em.createQuery(query).getResultList();
        } catch (Exception e){
            System.out.println(e);
        } finally {
            em.close();
        }
        return department;
    }

    public Department remove(Integer id){
        EntityManager em = new Conexao().getEmf();
        Department department = null;
        try {
            department = em.find(Department.class, id);//find metodo do entity manager pra pegar o atributo da classe
            em.getTransaction().begin();
            em.remove(department);
            em.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e);
            em.getTransaction().rollback();//restaura tudo do jeito que tava se der ruim
        } finally {
            em.close();
        }
        return department;
    }
}

