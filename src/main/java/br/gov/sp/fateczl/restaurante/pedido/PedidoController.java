package br.gov.sp.fateczl.restaurante.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import br.gov.sp.fateczl.restaurante.cliente.ClienteService;
import br.gov.sp.fateczl.restaurante.prato.Prato;
import br.gov.sp.fateczl.restaurante.prato.PratoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/pedido")
public class PedidoController
{
    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private PratoService pratoService;

    @Autowired ClienteService clienteService;

    @GetMapping
    public String carregaPaginaListagem(Model model)
    {
        model.addAttribute("listaPedidos", pedidoService.procurarTodos());
        return "pedido/listagem";
    }

    @GetMapping("/cadastro")
    public String carregaPaginaCadastro(Long id, Model model)
    {
        model.addAttribute("listaPratos", pratoService.procurarTodos());
        model.addAttribute("listaClientes", clienteService.procurarTodos());
        if (id != null) {
            Pedido pedido = pedidoService.procurarPorId(id);
            model.addAttribute("pedido", pedido);
        }
        return "pedido/cadastro";
    }

    @PostMapping
    @Transactional
    public String cadastrar(@Valid DadosCadastroPedido dados)
    {
        Prato prato = pratoService.procurarPorId(dados.prato().getId());
        Pedido pedido = new Pedido(dados, prato);
        pedidoService.salvar(pedido);
        return "redirect:pedido";
    }

    @DeleteMapping
    @Transactional
    public String excluir(Long id)
    {
        pedidoService.apagarPorId(id);
        return "redirect:pedido";
    }

    @PutMapping
    @Transactional
    public String atualizar(DadosAtualizaPedido dados)
    {
        Pedido pedido = pedidoService.procurarPorId(dados.id());
        pedido.atualizar(dados);
        return "redirect:pedido";
    }
}
