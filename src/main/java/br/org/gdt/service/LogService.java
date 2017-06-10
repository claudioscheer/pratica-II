package br.org.gdt.service;

import br.org.gdt.dao.LogDAO;
import br.org.gdt.enums.LogModulo;
import br.org.gdt.model.Log;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("logService")
public class LogService {

    @Autowired
    private LogDAO logDAO;

    @Transactional
    public void save(Log log) {
        logDAO.save(log);
    }

    @Transactional
    public void update(Log log) {
        logDAO.update(log);
    }

    @Transactional
    public void delete(long id) {
        logDAO.delete(id);
    }

    public Log findById(long id) {
        return logDAO.findById(id);
    }

    public List<Log> findAll() {
        return logDAO.findAll();
    }

    public void log(LogModulo modulo, String descricao) {
        Log log = new Log();
        log.setModulo(modulo);
        log.setDescricao(descricao);
        log.setData(new Date());
        log.setPessoa("claudio");
        update(log);
    }
}
