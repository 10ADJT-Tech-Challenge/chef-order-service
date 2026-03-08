package com.adjt.chefmanagerapi.core.gateways.pedido;

import java.math.BigDecimal;
import java.util.UUID;

public record ItemPedidoGatewayDto(
        UUID id,
        UUID pedidoId,
        UUID itemCardapioId,
        String descricao,
        BigDecimal preco,
        Integer quantidade
) { }
