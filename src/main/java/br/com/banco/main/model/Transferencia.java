package br.com.banco.main.model;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@Entity
@EqualsAndHashCode(of = "id")
public class Transferencia {

    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private LocalDate dataTransferencia;

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(length = 15, nullable = false)
    private String tipo;

    @Column(length = 250)
    private String nomeOperadorTransacao;

    @ManyToOne
    @JoinColumn(name = "CONTA_ID")
    private Conta contaId;
    
    
}
