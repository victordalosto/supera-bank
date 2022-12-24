package br.com.banco.extrato.controller.api;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.banco.main.model.Saldo;
import br.com.banco.main.repository.SaldoUsuarioRepository;


@RestController
@RequestMapping("/api/saldo")
public class SaldoRestController {

    @Autowired
    private SaldoUsuarioRepository saldoUsuarioRepository;


    @GetMapping("/{id}")
    public BigDecimal obtemSaldo( @PathVariable Integer id) {
        Optional<Saldo> optSaldo = saldoUsuarioRepository.findById(id);
        if (optSaldo.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario de id: "+ id +" nao pode ser encontrado.");
        return optSaldo.get().getSaldo();
    }





    
}
