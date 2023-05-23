package br.com.hibernado.teste;

import br.com.hibernado.model.Fornecedor;
import br.com.hibernado.model.Produto;
import br.com.hibernado.model.dao.FornecedorDAO;
import br.com.hibernado.model.dao.ProdutoDAO;

public class FornecedorTeste {

    public static void main(String[] args) {


        Fornecedor fornecedor = new Fornecedor();
        Produto produto = new Produto();

        FornecedorDAO fornecedorDAO = new FornecedorDAO();

        ProdutoDAO produtoDAO = new ProdutoDAO();


        fornecedor.setNome("Apple");
        fornecedor.setImei("879435");

        fornecedorDAO.salvar(fornecedor);


        produto.setNome("Iphone 14");
        produto.setCategoria("Smartphone");
        produto.setValor(10000.0);
        produto.setFornecedor(fornecedor);

        produtoDAO.salvar(produto);
        fornecedorDAO.salvar(fornecedor);

    }

}
