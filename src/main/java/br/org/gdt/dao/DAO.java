package br.org.gdt.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class DAO<T> {

    @PersistenceContext
    EntityManager entityManager;

    protected Class<T> classe;

    public void save(T object) {
      
        entityManager.persist(object);
    }

    public void update(T object) {
        entityManager.merge(object);
    }

    public void delete(long id) {
        T object = entityManager.getReference(classe, id);
        entityManager.remove(object);
    }

    public T findById(long id) {
        return entityManager.find(classe, id);
    }
    
    public List<T> findAll() {
        return entityManager.createQuery("from " + classe.getName() + " as t").getResultList();
    }
}
