package br.com.hibernado.model;

import javax.persistence.*;

@Entity
public class Produto {
    @Id// criando a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)//setando auto increment
    private Integer id ;

    private String nome;

    private String categoria;
    private double valor;

    @ManyToOne
    private Fornecedor fornecedor;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }


    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", categoria='" + categoria + '\'' +
                ", valor=" + valor +
                ", fornecedor=" + fornecedor +
                '}';
    }
}
