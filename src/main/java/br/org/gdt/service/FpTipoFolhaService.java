package br.org.gdt.service;
import br.org.gdt.dao.FpTipoFolhaDAO;
import br.org.gdt.model.FpTipoFolha;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author Larissa Guder <lariguder10@gmail.com>
 */
@Service("fpTipoFolhaService")

public class FpTipoFolhaService {
     @Autowired
    private FpTipoFolhaDAO fpTipoFolhaDAO;

    @Transactional
    public void save(FpTipoFolha fpTipoFolha) {
        fpTipoFolhaDAO.save(fpTipoFolha);
    }

    @Transactional
    public void update(FpTipoFolha fpTipoFolha) {
        fpTipoFolhaDAO.update(fpTipoFolha);
    }

    @Transactional
    public void delete(long id) {
        fpTipoFolhaDAO.delete(id);
    }

    public FpTipoFolha findById(long id) {
        return fpTipoFolhaDAO.findById(id);
    }

    public List<FpTipoFolha> findAll() {
        return fpTipoFolhaDAO.findAll();
    }
}
