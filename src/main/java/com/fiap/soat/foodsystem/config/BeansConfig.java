package com.fiap.soat.foodsystem.config;


import com.fiap.soat.foodsystem.core.business.interfaces.gateways.ICategoriaGateway;
import com.fiap.soat.foodsystem.core.business.interfaces.gateways.IClienteGateway;
import com.fiap.soat.foodsystem.core.business.interfaces.gateways.IPedidoGateway;
import com.fiap.soat.foodsystem.core.business.interfaces.gateways.IProdutoGateway;
import com.fiap.soat.foodsystem.core.business.interfaces.usecases.ICategoriaUseCase;
import com.fiap.soat.foodsystem.core.business.interfaces.usecases.IClienteUseCase;
import com.fiap.soat.foodsystem.core.business.interfaces.usecases.IPedidoUseCase;
import com.fiap.soat.foodsystem.core.business.interfaces.usecases.IProdutoUseCase;
import com.fiap.soat.foodsystem.core.business.usecases.CategoriaUseCaseImpl;
import com.fiap.soat.foodsystem.core.business.usecases.ClienteUseCaseImpl;
import com.fiap.soat.foodsystem.core.business.usecases.PedidoUseCaseImpl;
import com.fiap.soat.foodsystem.core.business.usecases.ProdutoUseCaseImpl;
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
    public IPedidoUseCase pedidoUseCaseImpl(IPedidoGateway pedidoGateway) {
        return new PedidoUseCaseImpl(pedidoGateway);
    }

}
