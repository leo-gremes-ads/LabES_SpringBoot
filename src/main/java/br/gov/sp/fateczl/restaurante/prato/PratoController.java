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
    private PratoRepository repo;

    @GetMapping("/cadastro")
    public String carregaCadastro(Long id, Model model)
    {
        if (id != null) {
            var prato = repo.getReferenceById(id);
            model.addAttribute("prato", prato);
        }
        return "prato/cadastro";
    }

    @GetMapping
    public String carregaListagem(Model model)
    {
        model.addAttribute("lista", repo.findAll());
        return "prato/listagem";
    }

    @PostMapping
	@Transactional
	public String cadastrar (@Valid DadosCadastroPrato dados) {
		repo.save(new Prato(dados));
		return "redirect:prato";
	}

    @PutMapping
	@Transactional
	public String atualizar (DadosAtualizaPrato dados) {
		var prato = repo.getReferenceById(dados.id());
		prato.atualizar(dados);
		return "redirect:prato";
	}

    @DeleteMapping
    @Transactional
    public String removePrato(Long id)
    {
        repo.deleteById(id);
        return "redirect:prato";
    }
}
