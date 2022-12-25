package br.com.banco.extrato.controller.web;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.banco.extrato.controller.api.ExtratoRestController;
import br.com.banco.extrato.model.PaginaExtrato;
import br.com.banco.main.controller.api.UsuarioRestController;
import br.com.banco.main.model.dto.DadosUsuarioDTO;


@Controller
@RequestMapping("/extrato")
public class ExtratoController {

    @Autowired
    private UsuarioRestController usuarioRestController;

    @Autowired
    private ExtratoRestController extratoRestController;



    @GetMapping
    public String getPaginaExtrato(Integer id, 
                                   @PageableDefault(sort = "dataTransferencia", direction = Direction.DESC, page = 0, size = 5) Pageable paginacao, 
                                   Model model) {
        DadosUsuarioDTO dadosUsuario = usuarioRestController.obtemExtratoBancarioPorId(id).getBody();
        model.addAttribute("dadosUsuario", dadosUsuario);
        PaginaExtrato paginaExtrato = extratoRestController.obtemPaginaExtrato(id, paginacao).getBody();
        model.addAttribute("listaExtrato", paginaExtrato.obtemListaExtrato());
        model.addAttribute("movimentacoes", paginaExtrato.getMovimentacoes());
        model.addAttribute("saldo", paginaExtrato.getSaldoAtual());
        model.addAttribute("dataAtual", LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MMMM/YYYY")));
        return "extrato";
    }
}
