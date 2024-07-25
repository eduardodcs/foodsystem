package com.fiap.soat.repositories;

import com.fiap.soat.domain.enums.StatusPedido;
import com.fiap.soat.models.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPedidoRepository extends JpaRepository<PedidoEntity, Long> {

    List<PedidoEntity> findByStatusPedido(StatusPedido statusPedido);

}
