package br.gov.sp.fateczl.restaurante.pedido;

import br.gov.sp.fateczl.restaurante.cliente.Cliente;
import br.gov.sp.fateczl.restaurante.prato.Prato;
//import jakarta.validation.constraints.NotBlank;

public record DadosCadastroPedido
(
    Cliente cliente,
    Prato prato,
    int qtd
) {}
