package br.com.banco.extrato.controller.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.extrato.model.ExtratoForm;
import br.com.banco.extrato.specification.ExtratoSpecification;
import br.com.banco.main.model.Transferencia;


@RestController
@RequestMapping("/teste")
public class testa {

    @Autowired
    ExtratoSpecification extratoSpecification; 


    @GetMapping
    public ResponseEntity<Page<Transferencia>> obtemPaginaExtrato(ExtratoForm extratoForm, 
                                                            @PageableDefault(sort = "dataTransferencia", direction = Direction.DESC, page = 0, size = 100) Pageable paginacao) {
        Page<Transferencia> listPageTransferenciaHandlingFilters = extratoSpecification.listPageTransferenciaHandlingFilters(extratoForm, paginacao);
        
        return ResponseEntity.ok().body(listPageTransferenciaHandlingFilters);
    }
    
}
