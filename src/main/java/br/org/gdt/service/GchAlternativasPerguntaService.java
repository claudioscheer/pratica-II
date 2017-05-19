package br.org.gdt.service;

import br.org.gdt.dao.GchAlternativaCertoDAO;
import br.org.gdt.dao.GchAlternativasPerguntasDAO;
import br.org.gdt.model.GchAlternativas;
import br.org.gdt.model.GchAlternativasperguntas;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service("gchAlternativaPerguntasService")
public class GchAlternativasPerguntaService {
    
    @Autowired
    private GchAlternativasPerguntasDAO gchAlternativasPerguntasDAO;

    @Transactional
    public void save(GchAlternativasperguntas alt) {
        gchAlternativasPerguntasDAO.save(alt);
        
        System.out.println("chamou para salvar");
    }

    @Transactional
    public void update(GchAlternativasperguntas alt) {
        gchAlternativasPerguntasDAO.update(alt);
    }

    @Transactional
    public void delete(long id) {
        gchAlternativasPerguntasDAO.delete(id);
    }

    public GchAlternativasperguntas findById(long id) {
        return gchAlternativasPerguntasDAO.findById(id);
    }

    public List<GchAlternativasperguntas> findAll() {
        System.out.println("Aqui estou eu");
        return gchAlternativasPerguntasDAO.findAll();
    }
}
