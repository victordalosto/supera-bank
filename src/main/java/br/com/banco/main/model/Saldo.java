package br.com.banco.main.model;
import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Saldo implements Serializable {

    @Id
    private Integer idConta;

    private BigDecimal saldo;


    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CONTA_ID")
    private Conta conta;
    
}
