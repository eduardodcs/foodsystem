package com.fiap.soat.foodsystem.external.datasources.jpql;

import com.fiap.soat.foodsystem.core.domain.enums.StatusPedido;
import com.fiap.soat.foodsystem.external.models.PedidoEntity;
import com.fiap.soat.foodsystem.external.models.PedidoProdutoEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PedidoJpql {

    @PersistenceContext
    private EntityManager manager;

    public List<PedidoEntity> consultaPedidoOrdenado() {
        String jpql="SELECT p FROM PedidoEntity p " +
                "where p.statusPedido in (:statusPronto, :statusEmPreparacao, :statusRebebido) " +
                "order by p.statusPedido desc, p.dataHoraCriacao asc";

        TypedQuery<PedidoEntity> queryPedido = manager.createQuery(jpql, PedidoEntity.class)
                .setParameter("statusPronto", StatusPedido.PRONTO)
                .setParameter("statusEmPreparacao",StatusPedido.EM_PREPARACAO)
                .setParameter("statusRebebido",StatusPedido.RECEBIDO);                ;
        List<PedidoEntity> resultList = queryPedido.getResultList();
        return resultList;
    }

    public void deletePedidoProdutoByPedidoId(Long pedidoId) {
        String jpql="DELETE FROM PedidoProdutoEntity p WHERE p.pedido_id = :idPedido";

        manager.createQuery(jpql)
                .setParameter("idPedido", pedidoId).executeUpdate();
    }

}
