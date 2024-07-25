package com.fiap.soat.foodsystem.external.repositories;



import com.fiap.soat.foodsystem.core.domain.enums.StatusPedido;
import com.fiap.soat.foodsystem.external.models.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPedidoRepository extends JpaRepository<PedidoEntity, Long> {

    List<PedidoEntity> findByStatusPedido(StatusPedido statusPedido);

}
