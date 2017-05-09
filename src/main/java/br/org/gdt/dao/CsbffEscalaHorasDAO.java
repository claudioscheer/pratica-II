/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.dao;

import br.org.gdt.model.CsbffEscalaHoras;
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

}
