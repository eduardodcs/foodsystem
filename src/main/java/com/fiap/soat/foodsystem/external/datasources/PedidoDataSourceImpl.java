package com.fiap.soat.foodsystem.external.datasources;


import com.fiap.soat.foodsystem.adapters.gateways.datasource.IPedidoDataSource;
import com.fiap.soat.foodsystem.core.domain.entities.Pedido;
import com.fiap.soat.foodsystem.core.domain.enums.StatusPedido;
import com.fiap.soat.foodsystem.external.converters.PedidoConvert;
import com.fiap.soat.foodsystem.external.datasources.jpql.PedidoJpql;
import com.fiap.soat.foodsystem.external.models.PedidoEntity;
import com.fiap.soat.foodsystem.external.repositories.IPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PedidoDataSourceImpl implements IPedidoDataSource {

    @Autowired
    private IPedidoRepository pedidoRepository;
//    @Autowired
//    private IPedidoProdutoRepository pedidoProdutoRepository;
    @Autowired
    private PedidoConvert pedidoConvert;
    @Autowired
    private PedidoJpql pedidoJpql;

    @Override
    public Pedido findById(Long id) {
        Optional<Pedido> optionalPedido = pedidoRepository.findById(id).stream()
                .map(pedidoEntity -> pedidoConvert.pedidoEntityToPedido(pedidoEntity)).findAny();
        return optionalPedido.orElse(null);
    }

    @Override
    public List<Pedido> findAll() {
//        List<PedidoEntity> list = pedidoRepository.findAll();
        List<PedidoEntity> list = pedidoJpql.consultaPedidoOrdenado();
        return list.stream().map(pedidoEntity -> pedidoConvert.pedidoEntityToPedido(pedidoEntity)).toList();
    }

    @Override
    public Pedido save(Pedido pedido) {
        PedidoEntity pedidoEntity = pedidoConvert.pedidoToPedidoEntity(pedido);
        PedidoEntity saved = pedidoRepository.save(pedidoEntity);
        return pedidoConvert.pedidoEntityToPedido(saved);
    }

    @Override
    public void cancel(Pedido pedido) {
        save(pedido);
    }

    @Override
    public Pedido update(Pedido pedido) {
        PedidoEntity pedidoEntity = pedidoConvert.pedidoToPedidoEntity(pedido);
        PedidoEntity saved = pedidoRepository.save(pedidoEntity);
        return pedidoConvert.pedidoEntityToPedido(saved);
    }

    @Override
    public List<Pedido> findByStatus(StatusPedido status) {
        List<PedidoEntity> list = pedidoRepository.findByStatusPedido(status);
        return list.stream().map(pedidoEntity -> pedidoConvert.pedidoEntityToPedido(pedidoEntity)).toList();
    }

    @Override
    public void deletePedidoProdutoByPedidoId(Long pedidoId) {
        pedidoJpql.deletePedidoProdutoByPedidoId(pedidoId);
    }
}
