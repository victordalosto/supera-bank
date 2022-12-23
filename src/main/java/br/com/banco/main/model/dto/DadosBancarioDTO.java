package br.com.banco.main.model.dto;
import br.com.banco.main.model.DadosBancario;
import lombok.Data;


@Data
public class DadosBancarioDTO {

    private String agencia;
    private String contaCorrente;


    public DadosBancarioDTO(DadosBancario dadosBancario) {
        this.agencia = formataDadosConta(dadosBancario.getAgencia());
        this.contaCorrente = formataDadosConta(dadosBancario.getContaCorrente());
    }


    public static DadosBancarioDTO converterEmDTO(DadosBancario dadosBancario) {
        return new DadosBancarioDTO(dadosBancario);
    }


    private String formataDadosConta(Integer id) {
        return id/10 + "-" + Math.abs(id%10);
    }

    
}
