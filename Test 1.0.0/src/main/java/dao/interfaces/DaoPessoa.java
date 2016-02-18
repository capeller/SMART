package dao.interfaces;

import java.util.List;
import java.util.Vector;

import model.Pessoa;

public interface DaoPessoa {
	
	public Pessoa getById(final Long id);
	public List<Pessoa> findAll();
	public void persist(Pessoa pessoa);
	public void merge(Pessoa pessoa);
	public void remove(Pessoa pessoa);
	public void removeById(final Long id);	

}