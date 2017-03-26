package br.org.gdt.dao;

import br.org.gdt.model.Bloco;
import br.org.gdt.model.Tarefa;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository("tarefaDAO")
public class TarefaDAO extends DAO<Tarefa> {
    
    public TarefaDAO() {
        classe = Tarefa.class;
    }
    
    public List<Tarefa> findByBloco(Bloco bloco) {
        return entityManager.createQuery("from Tarefa as t where t.bloco = :p_bloco")
                    .setParameter("p_bloco", bloco)
                    .getResultList();
    }
}

