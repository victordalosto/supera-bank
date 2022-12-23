package br.com.banco.extrato.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.banco.extrato.model.ExtratoDto;
import br.com.banco.main.model.Transferencia;
import br.com.banco.main.repository.TransferenciaRepository;


@RestController
@RequestMapping("/extrato")
public class ExtratoController {

    @Autowired
    TransferenciaRepository transferenciaRepository;


    @GetMapping("/{id}")
    ResponseEntity<ExtratoDto> obtemExtratoPorId(@PathVariable Integer id) {
        List<Transferencia> listaTransferencias = transferenciaRepository.buscaListaTransferenciasPorIdConta(id);
        if (listaTransferencias.size() == 0)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario nao pode ser encontrado");
        // List<Transferencia> listaTransferencias = optTransferencias.get();
        listaTransferencias.forEach(t -> {
            System.out.println("Imprimindo: " + t);
        });
        return ResponseEntity.ok().body(null);
    }
    
    
}
