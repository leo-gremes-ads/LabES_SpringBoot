package br.gov.sp.fateczl.restaurante.prato;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Prato
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String nome;
    private float valor;
    private int tempoPreparo;

    public Prato(DadosCadastroPrato dados) 
    {
        super();
        this.nome = dados.nome();
        this.valor = dados.valor();
        this.tempoPreparo = dados.tempoPreparo();
    }

    public void atualizar(@Valid DadosAtualizaPrato dados) {
		if (dados.nome() != null) {
			this.nome = dados.nome();
			this.valor = dados.valor();
            this.tempoPreparo = dados.tempoPreparo();
		}
	}
}