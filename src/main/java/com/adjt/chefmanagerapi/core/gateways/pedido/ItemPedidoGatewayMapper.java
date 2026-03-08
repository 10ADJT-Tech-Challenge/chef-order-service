package com.adjt.chefmanagerapi.core.gateways.pedido;

import com.adjt.chefmanagerapi.core.domain.entities.pedido.ItemPedido;

public final class ItemPedidoGatewayMapper {

    private ItemPedidoGatewayMapper() {}

    public static ItemPedidoGatewayDto toDto(ItemPedido item) {
        if (item == null) return null;
        return new ItemPedidoGatewayDto(
                item.getId(),
                item.getPedidoId(),
                item.getItemCardapioId(),
                item.getDescricao(),
                item.getPreco(),
                item.getQuantidade()
        );
    }

    public static ItemPedido toDomain(ItemPedidoGatewayDto dto) {
        if (dto == null) return null;
        return new ItemPedido(
                dto.id(),
                dto.pedidoId(),
                dto.itemCardapioId(),
                dto.descricao(),
                dto.preco(),
                dto.quantidade()
        );
    }
}
