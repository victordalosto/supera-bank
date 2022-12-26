package br.com.banco.main.model;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;


@Data
@Entity
@lombok.EqualsAndHashCode(of = "idConta")
public class Conta {

    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idConta;

    @Column(length = 50, nullable = false)
    private String nomeResponsavel;

    @OneToOne(mappedBy = "conta", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private DadosBancario dadosBancario;

    @OneToMany(mappedBy = "conta", cascade = CascadeType.ALL, orphanRemoval = true) 
    @JsonIgnore  @ToString.Exclude
    private List<Transferencia> listTransferencias = new ArrayList<>();

    
}
