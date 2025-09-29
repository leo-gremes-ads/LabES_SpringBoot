package br.gov.sp.fateczl.restaurante.prato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/prato")
public class PratoController
{
    @Autowired
    private PratoService service;


    @GetMapping("/cadastro")
    public String carregaCadastro(Long id, Model model)
    {
        if (id != null) {
            var prato = service.procurarPorId(id);
            model.addAttribute("prato", prato);
        }
        return "prato/cadastro";
    }

    @GetMapping
    public String carregaListagem(Model model)
    {
        model.addAttribute("lista", service.procurarTodos());
        return "prato/listagem";
    }

    @PostMapping
	@Transactional
	public String cadastrar (@Valid DadosCadastroPrato dados) {
		service.salvar(new Prato(dados));
		return "redirect:prato";
	}

    @PutMapping
	@Transactional
	public String atualizar (DadosAtualizaPrato dados) {
		var prato = service.procurarPorId(dados.id());
		prato.atualizar(dados);
		return "redirect:prato";
	}

    @DeleteMapping
    @Transactional
    public String removePrato(Long id)
    {
        service.apagarPorId(id);
        return "redirect:prato";
    }
}
