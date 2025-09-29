package br.gov.sp.fateczl.restaurante.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/cliente")
public class ClienteController
{
    @Autowired
    private ClienteService service;

    @GetMapping
    public String carregaPaginaListagem(Model model)
    {
        model.addAttribute("clientes", service.procurarTodos());
        return "cliente/listagem";
    }

    @GetMapping("/cadastro")
    public String carregaPaginaCadastro(Long id, Model model)
    {
        if (id != null) {
            Cliente cliente = service.procurarPorId(id);
            model.addAttribute("cliente", cliente);
        }
        return "cliente/cadastro";
    }

    @PostMapping
    @Transactional
    public String cadastrar(@Valid DadosCadastroCliente dados)
    {
        service.salvar(new Cliente(dados));
        return "redirect:cliente";
    }

    @DeleteMapping
    @Transactional
    public String excluir(Long id)
    {
        service.apagarPorId(id);
        return "redirect:cliente";
    }

    @PutMapping
    @Transactional
    public String atualizar(DadosAtualizaCliente dados)
    {
        Cliente cliente = service.procurarPorId(dados.id());
        cliente.atualizar(dados);
        return "redirect:cliente";
    }
}