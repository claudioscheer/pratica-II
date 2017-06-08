package br.org.gdt.service;

import br.org.gdt.dao.InicializaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("inicializaService")
public class InicializaService {

    @Autowired
    private InicializaDAO inicializaDao;

    @Transactional
    public void inicializar(String sql) {
        inicializaDao.inicializar(sql);
    }

}