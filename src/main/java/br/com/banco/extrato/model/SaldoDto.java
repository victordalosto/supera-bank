package br.com.banco.extrato.model;
import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class SaldoDto {

    private BigDecimal saldoEntrada;
    private BigDecimal saldoSaida;
    private BigDecimal saltoTotal;

    
}
