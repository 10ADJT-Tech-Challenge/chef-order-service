package com.adjt.chefmanagerapi.infrastructure.messaging.consumer;

import com.adjt.chefmanagerapi.core.usecases.pedido.atualizar.AtualizarPedidoInput;
import com.adjt.chefmanagerapi.infrastructure.dataprovider.pedido.StatusPagamentoEnum;

public final class EventoPagamentoAprovadoMessageMapper {

    private EventoPagamentoAprovadoMessageMapper() {
    }

    public static AtualizarPedidoInput toInput(EventoPagamentoAprovadoMessageInput messageInput) {
        if (messageInput == null) return null;

        return new AtualizarPedidoInput(
                messageInput.pedidoId(),
                StatusPagamentoEnum.APROVADO
        );
    }
}
