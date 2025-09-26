package br.gov.sp.fateczl.restaurante.prato;

import jakarta.validation.constraints.NotBlank;

public record DadosAtualizaPrato
(
    @NotBlank
    Long id,
    String nome,
    float valor,
    int tempoPreparo
) {}