package br.com.banco.extrato.specification;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import br.com.banco.extrato.model.ExtratoForm;
import br.com.banco.main.model.Transferencia;
import br.com.banco.main.repository.TransferenciaRepository;


@Service
public class ExtratoSpecification {

    SimpleDateFormat formatadorData = new SimpleDateFormat("yyyy-MM-dd");  

    @Autowired
    TransferenciaRepository transferenciaRepository;


    // Encontrei problema com o specification para essa versao do Spring e acabei fazendo hard code
    public Page<Transferencia> listPageTransferenciaHandlingFilters(ExtratoForm extratoForm, 
    @PageableDefault(sort = "dataTransferencia", direction = Direction.DESC, page = 0, size = 100) Pageable paginacao) {
        System.out.println(extratoForm);
        if (isNotValid(extratoForm.getDataFim()) && isNotValid(extratoForm.getDataInicio()) && isNotValid(extratoForm.getOperador()))
            return transferenciaRepository.buscaListaTransferenciasPorIdConta(extratoForm.getId(), paginacao);
        if ((isNotValid(extratoForm.getDataFim()) || isNotValid(extratoForm.getDataInicio())) && extratoForm.getOperador().length() > 0) {
            return transferenciaRepository.buscaListaTransferenciasPorIdContaEOperador(extratoForm.getId(),  extratoForm.getOperador().toUpperCase(), paginacao);
        }
        try {
            Date inicio = formatadorData.parse(extratoForm.getDataInicio());
            Date fim = formatadorData.parse(extratoForm.getDataFim());
            if (extratoForm.getOperador() == null || extratoForm.getOperador().length() <= 1)
                return transferenciaRepository.buscaListaTransferenciasPorIdEDatas(extratoForm.getId(), inicio, fim, paginacao);
            return transferenciaRepository.buscaListaTransferenciasPorIdEOperadorEDatas(extratoForm.getId(), extratoForm.getOperador().toUpperCase(), inicio, fim, paginacao);
            } catch (ParseException e) {
                e.printStackTrace();
                return transferenciaRepository.buscaListaTransferenciasPorIdConta(extratoForm.getId(), paginacao);
            }
    }



    private boolean isNotValid(String value) {
        if (value == null || value.length() == 0)
            return true;
        return false;
    }


}
