package br.com.banco.extrato.model;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.springframework.data.domain.Page;
import br.com.banco.main.model.Transferencia;
import lombok.Data;


// Classe criada como boa pratica, manutencao e escalabilidade, pois: transferenciaDTO ja tem @JsonIgnore
@Data
public class TransferenciaDTO {

    private Timestamp dataTransferencia;
    private BigDecimal valor;
    private String tipo;
    private String nomeOperadorTransacao;


    public TransferenciaDTO(Transferencia transferencia) {
        this.dataTransferencia = transferencia.getDataTransferencia();
        this.valor = transferencia.getValor();
        this.tipo = transferencia.getTipo();
        this.nomeOperadorTransacao = transferencia.getNomeOperadorTransacao();
    }


    public static Page<TransferenciaDTO> converteEmDTO(Page<Transferencia> pageTransferencias) {
        return pageTransferencias.map(TransferenciaDTO::new);
    }
    
}
