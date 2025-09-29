package br.gov.sp.fateczl.restaurante.pedido;

import br.gov.sp.fateczl.restaurante.cliente.Cliente;
import br.gov.sp.fateczl.restaurante.prato.Prato;
import jakarta.validation.constraints.NotBlank;

public record DadosAtualizaPedido
(
    @NotBlank
    Long id,
    @NotBlank
    Cliente cliente,
    @NotBlank
    Prato prato,
    int qtd
){
    
}
