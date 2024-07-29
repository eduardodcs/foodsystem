package com.fiap.soat.foodsystem.external.converters;


import com.fiap.soat.foodsystem.core.domain.entities.Categoria;
import com.fiap.soat.foodsystem.core.domain.entities.Pedido;
import com.fiap.soat.foodsystem.core.domain.entities.PedidoProduto;
import com.fiap.soat.foodsystem.core.domain.entities.Produto;
import com.fiap.soat.foodsystem.external.models.PedidoEntity;
import com.fiap.soat.foodsystem.external.models.PedidoProdutoEntity;
import com.fiap.soat.foodsystem.external.models.PedidoProdutoIdEntity;
import com.fiap.soat.foodsystem.external.models.ProdutoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PedidoProdutoConvert {


    @Autowired
    private ModelMapper modelMapper;

    public PedidoProdutoEntity pedidoProdutoToPedidoProdutoEntity(PedidoProduto pedidoProduto, PedidoEntity pedidoEntity) {
        PedidoProdutoEntity pedidoProdutoEntity = new PedidoProdutoEntity();
        pedidoProdutoEntity.setPedido(pedidoEntity);
        pedidoProdutoEntity.setProduto(modelMapper.map(pedidoProduto.getProduto(), ProdutoEntity.class));
        pedidoProdutoEntity.setQtdeProduto(pedidoProduto.getQtdeProduto());
        pedidoProdutoEntity.setSubTotal(pedidoProduto.getSubTotal());
        pedidoProdutoEntity.setPrecoUnitario(pedidoProduto.getPrecoUnitario());
        return pedidoProdutoEntity;
    }

    public PedidoProduto pedidoProdutoEntityToPedidoProduto(PedidoProdutoEntity pedidoProdutoEntity, Pedido pedido) {
        PedidoProduto pedidoProduto = new PedidoProduto();
        pedidoProduto.setProduto(this.modelMapper.map(pedidoProdutoEntity.getProduto(), Produto.class));
        pedidoProduto.getProduto().setCategoria(this.modelMapper.map(pedidoProdutoEntity.getProduto().getCategoria(), Categoria.class));
        pedidoProduto.setPedido(pedido);
        pedidoProduto.setSubTotal(pedidoProdutoEntity.getSubTotal());
        pedidoProduto.setQtdeProduto(pedidoProdutoEntity.getQtdeProduto());
        pedidoProduto.setPedido(pedido);
        pedidoProduto.setPrecoUnitario(pedidoProdutoEntity.getPrecoUnitario());
        return pedidoProduto;
    }



}
