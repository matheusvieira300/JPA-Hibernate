package br.com.escola.teste;

import br.com.escola.DAO.ClasseDAO;
import br.com.escola.DAO.ProfessorDAO;
import br.com.escola.entidade.Classe;
import br.com.escola.entidade.Professor;

public class Teste {

    public static void main(String[] args) {
        Classe classe = new Classe();

        Professor professor = new Professor();


        ClasseDAO classeDAO = new ClasseDAO();
        ProfessorDAO professorDAO = new ProfessorDAO();

//inserts na classe
        classe.setCnome("Literatura");


// inserts no professor
        professor.setTnome("maicon douglas");
        professor.setAssunto("matematica");


// estabelece a associação entre classe e professor
        classe.getProfessores().add(professor);
        professor.getClasses().add(classe);

// salva as entidades
        classeDAO.salvar(classe);
        professorDAO.salvar(professor);




        //listar tudo da classe
//        for (Classe classe1: classeDAO.procuraTudo()) {
//            System.out.println(classe1);
//        }


        // listar tudo do professor
//        for (Professor professor1 : professorDAO.procuraTudo() ) {
//            System.out.println(professor1);
//        }

        // remover classe
//        classeDAO.remove();

        // remover professor
//        professorDAO.remove();




    }
}
