package com.adjt.cheforderapi.infrastructure.messaging.consumer;

import java.util.UUID;

public record EventoPagamentoPendenteMessageInput(UUID pagamentoId, UUID pedidoId) {
}
