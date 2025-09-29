package br.gov.sp.fateczl.restaurante.cliente;

import jakarta.validation.constraints.NotBlank;

public record DadosAtualizaCliente
(
    @NotBlank
    Long id,
    @NotBlank
    String nome,
    @NotBlank
    String endereco
) {}
