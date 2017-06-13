/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.service.FichaFuncional;

import br.org.gdt.service.RecPessoaService;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.faces.context.FacesContext;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juliano
 */
@Service("fichaFuncional")
public class FichaFuncional {

    private final DecimalFormat decimalFormat = new DecimalFormat("#0.00");

    @Autowired
    private RecPessoaService recPessoaService;

    public void gerarFichaFuncional() throws Exception {

        List<JasperPrint> reports = new ArrayList<>();

        FacesContext context = FacesContext.getCurrentInstance();

        String caminhoCompletoArquivo = context.getExternalContext().getRealPath("/c_s_b_f_f/report/ReportFichaFuncional.jasper");
        File fileRelatorio = new File(caminhoCompletoArquivo);
        if (!fileRelatorio.exists()) {
            throw new Exception("O arquivo não foi encontrado.");
        }

    }
}
