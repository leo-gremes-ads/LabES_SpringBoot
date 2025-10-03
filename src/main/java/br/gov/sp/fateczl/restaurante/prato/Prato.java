package br.gov.sp.fateczl.restaurante.prato;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Prato
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "prato_id")
    private long id;
    private String nome;
    private float valor;
    private String categoria;

    public Prato(DadosCadastroPrato dados) 
    {
        this.nome = dados.nome();
        this.valor = dados.valor();
        this.categoria = dados.categoria();
    }

    public void atualizar(@Valid DadosAtualizaPrato dados) {
		if (dados.nome() != null) {
			this.nome = dados.nome();
			this.valor = dados.valor();
            this.categoria = dados.categoria();
		}
	}
}