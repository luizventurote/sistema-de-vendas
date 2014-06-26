package model;
// Generated Jun 26, 2014 1:13:14 AM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Produto generated by hbm2java
 */
public class Produto  implements java.io.Serializable {


     private Integer id;
     private String nome;
     private Integer estoque;
     private Float preco;
     private Float peso;
     private String descricao;
     private Set pedidos = new HashSet(0);

    public Produto() {
    }

    public Produto(String nome, Integer estoque, Float preco, Float peso, String descricao, Set pedidos) {
       this.nome = nome;
       this.estoque = estoque;
       this.preco = preco;
       this.peso = peso;
       this.descricao = descricao;
       this.pedidos = pedidos;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Integer getEstoque() {
        return this.estoque;
    }
    
    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }
    public Float getPreco() {
        return this.preco;
    }
    
    public void setPreco(Float preco) {
        this.preco = preco;
    }
    public Float getPeso() {
        return this.peso;
    }
    
    public void setPeso(Float peso) {
        this.peso = peso;
    }
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Set getPedidos() {
        return this.pedidos;
    }
    
    public void setPedidos(Set pedidos) {
        this.pedidos = pedidos;
    }




}


