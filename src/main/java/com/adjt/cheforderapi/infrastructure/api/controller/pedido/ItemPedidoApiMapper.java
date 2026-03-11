package com.adjt.cheforderapi.infrastructure.api.controller.pedido;

import com.adjt.cheforderapi.core.usecases.pedido.ItemPedidoOutput;
import com.adjt.cheforderapi.model.ItemPedidoResponse;

public class ItemPedidoApiMapper {

    public static ItemPedidoResponse toResponse(ItemPedidoOutput domain) {
        ItemPedidoResponse dto = new ItemPedidoResponse();
        dto.setId(domain.getId());
        dto.setDescricao(domain.getDescricao());
        dto.setPreco(domain.getPreco());
        dto.setQuantidade(domain.getQuantidade());
        return dto;
    }
}
