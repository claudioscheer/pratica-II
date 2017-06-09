/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.dao;

import br.org.gdt.model.CsbffEscalaHoras;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Juliano
 */
@Repository("CsbffEscalaHorasDAO")
public class CsbffEscalaHorasDAO extends DAO<CsbffEscalaHoras> {

    public CsbffEscalaHorasDAO() {
        classe = CsbffEscalaHoras.class;
    }
//   public CsbffEscalaHoras findByRecCpf(String recCpf) {
//
//        TypedQuery<CsbffEscalaHoras> query = entityManager.createQuery("from CsbffEscalaHoras as e left join fetch e.csbffEscalaHorasList where e.recCpf = :recCpf", CsbffEscalaHoras.class);
//        query.setParameter("recCpf", recCpf);
//        try {
//            CsbffEscalaHoras escalaHora = query.getSingleResult();
//           
//            return escalaHora;
//
//        } catch (NoResultException e) {
//            return null;
//
//        }
//    }

}

    