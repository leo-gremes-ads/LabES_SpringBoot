package br.gov.sp.fateczl.restaurante.pedido;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface PedidoRepository extends JpaRepository<Pedido, Long>
{
    //corpo vazio
}
