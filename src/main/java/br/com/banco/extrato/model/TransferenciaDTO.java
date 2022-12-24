package br.com.banco.extrato.model;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import org.springframework.data.domain.Page;

import br.com.banco.main.model.Transferencia;
import lombok.Data;


// Classe criada como boa pratica, manutencao e escalabilidade, pois: transferenciaDTO ja tem @JsonIgnore
@Data
public class TransferenciaDTO {

    static private DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private String dataTransferencia;
    private String valor;
    private String tipo;
    private String nomeOperadorTransacao;


    public TransferenciaDTO(Transferencia transferencia) {
        this.dataTransferencia = formatadorData.format(transferencia.getDataTransferencia().toLocalDateTime().toLocalDate());
        this.valor = "R$ " + transferencia.getValor().setScale(2, RoundingMode.HALF_EVEN).toString().replaceAll("\\.", ",");
        this.tipo = transferencia.getTipo();
        this.nomeOperadorTransacao = transferencia.getNomeOperadorTransacao();
    }


    public static Page<TransferenciaDTO> converteEmDTO(Page<Transferencia> pageTransferencias) {
        return pageTransferencias.map(TransferenciaDTO::new);
    }
    
}
