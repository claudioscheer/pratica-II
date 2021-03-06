package br.org.gdt.service;

import br.org.gdt.dao.GchFormularioPessoaDAO;
import br.org.gdt.model.GchFormularioPessoa;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service("gchFormularioPessoaService")
public class GchFormularioPessoaService {
    
    @Autowired
    private GchFormularioPessoaDAO gchFormularioPessoaDAO;

    @Transactional
    public void save(GchFormularioPessoa formPess) {
        gchFormularioPessoaDAO.save(formPess);
        
        
    }

    @Transactional
    public void update(GchFormularioPessoa formPess) {
        gchFormularioPessoaDAO.update(formPess);
    }

    @Transactional
    public void delete(long id) {
        gchFormularioPessoaDAO.delete(id);
    }

    public GchFormularioPessoa findById(long id) {
        return gchFormularioPessoaDAO.findById(id);
    }

    public List<GchFormularioPessoa> findAll() {
        
        return gchFormularioPessoaDAO.findAll();
    }
    
    public int BuscaPkFormularioPessoa(long idpessoa, long idformulario){     
        return gchFormularioPessoaDAO.retornaPkFormularioPessoa(idpessoa, idformulario);
    }
    
    public boolean VerificaSeJaRespondeu(long idpessoa, long idformulario){
        
        return gchFormularioPessoaDAO.VerificaSeJaRespondeu(idpessoa, idformulario);
        
        
    }
    
    public List<GchFormularioPessoa> VerificaExistenciaFormulario(long idFormulario){
        
        return gchFormularioPessoaDAO.formularioExistentes(idFormulario);
        
    }
    
}
