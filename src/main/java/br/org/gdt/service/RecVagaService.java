package br.org.gdt.service;

import br.org.gdt.dao.RecVagaDAO;
import br.org.gdt.model.RecVaga;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("recVagaService")
public class RecVagaService {
    
    @Autowired
    private RecVagaDAO vagaDao;
    
    @Transactional
    public void Inserir(RecVaga vaga) {
        vagaDao.save(vaga);
    }
    @Transactional
    public void Alterar(RecVaga vaga) {
        vagaDao.update(vaga);
    }
    @Transactional
    public void Excluir(long id) {
        vagaDao.delete(id);
    }
    
    public RecVaga BuscarId(int id){
        return vagaDao.findById(id);
    }
    
    public List<RecVaga> ListarTodas() {
        return vagaDao.findAll();
    }
    
    public List<RecVaga> PesquisarPorDescricao(String busca){
        return vagaDao.PesquisarPorDescricao(busca);
    }
    
    public List<RecVaga> ListarTodasVagasInternas(){
        return vagaDao.BuscarVagasInternas();
    }
    
    public List<RecVaga> ListarTodasVagasExternas(){
        return vagaDao.BuscarVagasExternas();
    }
}
