package br.com.banco.main.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;


@Data
@Entity
@lombok.EqualsAndHashCode(of = "idConta")
public class Conta {

    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idConta;

    @Column(length = 50, nullable = false)
    private String nomeResponsavel;
    
    
}
