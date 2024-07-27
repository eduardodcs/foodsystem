package com.fiap.soat.foodsystem.external.converters;

import com.fiap.soat.foodsystem.core.domain.entities.Pagamento;
import com.fiap.soat.foodsystem.external.models.PagamentoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PagamentoConverter {

    @Autowired
    private ModelMapper modelMapper;


    public Pagamento pagamentoEntityToPagamento(PagamentoEntity pagamentoEntity) {
        Pagamento pagamento = new Pagamento();
        pagamento.setId(pagamentoEntity.getId());
        pagamento.setIdentificador(pagamentoEntity.getIdentificador());
        pagamento.setTipoPagamento(pagamentoEntity.getTipoPagamento());
        pagamento.setStatusPagamento(pagamentoEntity.getStatusPagamento());
        pagamento.setInstituicao(pagamentoEntity.getInstituicao());
        pagamento.setQrcodeLink(pagamentoEntity.getQrcodeLink());
        pagamento.setQrcodeText(pagamentoEntity.getQrcodeText());
        pagamento.setDataHoraAtualizacao(pagamentoEntity.getDataHoraAtualizacao());
        return pagamento;
    }

    public PagamentoEntity pagamentoToPagamentoEntity(Pagamento pagamento) {
        return modelMapper.map(pagamento, PagamentoEntity.class);
    }
}
