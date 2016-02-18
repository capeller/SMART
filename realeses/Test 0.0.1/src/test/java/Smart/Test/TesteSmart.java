package Smart.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;  
  
import model.Pessoa;  
import dao.DaoPessoa;  
  
public class TesteSmart {  
  
   public static void main(String[] args) {  
      Pessoa pessoa = new Pessoa();  
      DaoPessoa daoPessoa = new DaoPessoa();  
      pessoa.setNome("Jose da Silva");  
      pessoa.setRg("12345678X");  
      pessoa.setIdade(20);  
      pessoa.setEstado("SP");  
      pessoa.setCidade("Sao Paulo");  
  
      daoPessoa.apagaTabela("Pessoa");
      daoPessoa.criaTabela("Pessoa");
      daoPessoa.insere(pessoa);  
  
      List<Pessoa> resultado = daoPessoa.buscar("12345678X");  
      System.out.println("Pessoa Encontrada: " + resultado.get(0));
  
      for (Iterator<Pessoa> iterator = resultado.iterator(); iterator  
            .hasNext();) {  
         Pessoa p = iterator.next();  
         System.out.println("Pessoa Encontrada: " + p.getNome());  
      }  
      pessoa.setNome("Jos� da Silva Sauro");  
  
      daoPessoa.atualizar(pessoa);  
  
      resultado = daoPessoa.buscar("12345678X");  
  
      for (Iterator<Pessoa> iterator = resultado.iterator(); iterator  
            .hasNext();) {  
         Pessoa p = iterator.next();  
         System.out.println("Pessoa Encontrada: " + p.getNome());  
      }  
  
      daoPessoa.apagar("12345678X");  
  
      resultado = daoPessoa.buscar("12345678X");  
  
      if (resultado.size() == 0) {  
         System.out.println("Pessoa foi apagada com sucesso");  
      } else {  
         System.out.println("A pessoa permanece no banco de dados");  
      }  
  
   }  
}  
