
package com.adjt.cheforderapi.infrastructure.dataprovider.pedido;

import com.adjt.cheforderapi.core.gateways.pedido.PedidoGatewayDto;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PedidoPersistenceMapper {

    private ItemPedidoPersistenceMapper itemPedidoPersistenceMapper;

    public PedidoPersistenceMapper(ItemPedidoPersistenceMapper itemPedidoPersistenceMapper) {
        this.itemPedidoPersistenceMapper = itemPedidoPersistenceMapper;
    }

    public PedidoEntity toEntity(PedidoGatewayDto dto) {
        PedidoEntity pedido = new PedidoEntity();
        pedido.setId(dto.id());
        pedido.setRestauranteId(dto.restauranteId());
        pedido.setUsuarioId(dto.usuarioId());
        pedido.setDataPedido(dto.dataPedido());
        pedido.setItens(dto.itens().stream()
                .map(itemDto -> itemPedidoPersistenceMapper.toEntity(itemDto, pedido))
                .collect(Collectors.toList()));
        pedido.setValorTotal(dto.valorTotal());
        pedido.setStatusPagamento(dto.statusPagamento());
        return pedido;
    }

    public PedidoGatewayDto toDto(PedidoEntity entity) {
        return new PedidoGatewayDto(
                entity.getId(),
                entity.getRestauranteId(),
                entity.getUsuarioId(),
                entity.getDataPedido(),
                entity.getItens().stream()
                        .map(itemPedidoPersistenceMapper::toDto)
                        .collect(Collectors.toList()),
                entity.getValorTotal(),
                entity.getStatusPagamento()
        );
    }
}
