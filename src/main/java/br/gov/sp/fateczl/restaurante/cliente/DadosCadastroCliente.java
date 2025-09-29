package br.gov.sp.fateczl.restaurante.cliente;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroCliente
(
    @NotBlank
    String nome,
    @NotBlank
    String endereco  
) {}
