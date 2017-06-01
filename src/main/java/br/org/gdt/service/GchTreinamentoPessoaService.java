/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.service;

import br.org.gdt.dao.GchTreinamentoPessoasDAO;
import br.org.gdt.model.GchTreinamentospessoas;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Diego
 */
@Service("gchTreinamentoPessoaService")
public class GchTreinamentoPessoaService {

    @Autowired
    private GchTreinamentoPessoasDAO gchTreinamentoPessoasDAO;

    @Transactional
    public void save(GchTreinamentospessoas gchTreinamentospessoaspessoas) {
        gchTreinamentoPessoasDAO.save(gchTreinamentospessoaspessoas);
    }

    @Transactional
    public void update(GchTreinamentospessoas gchTreinamentospessoas) {
        gchTreinamentoPessoasDAO.update(gchTreinamentospessoas);
    }

    @Transactional
    public void delete(long id) {
        gchTreinamentoPessoasDAO.delete(id);
    }

    public GchTreinamentospessoas findById(long id) {
        return gchTreinamentoPessoasDAO.findById(id);
    }

    public List<GchTreinamentospessoas> findAll() {
        return gchTreinamentoPessoasDAO.findAll();
    }

    public List<GchTreinamentospessoas> verificaPessoa(long idTreinamento, long idPessoa) {
        return gchTreinamentoPessoasDAO.verificaPessoa(idTreinamento, idPessoa);
    }

    public List<GchTreinamentospessoas> verificaPessoasVinculadoTreinamento(long idTreinamento) {
        return gchTreinamentoPessoasDAO.verificaPessoasVinculadoTreinamento(idTreinamento);
    }
}
