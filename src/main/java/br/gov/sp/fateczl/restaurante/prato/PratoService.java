package br.gov.sp.fateczl.restaurante.prato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PratoService
{
    @Autowired
    private PratoRepository repo;
    
    public Prato save(Prato prato)
    {
        return repo.save(prato);
    }
}
