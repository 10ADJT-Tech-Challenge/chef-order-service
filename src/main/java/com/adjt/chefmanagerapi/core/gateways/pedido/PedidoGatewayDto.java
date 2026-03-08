package com.adjt.chefmanagerapi.core.gateways.pedido;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

public record PedidoGatewayDto(
        UUID id,
        UUID restauranteId,
        UUID usuarioId,
        OffsetDateTime dataPedido,
        List<ItemPedidoGatewayDto>itens
) { }
