package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Pessoa {  
	@Id
    @GeneratedValue
   private String rg; 
	@Column
   private String nome;  
	@Column
   private int idade;
	@Column
   private String estado;
	@Column
   private String cidade;  
  
   public void setRg(String rg) {  
      this.rg = rg;  
   }  
  
   public void setNome(String nome) {  
      this.nome = nome;  
   }  
  
   public void setIdade(int idade) {  
      this.idade = idade;  
   }  
  
   public void setEstado(String estado) {  
      this.estado = estado;  
   }  
  
   public void setCidade(String cidade) {  
      this.cidade = cidade;  
   }  
  
   public String getRg() {  
      return this.rg;  
   }  
  
   public String getNome() {  
      return this.nome;  
   }  
  
   public int getIdade() {  
      return this.idade;  
   }  
  
   public String getEstado() {  
      return this.estado;  
   }  
  
   public String getCidade() {  
      return this.cidade;  
   }  
}  
