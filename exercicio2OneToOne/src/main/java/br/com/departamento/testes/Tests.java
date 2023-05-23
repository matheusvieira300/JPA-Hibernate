package br.com.departamento.testes;

import br.com.departamento.DAO.DepartmentDAO;
import br.com.departamento.DAO.EmployeeDAO;
import br.com.departamento.tabelas.Department;
import br.com.departamento.tabelas.Employee;

public class Tests {

    public static void main(String[] args) {


        Department department = new Department();
        Employee employee = new Employee();

        DepartmentDAO departmentDAO = new DepartmentDAO();
        EmployeeDAO employeeDAO = new EmployeeDAO();
//
//        //inserindo dados no departamento
        department.setName("cobrança");
        departmentDAO.salvar(department);// salvando



////        //inserindo dados no employee
        employee.setDeg("administrado");
        employee.setEname("jose");
        employee.setDepartment(department);//chave estrangeira
        employee.setSalary(2000.0);

        employeeDAO.salvar(employee);//salvando


        //pesquisar por ID da entidade departamento
//        department = departmentDAO.procurarPelaId(1);
//        System.out.println(department);

////        // pesquisar por ID da entidade employee
//            employee = employeeDAO.procurarPelaId(1);
//
//        // pesquisar tudo sobre employee e departamento
//        for(Department departmento : departmentDAO.procuraTudo()){
//            System.out.println(departmento);
//        }

//        for(Employee employee2 : employeeDAO.procuraTudo()){
//           System.out.println(employee2);
//       }

//
//        // remover employee
//        employeeDAO.remove(2);
////
////        // remover department
//        departmentDAO.remove(2);


    }
}
