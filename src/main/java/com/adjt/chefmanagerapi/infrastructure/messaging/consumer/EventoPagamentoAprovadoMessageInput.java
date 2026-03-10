package com.adjt.chefmanagerapi.infrastructure.messaging.consumer;

import java.util.UUID;

public record EventoPagamentoAprovadoMessageInput(UUID pagamentoId, UUID pedidoId) {
}
