package br.com.banco.extrato.model;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

import lombok.Data;


@Data
public class PaginaExtrato {

    private String saldoAtual;
    private SaldoMovimentacoesDTO movimentacoes;
    private Page<ExtratoDTO> extratos;

    public PaginaExtrato(BigDecimal saldoAtual, SaldoMovimentacoesDTO movimentacoes, Page<ExtratoDTO> extratos) {
        this.saldoAtual = "R$ " + saldoAtual.setScale(2, RoundingMode.HALF_EVEN).toString().replaceAll("\\.", ",");
        this.movimentacoes = movimentacoes;
        this.extratos = extratos;   
    }



    public List<ExtratoDTO> obtemListaExtrato(){
        if (extratos.getContent() == null)
            return new ArrayList<ExtratoDTO>();
        return this.extratos.getContent();
    }   

    
}
