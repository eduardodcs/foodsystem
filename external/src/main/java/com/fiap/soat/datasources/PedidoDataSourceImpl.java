package com.fiap.soat.datasources;

import com.fiap.soat.converters.PedidoConvert;
import com.fiap.soat.domain.entities.Pedido;
import com.fiap.soat.domain.enums.StatusPedido;
import com.fiap.soat.gateways.datasource.IPedidoDataSource;
import com.fiap.soat.models.PedidoEntity;
import com.fiap.soat.repositories.IPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PedidoDataSourceImpl implements IPedidoDataSource {

    @Autowired
    private IPedidoRepository pedidoRepository;
    @Autowired
    private PedidoConvert pedidoConvert;

    @Override
    public Pedido findById(Long id) {
        Optional<Pedido> optionalPedido = pedidoRepository.findById(id).stream()
                .map(pedidoEntity -> pedidoConvert.pedidoEntityToPedido(pedidoEntity)).findAny();
        return optionalPedido.orElse(null);
    }

    @Override
    public List<Pedido> findAll() {
        List<PedidoEntity> list = pedidoRepository.findAll();
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
        return save(pedido);
    }

    @Override
    public List<Pedido> findByStatus(StatusPedido status) {
        List<PedidoEntity> list = pedidoRepository.findByStatusPedido(status);
        return list.stream().map(pedidoEntity -> pedidoConvert.pedidoEntityToPedido(pedidoEntity)).toList();
    }
}
