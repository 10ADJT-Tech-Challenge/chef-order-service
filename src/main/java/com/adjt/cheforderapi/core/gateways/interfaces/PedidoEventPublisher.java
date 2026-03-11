package com.adjt.cheforderapi.core.gateways.interfaces;

import com.adjt.cheforderapi.infrastructure.messaging.dto.EventoPedidoCriadoMessage;

public interface PedidoEventPublisher {
    public void publicarPedidoCriado(EventoPedidoCriadoMessage message);
}
