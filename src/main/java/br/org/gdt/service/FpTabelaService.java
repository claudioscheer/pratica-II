package br.org.gdt.service;

import br.org.gdt.dao.FpTabelaDAO;
import br.org.gdt.model.FpTabela;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("fpTabelaService")
public class FpTabelaService {

    @Autowired
    private FpTabelaDAO fpTabelaDAO;

    @Transactional
    public void save(FpTabela tabela) {
        fpTabelaDAO.save(tabela);
    }

    @Transactional
    public void update(FpTabela tabela) {
        fpTabelaDAO.update(tabela);
    }

    @Transactional
    public void delete(long id) {
        fpTabelaDAO.delete(id);
    }

    public FpTabela findById(long id) {
        return fpTabelaDAO.findById(id);
    }

    public List<FpTabela> findAll() {
        return fpTabelaDAO.findAll();
    }
}
