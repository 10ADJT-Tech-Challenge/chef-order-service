package com.adjt.chefmanagerapi.infrastructure.messaging.producer;

import com.adjt.chefmanagerapi.core.gateways.interfaces.PedidoEventPublisher;
import com.adjt.chefmanagerapi.infrastructure.messaging.dto.EventoPedidoCriadoMessage;
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
