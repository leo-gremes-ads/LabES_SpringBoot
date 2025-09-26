package br.gov.sp.fateczl.restaurante.prato;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface PratoRepository extends JpaRepository<Prato, Long>
{

}