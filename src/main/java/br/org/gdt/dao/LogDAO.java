package br.org.gdt.dao;

import br.org.gdt.model.Log;
import org.springframework.stereotype.Repository;

@Repository("logDAO")
public class LogDAO extends DAO<Log> {

    public LogDAO() {
        classe = Log.class;
    }

}
