package com.adjt.cheforderapi.infrastructure.api.controller.pedido;

import com.adjt.cheforderapi.core.usecases.pedido.PedidoOutput;
import com.adjt.cheforderapi.model.PedidoResponse;

import java.util.stream.Collectors;

public class PedidoApiMapper {

    public static PedidoResponse toResponse(PedidoOutput domain) {
        PedidoResponse dto = new PedidoResponse();
        dto.setId(domain.getId());
        dto.setRestauranteId(domain.getRestauranteId());
        dto.setDataPedido(domain.getDataPedido());
        dto.setItens(domain.getItens().stream()
                .map(ItemPedidoApiMapper::toResponse)
                .collect(Collectors.toList()));
        return dto;
    }
}
