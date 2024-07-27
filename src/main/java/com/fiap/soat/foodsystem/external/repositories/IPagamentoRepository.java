package com.fiap.soat.foodsystem.external.repositories;

import com.fiap.soat.foodsystem.external.models.PagamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPagamentoRepository extends JpaRepository<PagamentoEntity, Long> {

    PagamentoEntity findByPedidoId(Long pedidoId);
}
