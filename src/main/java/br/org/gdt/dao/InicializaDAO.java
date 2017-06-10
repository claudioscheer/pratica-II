package br.org.gdt.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository("inicializaDAO")
public class InicializaDAO {

    @PersistenceContext
    EntityManager entityManager;

    public void inicializar(String sql) {
        Query q = entityManager.createNativeQuery(sql);
        q.executeUpdate();
    }

}