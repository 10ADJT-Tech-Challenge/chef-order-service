package com.adjt.chefmanagerapi.infrastructure.messaging.dto;

import com.adjt.chefmanagerapi.core.domain.entities.pedido.Pedido;

public final class EventoPedidoCriadoMapper {

    private EventoPedidoCriadoMapper() {}

    public static EventoPedidoCriadoMessage toDto(Pedido pedido) {
        if (pedido == null) return null;

        return new  EventoPedidoCriadoMessage(
                pedido.getValorTotal(),
                pedido.getUsuarioId(),
                pedido.getId()
        );
    }
}
