package com.adjt.cheforderapi.infrastructure.messaging.producer;

import com.adjt.cheforderapi.core.gateways.interfaces.PedidoEventPublisher;
import com.adjt.cheforderapi.infrastructure.messaging.dto.EventoPedidoCriadoMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class KafkaPedidoEventPublisher implements PedidoEventPublisher {

    @Autowired
    private KafkaTemplate<String, EventoPedidoCriadoMessage> kafkaTemplate;

    @Override
    public void publicarPedidoCriado(EventoPedidoCriadoMessage message) {
        kafkaTemplate.send("pedido.criado", message);
    }
}
