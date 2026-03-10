
package com.adjt.chefmanagerapi.infrastructure.config;

import com.adjt.chefmanagerapi.core.gateways.interfaces.PagamentoEventConsumer;
import com.adjt.chefmanagerapi.core.gateways.interfaces.PedidoEventPublisher;
import com.adjt.chefmanagerapi.core.gateways.interfaces.PedidoRepositoryGateway;
import com.adjt.chefmanagerapi.core.gateways.pedido.PedidoGateway;
import com.adjt.chefmanagerapi.core.gateways.pedido.PedidoGatewayImpl;
import com.adjt.chefmanagerapi.core.usecases.pedido.atualizar.AtualizarPedido;
import com.adjt.chefmanagerapi.infrastructure.messaging.consumer.KafkaPagamentoEventConsumer;
import com.adjt.chefmanagerapi.infrastructure.messaging.producer.KafkaPedidoEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewaysConfig {

    @Bean
    public PedidoGateway pedidoGateway(PedidoRepositoryGateway repo) {
        return new PedidoGatewayImpl(repo);
    }

    @Bean
    public PedidoEventPublisher pedidoEventPublisher() {
        return new KafkaPedidoEventPublisher();
    }

    @Bean
    public PagamentoEventConsumer pagamentoEventConsumer(AtualizarPedido atualizarPedido) {
        return new KafkaPagamentoEventConsumer(atualizarPedido);
    }
}
