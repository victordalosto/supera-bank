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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.banco.extrato.controller.api.ExtratoRestController;
import br.com.banco.extrato.model.ExtratoForm;
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
    public String getPaginaExtrato(ExtratoForm extratoForm, 
                                   @PageableDefault(sort = "dataTransferencia", direction = Direction.DESC, page = 0, size = 100) Pageable paginacao, 
                                   Model model) {
        return rotinaExecucao(extratoForm, paginacao, model);
    }


    @PostMapping("/form")
    public String postPaginaExtrato(ExtratoForm extratoForm, 
                                    @PageableDefault(sort = "dataTransferencia", direction = Direction.DESC, page = 0, size = 100) Pageable paginacao, 
                                    Model model) {
        return rotinaExecucao(extratoForm, paginacao, model);
    }


    private String rotinaExecucao(ExtratoForm extratoForm, Pageable paginacao, Model model) {
        if (extratoForm.getId() == null || extratoForm.getId() == 0)
            return "redirect:/";
        DadosUsuarioDTO dadosUsuario = usuarioRestController.obtemExtratoBancarioPorId(extratoForm.getId()).getBody();
        model.addAttribute("dadosUsuario", dadosUsuario);
        PaginaExtrato paginaExtrato = extratoRestController.obtemPaginaExtrato(extratoForm, paginacao).getBody();
        model.addAttribute("listaExtrato", paginaExtrato.obtemListaExtrato());
        model.addAttribute("movimentacoes", paginaExtrato.getMovimentacoes());
        model.addAttribute("saldo", paginaExtrato.getSaldoAtual());
        model.addAttribute("dataAtual", LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MMMM/YYYY")));
        model.addAttribute("form", extratoForm);
        return "extrato";
    }
}
