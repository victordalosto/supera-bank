package br.com.banco.extrato.service;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;
import br.com.banco.extrato.model.SaldoDto;
import br.com.banco.main.model.Transferencia;


@Service
public class ExtratoService {

    public SaldoDto obtemSaldoDtoTotaisNaLista(List<Transferencia> lista) {
        BigDecimal saldoPositivo = somaSaldosPositivosDaLista(lista);
        BigDecimal saldoNegativo = somaSaldosNegativosDaLista(lista);
        BigDecimal saldoTotal = somaSaldoTotalDaLista(lista);
        return SaldoDto.builder()
                       .saldoEntrada(saldoPositivo)
                       .saldoSaida(saldoNegativo)
                       .saltoTotal(saldoTotal)
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
