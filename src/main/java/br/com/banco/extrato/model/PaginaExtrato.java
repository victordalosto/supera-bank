package br.com.banco.extrato.model;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class PaginaExtrato {

    private BigDecimal saldoAtual;
    private SaldoMovimentacoesDTO movimentacoes;
    private Page<ExtratoDTO> extratos;



    public List<ExtratoDTO> obtemListaExtrato(){
        if (extratos.getContent() == null)
            return new ArrayList<ExtratoDTO>();
        return this.extratos.getContent();
    }   

    
}
