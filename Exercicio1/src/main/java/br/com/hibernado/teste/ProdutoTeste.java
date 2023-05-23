package br.com.hibernado.teste;

import br.com.hibernado.model.Produto;
import br.com.hibernado.model.dao.ProdutoDAO;

public class ProdutoTeste {
    public static void main(String[] args) {
        Produto produto = new Produto();
        ProdutoDAO dao = new ProdutoDAO();

        //inserindo dados
       // produto.setId(2); pra atualizar atráves da ID
//        produto.setCategoria("carro");
//        produto.setNome("fusca");
//        produto.setValor(8000.0);
//        dao.salvar(produto);

        // pesquisando pelo id
//      produto = dao.procurarPelaId(2);
//        System.out.println(produto);


        // listar toda tabela
        for(Produto produto2 : dao.findAll()){
            System.out.println(produto2);
        }

        //deletar produto
//        dao.remove(1);

    }
}
