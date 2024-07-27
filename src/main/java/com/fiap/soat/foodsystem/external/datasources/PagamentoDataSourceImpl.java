package com.fiap.soat.foodsystem.external.datasources;

import com.fiap.soat.foodsystem.adapters.gateways.datasource.IPagamentoDataSource;
import com.fiap.soat.foodsystem.core.domain.entities.Pagamento;
import com.fiap.soat.foodsystem.external.converters.PagamentoConverter;
import com.fiap.soat.foodsystem.external.models.PagamentoEntity;
import com.fiap.soat.foodsystem.external.repositories.IPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PagamentoDataSourceImpl implements IPagamentoDataSource {

    @Autowired
    private PagamentoConverter pagamentoConverter;

    @Autowired
    private IPagamentoRepository PagamentoRepository;

    @Override
    public Pagamento save(Pagamento pagamento) {
        return null;
    }

    @Override
    public Pagamento findByPedidoId(Long pedidoId) {
        return null;
    }

    @Override
    public Pagamento update(Pagamento pagamento) {
        PagamentoEntity pagamentoEntity = pagamentoConverter.pagamentoToPagamentoEntity(pagamento);
        PagamentoEntity saved = PagamentoRepository.save(pagamentoEntity);
        return pagamentoConverter.pagamentoEntityToPagamento(saved);

    }
}
