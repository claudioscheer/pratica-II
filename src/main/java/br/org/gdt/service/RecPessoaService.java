package br.org.gdt.service;

import br.org.gdt.dao.RecPessoaDAO;
import br.org.gdt.model.CsbffDependentes;
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
    public void save(RecPessoa recPessoa) {
        pessoaDao.save(recPessoa);
    }

    @Transactional
    public void update(RecPessoa recPessoa) {
        pessoaDao.update(recPessoa);
    }

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

    @Transactional
    public void delete(long id) {
        pessoaDao.delete(id);
    }

    public RecPessoa BuscarId(int id) {
        return pessoaDao.findById(id);
    }

    public List<RecPessoa> ListarTodas() {
        return pessoaDao.findAll();
    }

    public List<RecPessoa> findAll() {
        return pessoaDao.findAll();
    }

    public List<RecPessoa> findAllFuncionarios() {
        return pessoaDao.findAllFuncionarios();
    }

    public List<CsbffDependentes> findAllDependentesPessoa(RecPessoa recPessoa) {
        return pessoaDao.findAllDependentesPessoa(recPessoa.getRecIdpessoa());
    }

//    public RecPessoa findByCpf(String cpf) {
//        return pessoaDao.findByCpf(cpf);
//    }
    public RecPessoa findByRecCpf(String recCpf) {
        return pessoaDao.findByRecCpf(recCpf);

//    public List<RecPessoa> findByCpf(int cpf) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
