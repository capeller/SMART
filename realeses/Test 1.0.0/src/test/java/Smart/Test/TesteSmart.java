package Smart.Test;
  
import model.Pessoa;  
import dao.DaoPessoa;  


public class TesteSmart {
    public static void main(String[] args) {
        Pessoa p = new Pessoa();
 
        p.setNome("Gabriel");
        p.setIdade(19);        
        p.setId(28);
 
        Pessoa p2 = new Pessoa();
 
        p2.setNome("José");
        p2.setIdade(72);
         
        Pessoa p3 = new Pessoa();
 
        p3.setNome("Maria");
        p3.setIdade(27);
 
        Pessoa p4 = new Pessoa();
 
        p4.setNome("Rodolfo");
        p4.setIdade(16);
         
        DaoPessoa dao = new DaoPessoa();
 
        //dao.persist(p);
        dao.persist(p2);
        dao.persist(p3);
        dao.persist(p4);
    	
    	//DaoPessoa dao = new DaoPessoa();
    	
    	dao.remove(p);
    	
        for(Pessoa pe : dao.findAll()){
            System.out.println(pe.getId());
            System.out.println(pe.getNome());
            System.out.println();
        }
    /*     
        dao.remove(p);
        dao.removeById(p2.getId());*/
         
        for(Pessoa pe : dao.findAll()){
            System.out.println(pe.getId());
            System.out.println(pe.getNome());
            System.out.println();
        }
    }
}