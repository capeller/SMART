package dao.interfaces;

import java.util.List;
import java.util.Vector;

import model.Pessoa;

public interface DaoPessoa {
	
	public void apagar(String rg);
	public List<Pessoa> buscarTodos();
	public void atualizar(Pessoa pessoa);
	public List<Pessoa> buscar(String rg);
	public void insere(Pessoa pessoa);
	public void criaTabela(String NomeTabela);
	public void apagaTabela(String NomeTabela);
	public void conectar();
	public void fechar();
	public void imprimeErro (String msg, String msgErro);
	

}