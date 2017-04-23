/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.service;

import br.org.gdt.dao.GchUFsDAO;
import br.org.gdt.model.GchUfs;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Diego
 */
@Service("gchUFsService")
public class GchUFsService {
      @Autowired
    private GchUFsDAO gchUFsDao;

    @Transactional
    public void save(GchUfs gchUFs) {
        gchUFsDao.save(gchUFs);
    }

    @Transactional
    public void update(GchUfs gchUFs) {
        gchUFsDao.update(gchUFs);
    }

    @Transactional
    public void delete(long id) {
        gchUFsDao.delete(id);
    }

    public GchUfs findById(long id) {
        return gchUFsDao.findById(id);
    }

    public List<GchUfs> findAll() {
        return gchUFsDao.findAll();
    }
}
