
package com.adjt.cheforderapi.core.gateways.pedido;

import com.adjt.cheforderapi.core.domain.entities.pedido.Pedido;

import java.util.stream.Collectors;

public final class PedidoGatewayMapper {

    private PedidoGatewayMapper() { }

    public static PedidoGatewayDto toDto(Pedido pedido) {
        if (pedido == null) return null;

        return new PedidoGatewayDto(
                pedido.getId(),
                pedido.getRestauranteId(),
                pedido.getUsuarioId(),
                pedido.getDataPedido(),
                pedido.getItens().stream()
                        .map(ItemPedidoGatewayMapper::toDto)
                        .collect(Collectors.toList()),
                pedido.getValorTotal(),
                pedido.getStatusPagamento()
        );
    }

    public static Pedido toDomain(PedidoGatewayDto dto) {
        if (dto == null) return null;

        return new Pedido(
                dto.id(),
                dto.restauranteId(),
                dto.usuarioId(),
                dto.dataPedido(),
                dto.itens().stream()
                        .map(ItemPedidoGatewayMapper::toDomain)
                        .collect(Collectors.toList()),
                dto.statusPagamento()
        );
    }
}
