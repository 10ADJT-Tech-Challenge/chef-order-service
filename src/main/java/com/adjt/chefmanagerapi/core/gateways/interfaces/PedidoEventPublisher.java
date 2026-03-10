package com.adjt.chefmanagerapi.core.gateways.interfaces;

import com.adjt.chefmanagerapi.infrastructure.messaging.dto.EventoPedidoCriadoMessage;

public interface PedidoEventPublisher {
    public void publicarPedidoCriado(EventoPedidoCriadoMessage message);
}
