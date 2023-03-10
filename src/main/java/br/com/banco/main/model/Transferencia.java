package br.com.banco.main.model;
import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Data
@Entity
@EqualsAndHashCode(of = "id")
public class Transferencia {

    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Timestamp dataTransferencia;

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(length = 15, nullable = false)
    private String tipo;

    @Column(length = 250, name = "nome_operador_transacao")
    private String operador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CONTA_ID")
    @JsonIgnore  @ToString.Exclude
    private Conta conta;

    
}
