package br.com.banco.extrato.controller;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.banco.extrato.model.ExtratoDto;
import br.com.banco.main.model.Conta;
import br.com.banco.main.repository.ContaRepository;


@RestController
@RequestMapping("/extrato")
public class ExtratoController {

    @Autowired
    ContaRepository contaRepository;


    @GetMapping("/{id}")
    ResponseEntity<ExtratoDto> obtemExtratoPorId(@PathVariable Integer id) {
        Optional<Conta> optConta = contaRepository.findById(id);
        if (!optConta.isPresent())
            return ResponseEntity.notFound().header("Usuario de id: " + id, "Nao encontrado").build();
        Conta conta = optConta.get();
        ExtratoDto extratoDto = new ExtratoDto(conta);
        return ResponseEntity.ok().body(extratoDto);
    }
    
    
}
