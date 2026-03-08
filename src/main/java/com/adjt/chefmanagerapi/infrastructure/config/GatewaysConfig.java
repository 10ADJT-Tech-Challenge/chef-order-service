
package com.adjt.chefmanagerapi.infrastructure.config;

import com.adjt.chefmanagerapi.core.gateways.interfaces.PedidoRepositoryGateway;
import com.adjt.chefmanagerapi.core.gateways.pedido.PedidoGateway;
import com.adjt.chefmanagerapi.core.gateways.pedido.PedidoGatewayImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewaysConfig {

    @Bean
    public PedidoGateway pedidoGateway(PedidoRepositoryGateway repo) {
        return new PedidoGatewayImpl(repo);
    }
}
