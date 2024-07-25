package com.fiap.soat.converters;

import com.fiap.soat.domain.entities.Categoria;
import com.fiap.soat.domain.entities.Pedido;
import com.fiap.soat.domain.entities.PedidoProduto;
import com.fiap.soat.domain.entities.Produto;
import com.fiap.soat.models.PedidoEntity;
import com.fiap.soat.models.PedidoProdutoEntity;
import com.fiap.soat.models.PedidoProdutoIdEntity;
import com.fiap.soat.models.ProdutoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PedidoProdutoConvert {


    @Autowired
    private ModelMapper modelMapper;

    public PedidoProdutoEntity pedidoProdutoToPedidoProdutoEntity(PedidoProduto pedidoProduto, PedidoEntity pedidoEntity) {
        PedidoProdutoEntity pedidoProdutoEntity = new PedidoProdutoEntity();
        pedidoProdutoEntity.setId(new PedidoProdutoIdEntity());
        pedidoProdutoEntity.getId().setPedido_id(pedidoEntity);
        pedidoProdutoEntity.getId().setProduto_id(modelMapper.map(pedidoProduto.getProduto(), ProdutoEntity.class));
        pedidoProdutoEntity.setPedido_id(pedidoEntity.getId());
        pedidoProdutoEntity.setProduto_id(pedidoProduto.getProduto().getId());
        pedidoProdutoEntity.setQtdeProduto(pedidoProduto.getQtdeProduto());
        pedidoProdutoEntity.setSubTotal(pedidoProduto.getSubTotal());
        pedidoProdutoEntity.setPrecoUnitario(pedidoProduto.getPrecoUnitario());
        return pedidoProdutoEntity;
    }

    public PedidoProduto pedidoProdutoEntityToPedidoProduto(PedidoProdutoEntity pedidoProdutoEntity, Pedido pedido) {
        PedidoProduto pedidoProduto = new PedidoProduto();
        pedidoProduto.setProduto(this.modelMapper.map(pedidoProdutoEntity.getId().getProduto_id(), Produto.class));
        pedidoProduto.getProduto().setCategoria(this.modelMapper.map(pedidoProdutoEntity.getId().getProduto_id().getCategoria(), Categoria.class));
        pedidoProduto.setPedido(pedido);
        pedidoProduto.setSubTotal(pedidoProdutoEntity.getSubTotal());
        pedidoProduto.setQtdeProduto(pedidoProdutoEntity.getQtdeProduto());
        pedidoProduto.setPedido(pedido);
        pedidoProduto.setPrecoUnitario(pedidoProdutoEntity.getPrecoUnitario());
        return pedidoProduto;
    }



}
