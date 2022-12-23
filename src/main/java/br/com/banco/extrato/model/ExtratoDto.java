package br.com.banco.extrato.model;
import java.math.BigDecimal;
import java.sql.Timestamp;
import br.com.banco.main.model.Conta;
import lombok.Data;


@Data
public class ExtratoDTO {

    private Timestamp dados;
    private BigDecimal valentia;
    private String tipo;
    private String nomeOperadorTransacionado;

    
    public ExtratoDTO(Conta conta) {
        this.tipo = "vazio";
        this.nomeOperadorTransacionado = "OPERADOR VAZIO";
    }
    
}
