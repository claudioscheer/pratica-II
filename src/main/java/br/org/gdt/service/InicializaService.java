/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.service;

import br.org.gdt.dao.InicializaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Diego
 */
@Service("inicializaService")
public class InicializaService {
    
    @Autowired
    private InicializaDAO inicializaDao;
    
    @Transactional
    public void inicializar(String sql){
    
        inicializaDao.inicializar(sql);
        
    }
    
    
}
