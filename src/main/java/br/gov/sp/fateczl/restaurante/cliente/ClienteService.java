package br.gov.sp.fateczl.restaurante.cliente;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import jakarta.validation.constraints.NotBlank;

@Service
public class ClienteService
{
    @Autowired
    private ClienteRepository repo;
    
    public Cliente salvar(Cliente cliente)
    {
        return repo.save(cliente);
    }

    public List<Cliente> procurarTodos()
    {
        return repo.findAll(Sort.by("id").ascending());
    }

    public void apagarPorId(Long id)
    {
        repo.deleteById(id);
    }

    public Cliente procurarPorId(@NotBlank Long id)
    {
        return repo.getReferenceById(id);
    }
}
