package model;
// Generated Jun 24, 2014 1:14:59 AM by Hibernate Tools 3.6.0



/**
 * Produto generated by hbm2java
 */
public class Produto  implements java.io.Serializable {


     private Integer id;
     private Pedido pedido;
     private String nome;
     private Integer estoque;
     private Float preco;
     private Float peso;
     private String desc;

    public Produto() {
    }

	
    public Produto(Pedido pedido) {
        this.pedido = pedido;
    }
    public Produto(Pedido pedido, String nome, Integer estoque, Float preco, Float peso, String desc) {
       this.pedido = pedido;
       this.nome = nome;
       this.estoque = estoque;
       this.preco = preco;
       this.peso = peso;
       this.desc = desc;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Pedido getPedido() {
        return this.pedido;
    }
    
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
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
    public String getDesc() {
        return this.desc;
    }
    
    public void setDesc(String desc) {
        this.desc = desc;
    }




}

