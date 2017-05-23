package br.org.gdt.service;

import br.org.gdt.dao.FpFolhaPeriodoDAO;
import br.org.gdt.model.FpFolhaPeriodo;
import br.org.gdt.model.FpPeriodo;
import br.org.gdt.model.RecPessoa;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("fpFolhaPeriodoService")
public class FpFolhaPeriodoService {

    @Autowired
    private FpFolhaPeriodoDAO fpFolhaPeriodoDAO;

    @Transactional
    public void save(FpFolhaPeriodo fpFolhaPeriodo) {
        fpFolhaPeriodoDAO.save(fpFolhaPeriodo);
    }

    @Transactional
    public void update(FpFolhaPeriodo fpFolhaPeriodo) {
        fpFolhaPeriodoDAO.update(fpFolhaPeriodo);
    }

    @Transactional
    public void delete(long id) {
        fpFolhaPeriodoDAO.delete(id);
    }

    public FpFolhaPeriodo findById(long id) {
        return fpFolhaPeriodoDAO.findById(id);
    }

    public List<FpFolhaPeriodo> findAll() {
        return fpFolhaPeriodoDAO.findAll();
    }

    public List<FpFolhaPeriodo> findAllPeriodo(FpPeriodo fpPeriodo) {
        return fpFolhaPeriodoDAO.findAllPeriodo(fpPeriodo);
    }
    
    public FpFolhaPeriodo findByPessoaEPeriodo(FpPeriodo fpPeriodo, RecPessoa recPessoa) {
        return fpFolhaPeriodoDAO.findByPessoaEPeriodo(fpPeriodo, recPessoa);
    }
}
