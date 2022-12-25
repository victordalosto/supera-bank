package br.com.banco.extrato.controller.api;
import java.math.BigDecimal;
import java.util.Optional;
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
import br.com.banco.extrato.model.ExtratoDTO;
import br.com.banco.extrato.model.SaldoMovimentacoesDTO;
import br.com.banco.extrato.model.PaginaExtrato;
import br.com.banco.extrato.service.MovimentacoesService;
import br.com.banco.main.model.Conta;
import br.com.banco.main.model.Transferencia;
import br.com.banco.main.repository.ContaRepository;
import br.com.banco.main.repository.TransferenciaRepository;


@RestController
@RequestMapping("/api/extrato")
public class ExtratoRestController {

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private SaldoRestController saldoRestController;

    @Autowired
    private MovimentacoesService movimentacoesService;


    @GetMapping("/{id}")
    public ResponseEntity<PaginaExtrato> obtemPaginaExtrato(
                @PathVariable Integer id, 
                @PageableDefault(sort = "dataTransferencia", direction = Direction.DESC, page = 0, size = 10)
                Pageable paginacao) {
        validaSeUsuarioExiste(id);
        BigDecimal saldoUsuario = saldoRestController.obtemSaldo(id);
        Page<Transferencia> pageTransferencias = transferenciaRepository.buscaListaTransferenciasPorIdConta(id, paginacao);
        SaldoMovimentacoesDTO saldoMovimentacoesDTO = movimentacoesService.obtemMovimentacoesDTONaLista(pageTransferencias.getContent());
        Page<ExtratoDTO> extratoDTO = ExtratoDTO.converteEmDTO(pageTransferencias);
        PaginaExtrato paginaExtrato = new PaginaExtrato(saldoUsuario, saldoMovimentacoesDTO, extratoDTO);
        return ResponseEntity.ok().body(paginaExtrato);
    }



    private void validaSeUsuarioExiste(Integer id) {
        Optional<Conta> optConta = contaRepository.findById(id);
        if (optConta.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario de id: "+ id +" nao pode ser encontrado.");
    }


    
}
