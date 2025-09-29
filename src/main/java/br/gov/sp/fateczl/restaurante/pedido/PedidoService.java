package br.gov.sp.fateczl.restaurante.pedido;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import jakarta.validation.constraints.NotBlank;

@Service
public class PedidoService
{
    @Autowired
    private PedidoRepository repo;

    public Pedido salvar(Pedido pedido)
    {
        return repo.save(pedido);
    }

    public List<Pedido> procurarTodos()
    {
        return repo.findAll(Sort.by("id").ascending());
    }

    public void apagarPorId(Long id)
    {
        repo.deleteById(id);
    }

    public Pedido procurarPorId(@NotBlank Long id)
    {
        return repo.getReferenceById(id);
    }
}
