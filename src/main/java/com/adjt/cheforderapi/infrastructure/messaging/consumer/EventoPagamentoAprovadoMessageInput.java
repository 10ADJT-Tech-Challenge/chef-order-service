package com.adjt.cheforderapi.infrastructure.messaging.consumer;

import java.util.UUID;

public record EventoPagamentoAprovadoMessageInput(UUID pagamentoId, UUID pedidoId) {
}
