package com.adjt.chefmanagerapi.infrastructure.api.controller.pedido;

import com.adjt.chefmanagerapi.core.usecases.pedido.PedidoOutput;
import com.adjt.chefmanagerapi.model.PedidoResponse;

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
