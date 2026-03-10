package com.adjt.chefmanagerapi.core.gateways.interfaces;

import com.adjt.chefmanagerapi.infrastructure.messaging.consumer.EventoPagamentoAprovadoMessageInput;
import com.adjt.chefmanagerapi.infrastructure.messaging.consumer.EventoPagamentoPendenteMessageInput;

public interface PagamentoEventConsumer {
    public void notificaPagamentoAprovado(EventoPagamentoAprovadoMessageInput input);
    public void notificaPagamentoPendente(EventoPagamentoPendenteMessageInput input);
}
