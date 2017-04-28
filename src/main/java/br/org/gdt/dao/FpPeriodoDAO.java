package br.org.gdt.dao;

import br.org.gdt.model.FpPeriodo;
import org.springframework.stereotype.Repository;

@Repository("fpPeriodoDAO")
public class FpPeriodoDAO extends DAO<FpPeriodo> {

    public FpPeriodoDAO() {
        classe = FpPeriodo.class;
    }

    public FpPeriodo getPeriodoAtivo() {
        try {
            return (FpPeriodo) entityManager.createQuery("from " + classe.getName() + " as t where t.perAtivo = true").getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

}
