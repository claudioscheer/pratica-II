/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.dao;

import br.org.gdt.model.CsbffPessoaBeneficio;
import br.org.gdt.model.RecPessoa;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Juliano
 */
@Repository("csbffPessoaBeneficioDAO")
public class CsbffPessoaBeneficioDAO extends DAO<CsbffPessoaBeneficio> {

    public CsbffPessoaBeneficioDAO() {
        classe = CsbffPessoaBeneficio.class;
    }

    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<CsbffPessoaBeneficio> findAll(long pessoaBeneficioCodigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<CsbffPessoaBeneficio> buscaBeneficiosPessoa(RecPessoa pessoa) {
        Query query = entityManager.createQuery("from CsbffPessoaBeneficio as t where t.recIdpessoa.recIdpessoa = :idPessoa");
        query.setParameter("idPessoa", pessoa.getRecIdpessoa());

        List<CsbffPessoaBeneficio> lista = query.getResultList();

        if (lista.isEmpty()) {
            return new ArrayList<>();
        }

        return lista;
    }

}
