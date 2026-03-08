package com.adjt.chefmanagerapi.infrastructure.api.controller.pedido;

import com.adjt.chefmanagerapi.core.usecases.pedido.ItemPedidoOutput;
import com.adjt.chefmanagerapi.model.ItemPedidoResponse;

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
