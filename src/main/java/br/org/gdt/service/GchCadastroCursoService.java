package br.org.gdt.service;

import br.org.gdt.dao.GchCursoDAO;
import br.org.gdt.model.GchCursos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service("servicoCurso")
public class GchCadastroCursoService {
    
    @Autowired
    private GchCursoDAO gchCursoDAO;

    @Transactional
    public void save(GchCursos curso) {
        gchCursoDAO.save(curso);
        
        System.out.println("chamou para salvar");
    }

    @Transactional
    public void update(GchCursos curso) {
        gchCursoDAO.update(curso);
    }

    @Transactional
    public void delete(long id) {
        gchCursoDAO.delete(id);
    }

    public GchCursos findById(long id) {
        return gchCursoDAO.findById(id);
    }

    public List<GchCursos> findAll() {
        return gchCursoDAO.findAll();
    }
}