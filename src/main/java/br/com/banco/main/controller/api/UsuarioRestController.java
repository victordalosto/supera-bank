package br.com.banco.main.controller.api;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.banco.main.model.DadosBancario;
import br.com.banco.main.model.dto.DadosUsuarioDTO;
import br.com.banco.main.repository.DadosBancariosRepository;


@RestController
@RequestMapping("/api/usuario")
public class UsuarioRestController {

    @Autowired
    private DadosBancariosRepository dadosBancariosRepository;


    @GetMapping("/{id}")
    public ResponseEntity<DadosUsuarioDTO> obtemExtratoBancarioPorId(@PathVariable Integer id) {
        Optional<DadosBancario> optDadosBancario = dadosBancariosRepository.findById(id);
        if (optDadosBancario.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario de id: " + id + " nao pode ser encontrado.");
        return ResponseEntity.ok().body(DadosUsuarioDTO.converterEmDTO(optDadosBancario.get()));
    }
    
}
