package br.com.banco.extrato.controller.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.banco.extrato.controller.api.ExtratoRestController;
import br.com.banco.extrato.model.TransferenciaDTO;
import br.com.banco.extrato.service.ExtratoService;
import br.com.banco.main.controller.api.UsuarioRestController;
import br.com.banco.main.model.dto.DadosUsuarioDTO;


@Controller
@RequestMapping("/extrato")
public class ExtratoController {

    @Autowired
    UsuarioRestController usuarioRestController;

    @Autowired
    ExtratoRestController extratoRestController;

    @Autowired
    ExtratoService extratoService;


    @GetMapping("/{id}")
    public String getPaginaExtrato(@PathVariable Integer id, @PageableDefault(sort = "dataTransferencia", direction = Direction.DESC, page = 0, size = 10)
                                   Pageable paginacao, Model model) {
        DadosUsuarioDTO dadosUsuario = usuarioRestController.obtemExtratoBancarioPorId(id).getBody();
        model.addAttribute("dadosUsuario", dadosUsuario);
        Page<TransferenciaDTO> listaExtrato = extratoRestController.obtemExtratoPorId(id, paginacao).getBody();
        model.addAttribute("listaExtrato", listaExtrato.getContent());
        return "extrato";
    }
}
