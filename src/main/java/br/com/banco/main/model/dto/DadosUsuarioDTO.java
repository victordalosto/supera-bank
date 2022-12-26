package br.com.banco.main.model.dto;
import br.com.banco.main.model.DadosBancario;
import lombok.Data;


@Data
public class DadosUsuarioDTO {

    private String id;
    private String nome;
    private String agencia;
    private String contaCorrente;


    public DadosUsuarioDTO(DadosBancario dadosBancario) {
        this.id = dadosBancario.getIdConta().toString();
        this.nome = dadosBancario.getConta().getNomeResponsavel();
        this.agencia = formataDadosConta(dadosBancario.getAgencia());
        this.contaCorrente = formataDadosConta(dadosBancario.getContaCorrente());
    }


    public static DadosUsuarioDTO converterEmDTO(DadosBancario dadosBancario) {
        return new DadosUsuarioDTO(dadosBancario);
    }


    private String formataDadosConta(Integer id) {
        return id/10 + "-" + Math.abs(id%10);
    }

    
}
