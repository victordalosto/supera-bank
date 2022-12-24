package br.com.banco.extrato.model;
import java.math.BigDecimal;

import org.springframework.data.domain.Page;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class PaginaExtrato {

    private BigDecimal saldoAtual;
    private MovimentacoesDTO movimentacoes;
    private Page<ExtratoDTO> extratos;

    
}
