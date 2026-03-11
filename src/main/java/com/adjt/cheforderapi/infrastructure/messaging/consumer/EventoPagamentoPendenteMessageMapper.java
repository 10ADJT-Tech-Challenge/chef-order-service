package com.adjt.cheforderapi.infrastructure.messaging.consumer;

import com.adjt.cheforderapi.core.usecases.pedido.atualizar.AtualizarPedidoInput;
import com.adjt.cheforderapi.infrastructure.dataprovider.pedido.StatusPagamentoEnum;

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
