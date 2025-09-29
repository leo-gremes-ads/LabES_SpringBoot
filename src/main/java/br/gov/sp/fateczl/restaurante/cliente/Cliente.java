package br.gov.sp.fateczl.restaurante.cliente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Cliente
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="cliente_id")
    private Long id;
    private String nome;
    private String endereco;

    public Cliente(DadosCadastroCliente dados)
    {
        this.nome = dados.nome();
        this.endereco = dados.endereco();
    }

    public void atualizar(DadosAtualizaCliente dados)
    {
        this.nome = dados.nome();
        this.endereco = dados.endereco();
    }
}
