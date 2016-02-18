package dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
 
import model.Pessoa;
 
public class DaoPessoa implements dao.interfaces.DaoPessoa {
    protected EntityManager entityManager;
 
    public DaoPessoa() {
        entityManager = getEntityManager();
    }
 
    private EntityManager getEntityManager() {
        EntityManagerFactory factory = 
        		Persistence.createEntityManagerFactory("TestH2JPA");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
 
        return entityManager;
    }
 
    public Pessoa getById(final Long id) {
        return entityManager.find(Pessoa.class, id);
    }
 
    @SuppressWarnings("unchecked")
    public List<Pessoa> findAll() {
    	//System.out.println(entityManager.createQuery("FROM " + Pessoa.class.getName()));
        return entityManager.createQuery("FROM " + Pessoa.class.getName())
                .getResultList();
    }
 
    public void persist(Pessoa pessoa) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(pessoa);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
 
    public void merge(Pessoa pessoa) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(pessoa);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
 
    public void remove(Pessoa pessoa) {
        try {
            entityManager.getTransaction().begin();
            pessoa = entityManager.find(Pessoa.class, pessoa.getId());
            entityManager.remove(pessoa);
            entityManager.createNativeQuery("DELETE * TABLE pessoas" );
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
 
    public void removeById(final Long id) {
        try {
            Pessoa pessoa = getById(id);
            remove(pessoa);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}