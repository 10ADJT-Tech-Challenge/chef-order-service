
package com.adjt.cheforderapi.infrastructure.dataprovider.pedido;

import com.adjt.cheforderapi.core.gateways.pedido.ItemPedidoGatewayDto;
import org.springframework.stereotype.Component;

@Component
public class ItemPedidoPersistenceMapper {

    public ItemPedidoEntity toEntity(ItemPedidoGatewayDto dto, PedidoEntity pedido) {
        ItemPedidoEntity entity = new ItemPedidoEntity();
        entity.setId(dto.id());
        entity.setPedido(pedido);
        entity.setItemCardapioId(dto.itemCardapioId());
        entity.setDescricao(dto.descricao());
        entity.setPreco(dto.preco());
        entity.setQuantidade(dto.quantidade());
        return entity;
    }

    public ItemPedidoGatewayDto toDto(ItemPedidoEntity entity) {
        return new ItemPedidoGatewayDto(
                entity.getId(),
                entity.getPedido().getId(),
                entity.getItemCardapioId(),
                entity.getDescricao(),
                entity.getPreco(),
                entity.getQuantidade()
        );
    }
}
