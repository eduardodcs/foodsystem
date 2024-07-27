package com.fiap.soat.foodsystem.config;


import com.fiap.soat.foodsystem.core.business.interfaces.gateways.*;
import com.fiap.soat.foodsystem.core.business.interfaces.usecases.*;
import com.fiap.soat.foodsystem.core.business.usecases.*;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public ICategoriaUseCase categoriaUseCaseImpl(ICategoriaGateway categoriaGateway) {
        return new CategoriaUseCaseImpl(categoriaGateway);
    }

    @Bean
    public IProdutoUseCase produtoUseCaseImpl(IProdutoGateway produtoGateway, ICategoriaUseCase categoriaUseCase){
        return new ProdutoUseCaseImpl(produtoGateway, categoriaUseCase);
    }

    @Bean
    public IClienteUseCase clienteUseCaseImpl(IClienteGateway clienteGateway) {
        return new ClienteUseCaseImpl(clienteGateway);
    }

    @Bean
    public IPagamentoUseCase pagamentoUseCaseImpl(IPagamentoGateway pedidoGateway) {
        return new PagamentoUseCaseImpl(pedidoGateway);
    }

    @Bean
    public IPedidoUseCase pedidoUseCaseImpl(IPedidoGateway pedidoGateway, IPagamentoUseCase pagamentoUseCase) {
        return new PedidoUseCaseImpl(pedidoGateway, pagamentoUseCase);
    }

}
