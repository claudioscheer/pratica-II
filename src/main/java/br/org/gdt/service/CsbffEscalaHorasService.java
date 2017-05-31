/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.service;

import br.org.gdt.dao.CsbffEscalaHorasDAO;
import br.org.gdt.model.CsbffEscalaHoras;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Juliano
 */
@Service("CsbffEscalaHorasService")
public class CsbffEscalaHorasService {
    @Autowired
    private CsbffEscalaHorasDAO csbffEscalaHorasDAO;

    @Transactional
    public void save(CsbffEscalaHoras csbffEscalaHoras) {
        csbffEscalaHorasDAO.save(csbffEscalaHoras);
    }

    @Transactional
    public void update(CsbffEscalaHoras csbffEscalaHoras) {
        csbffEscalaHorasDAO.update(csbffEscalaHoras);
    }

    @Transactional
    public void delete(long id) {
        csbffEscalaHorasDAO.delete(id);
    }

    public CsbffEscalaHoras findById(long id) {
        return csbffEscalaHorasDAO.findById(id);
    }

    public List<CsbffEscalaHoras> findAll() {
        return csbffEscalaHorasDAO.findAll();
    }
    
}
