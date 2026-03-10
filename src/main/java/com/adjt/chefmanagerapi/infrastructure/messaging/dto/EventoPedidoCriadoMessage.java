package com.adjt.chefmanagerapi.infrastructure.messaging.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record EventoPedidoCriadoMessage(
    BigDecimal valor,
    UUID usuarioId,
    UUID pedidoId
) { }
