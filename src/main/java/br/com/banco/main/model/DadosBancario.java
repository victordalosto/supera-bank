package br.com.banco.main.model;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import lombok.Data;


@Data
@Entity
public class DadosBancario implements Serializable{

    @Id
    private Integer idConta;

    private Integer agencia;

    private Integer contaCorrente;

    @OneToOne
    @MapsId
    @JoinColumn(name = "CONTA_ID")
    private Conta conta;

    
}
