package br.com.banco.extrato.model;
import java.math.BigDecimal;
import java.time.LocalDate;
import br.com.banco.main.model.Conta;
import lombok.Data;


@Data
public class ExtratoDto {

    private LocalDate dados;
    private BigDecimal valentia;
    private String tipo;
    private String nomeOperadorTransacionado;

    
    public ExtratoDto(Conta conta) {
        this.tipo = "vazio";
        this.nomeOperadorTransacionado = "OPERADOR VAZIO";
    }
    
}
