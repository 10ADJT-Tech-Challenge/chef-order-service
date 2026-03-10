package com.adjt.chefmanagerapi.infrastructure.messaging.consumer;

import com.adjt.chefmanagerapi.core.usecases.pedido.atualizar.AtualizarPedidoInput;
import com.adjt.chefmanagerapi.infrastructure.dataprovider.pedido.StatusPagamentoEnum;

public final class EventoPagamentoPendenteMessageMapper {

    private EventoPagamentoPendenteMessageMapper() {
    }

    public static AtualizarPedidoInput toInput(EventoPagamentoPendenteMessageInput messageInput) {
        if (messageInput == null) return null;

        return new AtualizarPedidoInput(
                messageInput.pedidoId(),
                StatusPagamentoEnum.PENDENTE
        );
    }
}
