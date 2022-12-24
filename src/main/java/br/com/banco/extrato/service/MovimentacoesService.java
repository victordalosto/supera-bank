package br.com.banco.extrato.service;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;
import br.com.banco.extrato.model.MovimentacoesDTO;
import br.com.banco.main.model.Transferencia;


@Service
public class MovimentacoesService {

    public MovimentacoesDTO obtemMovimentacoesDTONaLista(List<Transferencia> lista) {
        BigDecimal saldoPositivo = somaSaldosPositivosDaLista(lista);
        BigDecimal saldoNegativo = somaSaldosNegativosDaLista(lista);
        BigDecimal saldoTotal = somaSaldoTotalDaLista(lista);
        return MovimentacoesDTO.builder()
                       .saldoEntradaNoPeriodo(saldoPositivo)
                       .saldoSaidaNoPeriodo(saldoNegativo)
                       .saldoTotalNoPeriodo(saldoTotal)
                       .build();
    }



    public BigDecimal somaSaldosNegativosDaLista(List<Transferencia> lista) {
        return lista.stream()
                .filter(s -> s.getValor().compareTo(BigDecimal.ZERO) <= 0)
                .map(Transferencia::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    

    public BigDecimal somaSaldosPositivosDaLista(List<Transferencia> lista) {
        return lista.stream()
                .filter(s -> s.getValor().compareTo(BigDecimal.ZERO) >= 0)
                .map(Transferencia::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    

    public BigDecimal somaSaldoTotalDaLista(List<Transferencia> lista) {
        return lista.stream()
                .map(Transferencia::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
