
package com.adjt.cheforderapi.infrastructure.config;

import com.adjt.cheforderapi.core.gateways.interfaces.PagamentoEventConsumer;
import com.adjt.cheforderapi.core.gateways.interfaces.PedidoEventPublisher;
import com.adjt.cheforderapi.core.gateways.interfaces.PedidoRepositoryGateway;
import com.adjt.cheforderapi.core.gateways.pedido.PedidoGateway;
import com.adjt.cheforderapi.core.gateways.pedido.PedidoGatewayImpl;
import com.adjt.cheforderapi.core.usecases.pedido.atualizar.AtualizarPedido;
import com.adjt.cheforderapi.infrastructure.messaging.consumer.KafkaPagamentoEventConsumer;
import com.adjt.cheforderapi.infrastructure.messaging.producer.KafkaPedidoEventPublisher;
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
