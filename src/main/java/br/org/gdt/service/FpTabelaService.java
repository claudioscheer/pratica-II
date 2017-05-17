package br.org.gdt.service;

import br.org.gdt.dao.FpTabelaDAO;
import br.org.gdt.model.FpFaixa;
import br.org.gdt.model.FpTabela;
import br.org.gdt.model.FpTabelaVigencia;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("fpTabelaService")
public class FpTabelaService {

    @Autowired
    private FpTabelaDAO fpTabelaDAO;

    @Transactional
    public void save(FpTabela tabela) {
        fpTabelaDAO.save(tabela);
    }

    @Transactional
    public void update(FpTabela tabela) {
        fpTabelaDAO.update(tabela);
    }

    @Transactional
    public void delete(long id) {
        fpTabelaDAO.delete(id);
    }

    public FpTabela findById(long id) {
        return fpTabelaDAO.findById(id);
    }

    public List<FpTabela> findAll() {
        return fpTabelaDAO.findAll();
    }

    public FpFaixa encontrarFaixaDaTabela(double valor, long idTabela) throws Exception {
        return encontrarFaixaDaTabela(valor, findById(idTabela));
    }

    public FpFaixa encontrarFaixaDaTabela(double valor, FpTabela fpTabela) throws Exception {
        List<FpTabelaVigencia> vigencias = fpTabela.getTabVigencias().stream()
                .filter(x -> !Calendar.getInstance().before(x.getTabVigenciaData()))
                .sorted((x, y) -> x.getTabVigenciaData().compareTo(y.getTabVigenciaData()))
                .collect(Collectors.toList());
        if (vigencias == null || vigencias.size() <= 0) {
            throw new Exception("Não há nenhuma vigência na tabela " + fpTabela.getTabNome() + ".");
        }
        FpTabelaVigencia vigencia = vigencias.get(0);
        List<FpFaixa> faixas = vigencia.getTabVigenciaFaixas().stream()
                .filter(x -> valor <= x.getFaiLimite())
                .sorted((x, y) -> Double.compare(x.getFaiLimite(), y.getFaiLimite()))
                .collect(Collectors.toList());
        if (faixas.size() > 0) {
            return faixas.get(0);
        }
        Optional<FpFaixa> faixa = vigencia.getTabVigenciaFaixas().stream()
                .filter(x -> x.getFaiLimite() == 0)
                .findFirst();
        if (!faixa.isPresent()) {
            throw new Exception("Não há nenhuma faixa na tabela " + fpTabela.getTabNome() + ".");
        }
        return faixa.get();
    }
}
