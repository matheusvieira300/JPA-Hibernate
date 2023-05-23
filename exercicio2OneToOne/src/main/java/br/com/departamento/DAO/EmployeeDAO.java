package br.com.departamento.DAO;

import br.com.departamento.conexao.Conexao;
import br.com.departamento.tabelas.Department;
import br.com.departamento.tabelas.Employee;


import javax.persistence.EntityManager;
import java.util.List;

public class EmployeeDAO {

    public Employee salvar (Employee employee){
        EntityManager em = new Conexao().getEmf(); // tipo driverManager.conection do JDBC
        try {
            em.getTransaction().begin();
            if(employee.getEid() == null){ // id n existe - id novo
                em.persist(employee);
            } else { // se o id existir - atualizar
                em.merge(employee);// isso aqui atualiza
            }
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback(); // deu ruim, vamos voltar ao estado inicial
            System.out.println(e);
        } finally {
            em.close();
        }
        return employee;
    }
    public Employee procurarPelaId(Integer id){
        EntityManager em = new Conexao().getEmf();
        Employee employee = null;
        try{
            employee = em.find(Employee.class, id);
        } catch (Exception e){
            System.out.println(e);
        } finally {
            em.close();
        }
        return employee;
    }

    public List<Employee> procuraTudo(){
        EntityManager em = new Conexao().getEmf();
        List<Employee> employee = null;
        try {
//usando jpql
            String query = "from Employee ";
            employee = em.createQuery(query).getResultList();
        } catch (Exception e){
            System.out.println(e);
        } finally {
            em.close();
        }
        return employee;
    }

    public Employee remove(Integer id){
        EntityManager em = new Conexao().getEmf();
        Employee employee = null;
        try {
            employee = em.find(Employee.class, id);//find metodo do entity manager pra pegar o atributo da classe
            em.getTransaction().begin();
            em.remove(employee);
            em.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e);
            em.getTransaction().rollback();//restaura tudo do jeito que tava se der ruim
        } finally {
            em.close();
        }
        return employee;
    }
}
