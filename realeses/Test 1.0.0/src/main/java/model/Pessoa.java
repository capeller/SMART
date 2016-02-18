package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name="pessoas")
public class Pessoa {
    private long id;
    private String nome;
    private Integer idade;
 
    @Id
    @GeneratedValue
    @Column(name="pessoas_id")
    public long getId() {
        return id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
 
    @Column(name="pessoas_nome")
    public String getNome() {
        return nome;
    }
 
    public void setNome(String nome) {
        this.nome = nome;
    }
 
    @Column(name="pessoas_idade")
    public Integer getIdade() {
        return idade;
    }
 
    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}