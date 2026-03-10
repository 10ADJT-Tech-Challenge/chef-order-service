package com.adjt.chefmanagerapi.infrastructure.messaging.consumer;

import java.util.UUID;

public record EventoPagamentoPendenteMessageInput(UUID pagamentoId, UUID pedidoId) {
}
