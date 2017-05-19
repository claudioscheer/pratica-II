package br.org.gdt.service;

import br.org.gdt.dao.GchAlternativaCertoDAO;
import br.org.gdt.model.GchAlternativas;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service("gchAlternativaCertoService")
public class GchCadastroAlternativaServiceCerto {
    
    @Autowired
    private GchAlternativaCertoDAO gchAlternativaCertoDAO;

    @Transactional
    public void save(GchAlternativas alt) {
        gchAlternativaCertoDAO.save(alt);
        
        System.out.println("chamou para salvar");
    }

    @Transactional
    public void update(GchAlternativas alt) {
        gchAlternativaCertoDAO.update(alt);
    }

    @Transactional
    public void delete(long id) {
        gchAlternativaCertoDAO.delete(id);
    }

    public GchAlternativas findById(long id) {
        return gchAlternativaCertoDAO.findById(id);
    }

    public List<GchAlternativas> findAll() {
        System.out.println("Aqui estou eu");
        return gchAlternativaCertoDAO.findAll();
    }
}
