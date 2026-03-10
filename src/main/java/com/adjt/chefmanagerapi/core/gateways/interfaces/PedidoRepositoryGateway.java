package com.adjt.chefmanagerapi.core.gateways.interfaces;

import com.adjt.chefmanagerapi.core.gateways.pedido.PedidoGatewayDto;
import com.adjt.chefmanagerapi.infrastructure.dataprovider.pedido.StatusPagamentoEnum;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PedidoRepositoryGateway {
    PedidoGatewayDto salvar(PedidoGatewayDto dto);
    Optional<PedidoGatewayDto> buscarPorId(UUID id);
    List<PedidoGatewayDto> buscarPorUsuario(UUID id);
    boolean existePorId(UUID id);
}
