package br.com.banco.extrato.controller.api;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.banco.extrato.model.ExtratoForm;
import br.com.banco.extrato.model.PaginaExtrato;


@RestController
@RequestMapping("/teste")
public class testa {

    
    @GetMapping
    public ResponseEntity<PaginaExtrato> obtemPaginaExtrato(ExtratoForm extratoForm, 
                                                            @PageableDefault(sort = "dataTransferencia", direction = Direction.DESC, page = 0, size = 5) Pageable paginacao) {
        
        
        return ResponseEntity.ok().body(null);
    }
    
}
