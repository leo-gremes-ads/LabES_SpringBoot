package br.gov.sp.fateczl.restaurante.pedido;

import br.gov.sp.fateczl.restaurante.cliente.Cliente;
import br.gov.sp.fateczl.restaurante.prato.Prato;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of="id")
public class Pedido
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "pedido_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cliente_id", referencedColumnName="cliente_id")
    private Cliente cliente;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="prato_id", referencedColumnName="prato_id")
    private Prato prato;
    private int qtd;

    public Pedido(DadosCadastroPedido dados, Prato prato)
    {
        this.cliente = dados.cliente();
        this.prato = prato;
        this.qtd = dados.qtd();
    }

    public void atualizar(DadosAtualizaPedido dados)
    {
        this.cliente = dados.cliente();
        this.prato = dados.prato();
        this.qtd = dados.qtd();
    }
}