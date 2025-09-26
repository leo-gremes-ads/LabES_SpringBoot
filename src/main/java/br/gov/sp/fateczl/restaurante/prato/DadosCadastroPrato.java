package br.gov.sp.fateczl.restaurante.prato;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroPrato
(
    @NotBlank
    String nome,
    float valor,
    int tempoPreparo
) {}
