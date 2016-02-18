package dao.banco;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  
  
public class ConFactory {  
     
   public static final int H2 = 0;  
   private static final String H2Driver = "org.h2.Driver";  
  
   public static Connection conexao(String url, String nome, String senha,  
         int banco) throws ClassNotFoundException, SQLException {  
      switch (banco) {        
      case H2:           
         Class.forName(H2Driver);  
         break;  
      }  
      return DriverManager.getConnection(url, nome, senha);  
   }  
}  




/*
package dao.banco;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  
  
public class ConFactory {  
     
   public static final int MYSQL = 0;  
   private static final String MySQLDriver = "com.mysql.jdbc.Driver";  
  
   public static Connection conexao(String url, String nome, String senha,  
         int banco) throws ClassNotFoundException, SQLException {  
      switch (banco) {        
      case MYSQL:           
         Class.forName(MySQLDriver);  
         break;  
      }  
      return DriverManager.getConnection(url, nome, senha);  
   }  
}  */