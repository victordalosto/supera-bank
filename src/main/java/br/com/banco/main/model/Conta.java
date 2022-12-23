package br.com.banco.main.model;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;


@Data
@Entity
@lombok.EqualsAndHashCode(of = "idConta")
public class Conta {

    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idConta;

    @Column(length = 50, nullable = false)
    private String nomeResponsavel;

    @OneToMany(mappedBy = "conta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transferencia> listTransferencias;
    
    
}
