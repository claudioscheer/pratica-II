package br.org.gdt.service;

import br.org.gdt.dao.RecPessoaDAO;
import br.org.gdt.model.RecPessoa;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("recPessoaService")
public class RecPessoaService {

    @Autowired
    private RecPessoaDAO pessoaDao;

    @Transactional
    public void Inserir(RecPessoa pessoa) {
        pessoaDao.save(pessoa);
    }

    @Transactional
    public void Alterar(RecPessoa pessoa) {
        pessoaDao.save(pessoa);
    }

    @Transactional
    public void Excluir(int id) {
        pessoaDao.delete(id);
    }

    public RecPessoa BuscarId(int id) {
        return pessoaDao.findById(id);
    }

    public List<RecPessoa> ListarTodas() {
        return pessoaDao.findAll();
    }
}
