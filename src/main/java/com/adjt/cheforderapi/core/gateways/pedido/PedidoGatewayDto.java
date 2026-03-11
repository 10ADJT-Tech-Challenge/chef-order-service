package com.adjt.cheforderapi.core.gateways.pedido;

import com.adjt.cheforderapi.infrastructure.dataprovider.pedido.StatusPagamentoEnum;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

public record PedidoGatewayDto(
        UUID id,
        UUID restauranteId,
        UUID usuarioId,
        OffsetDateTime dataPedido,
        List<ItemPedidoGatewayDto>itens,
        BigDecimal valorTotal,
        StatusPagamentoEnum statusPagamento
) { }
