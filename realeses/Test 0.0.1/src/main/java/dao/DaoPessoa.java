package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import model.Pessoa;
import dao.banco.ConFactory;

public class DaoPessoa implements dao.interfaces.DaoPessoa {

	EntityManagerFactory emf;
	EntityManager em;

	public DaoPessoa() {
		emf = Persistence.createEntityManagerFactory("TestH2JPA");
		em = emf.createEntityManager();
	}

	private final String URL = "jdbc:h2:~/test", NOME = "sa", SENHA = "";

	private Connection con;
	private Statement comando;

	public void apagar(String rg) {
		em.getTransaction().begin();
		try {
			comando.executeUpdate("DELETE FROM pessoa WHERE rg = '" + rg + "';");
		} catch (SQLException e) {
			imprimeErro("Erro ao apagar pessoas", e.getMessage());
		} finally {
			em.getTransaction().commit();
			emf.close();
		}
	}

	public Vector<Pessoa> buscarTodos() {
		em.getTransaction().begin();
		Vector<Pessoa> resultados = new Vector<Pessoa>();
		ResultSet rs;
		try {
			rs = comando.executeQuery("SELECT * FROM pessoa");
			while (rs.next()) {
				Pessoa temp = new Pessoa();
				// pega todos os atributos da pessoa
				temp.setRg(rs.getString("rg"));
				temp.setNome(rs.getString("nome"));
				temp.setIdade(rs.getInt("idade"));
				temp.setCidade(rs.getString("cidade"));
				temp.setEstado(rs.getString("estado"));
				resultados.add(temp);
			}
			return resultados;
		} catch (SQLException e) {
			imprimeErro("Erro ao buscar pessoas", e.getMessage());
			return null;
		}
	}

	public void atualizar(Pessoa pessoa) {
		em.getTransaction().begin();
		String com = "UPDATE pessoa SET nome = '" + pessoa.getNome() + "', idade =" + pessoa.getIdade() + ", cidade = '"
				+ pessoa.getCidade() + "', estado ='" + pessoa.getEstado() + "' WHERE  rg = '" + pessoa.getRg() + "';";
		System.out.println("Atualizada!");
		try {
			comando.executeUpdate(com);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			em.getTransaction().commit();
			emf.close();
		}
	}

	public List<Pessoa> buscar(String rg) {
		em.getTransaction().begin();
		//Vector<Pessoa> resultados = new Vector<Pessoa>();
		//ResultSet rs;		
		Query Criar = em.createNativeQuery("SELECT * FROM Pessoa;", Pessoa.class);
		List<Pessoa> Humanos = (List<Pessoa>) Criar.getResultList();
		System.out.println("Resultado Size = " + Humanos.size());
		return Humanos;
		/*try {			
			Query Criar = em.createNativeQuery("SELECT * FROM pessoa WHERE rg LIKE '" + rg + "%';");
			
			while (rs.next()) {
				Pessoa temp = new Pessoa();
				// pega todos os atributos da pessoa
				temp.setRg(rs.getString("rg"));
				temp.setNome(rs.getString("nome"));
				temp.setIdade(rs.getInt("idade"));
				temp.setCidade(rs.getString("cidade"));
				temp.setEstado(rs.getString("estado"));
				resultados.add(temp);
			}
			return resultados;
		} catch (SQLException e) {
			imprimeErro("Erro ao buscar pessoa", e.getMessage());
			return null;
		}*/
		

	}

	public void insere(Pessoa pessoa) {
		em.getTransaction().begin();
		
			em.createNativeQuery("INSERT INTO Pessoa VALUES('" + pessoa.getRg() + "', '" + pessoa.getNome() + "',"
					+ pessoa.getIdade() + ",'" + pessoa.getCidade() + "','" + pessoa.getEstado() + "')");
			System.out.println("Inserida!");
		
			em.getTransaction().commit();
			//emf.close();
		
	}

	public void criaTabela(String NomeTabela) {
		em.getTransaction().begin();
		
		
			em.createNativeQuery(" create table pessoa(" + "rg varchar(20) not null,nome varchar(20) not null,"
					+ "idade int(2) not null, cidade varchar(20) not null,"
					+ "estado varchar(2) not null, Primary key(rg))");
			System.out.println("Tabela Criada!");
		
			em.getTransaction().commit();
			//emf.close();
		
	}

	public void apagaTabela(String NomeTabela) {
		// conectar();
		em.getTransaction().begin();
		
		/*
		 * try { comando.executeUpdate("DROP TABLE IF EXISTS PESSOA");
		 * System.out.println("Tabela Apagada!"); } catch (SQLException e) {
		 * imprimeErro("Erro ao Apagar tabela", e.getMessage()); } finally {
		 * fechar(); }
		 */
		
		/*@SuppressWarnings("unused")
		Query Criar = em.createNativeQuery("DROP TABLE IF EXISTS TEST;"
				+ "CREATE TABLE TEST(ID INT PRIMARY KEY, NAME VARCHAR(255));"
				+ "INSERT INTO TEST VALUES(1, 'Hello');"
				+ "INSERT INTO TEST VALUES(2, 'World');");
		
		@SuppressWarnings("unused")
		Query Consultar = em.createNativeQuery("SELECT * FROM TEST ORDER BY ID;");
		
		
		ResultSet rs;
		try {
			rs = comando.executeQuery("SELECT * FROM TEST");
			while (rs.next()) {
				String temp;
				// pega todos os atributos da pessoa
				temp = (rs.getString("ID"));
				System.out.println(temp);
				
			}
			
		} catch (SQLException e) {
			imprimeErro("Erro ao buscar Test", e.getMessage());			
		}*/
		
		
		
		

		@SuppressWarnings("unused")
		Query Excluir = em.createNativeQuery("DROP TABLE IF EXISTS"+NomeTabela);

		em.getTransaction().commit();
		//emf.close();
	}

	public void conectar() {
		try {
			// con = ConFactory.conexao(URL, NOME, SENHA, ConFactory.MYSQL);
			con = ConFactory.conexao(URL, NOME, SENHA, ConFactory.H2);
			comando = con.createStatement();
			System.out.println("Conectado!");
		} catch (ClassNotFoundException e) {
			imprimeErro("Erro ao carregar o driver", e.getMessage());
		} catch (SQLException e) {
			imprimeErro("Erro ao conectar", e.getMessage());
		}
	}

	public void fechar() {
		try {
			comando.close();
			con.close();
			System.out.println("Conex�o Fechada");
		} catch (SQLException e) {
			imprimeErro("Erro ao fechar conex�o", e.getMessage());
		}
	}

	public void imprimeErro(String msg, String msgErro) {
		JOptionPane.showMessageDialog(null, msg, "Erro cr�tico", 0);
		System.err.println(msg);
		System.out.println(msgErro);
		System.exit(0);
	}
}
