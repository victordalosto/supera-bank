package br.com.banco.extrato.model;
import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class SaldoMovimentacoesDTO {

    private BigDecimal saldoEntradaNoPeriodo;
    private BigDecimal saldoSaidaNoPeriodo;
    private BigDecimal saldoTotalNoPeriodo;

    
}
