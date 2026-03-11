package com.adjt.cheforderapi.core.gateways.interfaces;

import com.adjt.cheforderapi.core.gateways.pedido.PedidoGatewayDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PedidoRepositoryGateway {
    PedidoGatewayDto salvar(PedidoGatewayDto dto);
    Optional<PedidoGatewayDto> buscarPorId(UUID id);
    List<PedidoGatewayDto> buscarPorUsuario(UUID id);
    boolean existePorId(UUID id);
}
