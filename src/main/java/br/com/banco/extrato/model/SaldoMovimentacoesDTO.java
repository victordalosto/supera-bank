package br.com.banco.extrato.model;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class SaldoMovimentacoesDTO {

    private String saldoEntradaNoPeriodo;
    private String saldoSaidaNoPeriodo;
    private String saldoTotalNoPeriodo;

    
    public SaldoMovimentacoesDTO(String entrada, String saida, String total) {
        this.saldoEntradaNoPeriodo = "R$ " + entrada.replaceAll("\\.", ",");
        this.saldoSaidaNoPeriodo = "R$ " + saida.replaceAll("\\.", ",");
        this.saldoTotalNoPeriodo = "R$ " + total.replaceAll("\\.", ",");
        
    }

    
}
