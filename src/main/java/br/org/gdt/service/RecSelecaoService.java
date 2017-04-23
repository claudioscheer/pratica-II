package br.org.gdt.service;

import br.org.gdt.dao.RecSelecaoDAO;
import br.org.gdt.model.RecSelecao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("recSelecaoService")
public class RecSelecaoService {

    @Autowired
    private RecSelecaoDAO selecaoDao;

    @Transactional
    public void Inserir(RecSelecao selecao) {
        selecaoDao.save(selecao);
    }

    @Transactional
    public void Alterar(RecSelecao selecao) {
        selecaoDao.save(selecao);
    }

    @Transactional
    public void Excluir(int id) {
        selecaoDao.delete(id);
    }

    public RecSelecao BuscarId(int id) {
        return selecaoDao.findById(id);
    }

    public List<RecSelecao> ListarTodas() {
        return selecaoDao.findAll();
    }
}
