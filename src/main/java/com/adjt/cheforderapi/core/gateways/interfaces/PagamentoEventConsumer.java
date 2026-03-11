package com.adjt.cheforderapi.core.gateways.interfaces;

import com.adjt.cheforderapi.infrastructure.messaging.consumer.EventoPagamentoAprovadoMessageInput;
import com.adjt.cheforderapi.infrastructure.messaging.consumer.EventoPagamentoPendenteMessageInput;

public interface PagamentoEventConsumer {
    public void notificaPagamentoAprovado(EventoPagamentoAprovadoMessageInput input);
    public void notificaPagamentoPendente(EventoPagamentoPendenteMessageInput input);
}
