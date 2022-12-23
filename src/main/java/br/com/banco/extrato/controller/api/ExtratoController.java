package br.com.banco.extrato.controller.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import br.com.banco.extrato.service.ExtratoService;
import br.com.banco.main.model.Transferencia;
import br.com.banco.main.repository.TransferenciaRepository;


@RestController
@RequestMapping("/api/extrato")
public class ExtratoController {

    @Autowired
    TransferenciaRepository transferenciaRepository;

    @Autowired
    ExtratoService extratoService;


    @GetMapping("/{id}")
    ResponseEntity<Page<Transferencia>> obtemExtratoPorId(
                @PathVariable Integer id, 
                @PageableDefault(sort = "dataTransferencia", direction = Direction.DESC, page = 0, size = 10)
                Pageable paginacao) {
        Page<Transferencia> pageTransferencias = transferenciaRepository.buscaListaTransferenciasPorIdConta(id, paginacao);
        if (pageTransferencias.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario nao pode ser encontrado");
        return ResponseEntity.ok().body(pageTransferencias);
    }
    
    
}
