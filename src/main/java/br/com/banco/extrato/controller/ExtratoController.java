package br.com.banco.extrato.controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.extrato.model.ExtratoDto;
import br.com.banco.main.model.Transferencia;
import br.com.banco.main.repository.TransferenciaRepository;


@RestController
@RequestMapping("/extrato")
public class ExtratoController {

    @Autowired
    TransferenciaRepository transferenciaRepository;


    @GetMapping("/{id}")
    ExtratoDto obtemExtratoPorId(@PathVariable Integer id) {
        Optional<Transferencia> optTransferencia = transferenciaRepository.findById(id);
        if (optTransferencia.isPresent()) {
            Transferencia transferencia = optTransferencia.get();
            
        }
        return null;
    }
    
}
