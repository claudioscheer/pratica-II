package br.org.gdt.service;

import br.org.gdt.dao.TarefaDAO;
import br.org.gdt.modelOld.Bloco;
import br.org.gdt.modelOld.Tarefa;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("tarefaService")
public class TarefaService {

    // Métodos da classe
    // Exemplo de Programação com Java/Spring/JSF
    @Autowired
    private TarefaDAO tarefaDAO;

    @Transactional
    public void save(Tarefa tarefa) {
        tarefaDAO.save(tarefa);
    }

    @Transactional
    public void update(Tarefa tarefa) {
        tarefaDAO.update(tarefa);
    }

    @Transactional
    public void delete(long id) {
        tarefaDAO.delete(id);
    }

    public Tarefa findById(long id) {
        return tarefaDAO.findById(id);
    }

    public List<Tarefa> findByBloco(Bloco bloco) {
        return tarefaDAO.findByBloco(bloco);
    }

    public List<Tarefa> findAll() {
        return tarefaDAO.findAll();
    }
}
