package model;
// Generated Jun 26, 2014 2:38:47 AM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Funcionario generated by hbm2java
 */
public class Funcionario  implements java.io.Serializable {


     private Integer id;
     private String nome;
     private Integer tipo;
     private Integer idGerente;
     private Set pedidos = new HashSet(0);

    public Funcionario() {
    }

    public Funcionario(String nome, Integer tipo, Integer idGerente, Set pedidos) {
       this.nome = nome;
       this.tipo = tipo;
       this.idGerente = idGerente;
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
    public Integer getTipo() {
        return this.tipo;
    }
    
    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }
    public Integer getIdGerente() {
        return this.idGerente;
    }
    
    public void setIdGerente(Integer idGerente) {
        this.idGerente = idGerente;
    }
    public Set getPedidos() {
        return this.pedidos;
    }
    
    public void setPedidos(Set pedidos) {
        this.pedidos = pedidos;
    }




}


