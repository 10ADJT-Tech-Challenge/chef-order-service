package com.adjt.cheforderapi.core.gateways.pedido;

import com.adjt.cheforderapi.core.domain.entities.pedido.Pedido;
import com.adjt.cheforderapi.core.gateways.interfaces.PedidoRepositoryGateway;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PedidoGatewayImpl implements PedidoGateway {

    private final PedidoRepositoryGateway pedidoRepositoryGateway;

    public PedidoGatewayImpl(PedidoRepositoryGateway pedidoRepositoryGateway) {
        this.pedidoRepositoryGateway = pedidoRepositoryGateway;
    }

    @Override
    public Pedido salvar(Pedido pedido) {
        var dto = PedidoGatewayMapper.toDto(pedido);
        var salvo = pedidoRepositoryGateway.salvar(dto);
        return PedidoGatewayMapper.toDomain(salvo);
    }

    @Override
    public Optional<Pedido> buscarPorId(UUID id) {
        return pedidoRepositoryGateway.buscarPorId(id).map(PedidoGatewayMapper::toDomain);
    }

    @Override
    public List<Pedido> buscarPorUsuario(UUID usuarioId) {
        return pedidoRepositoryGateway.buscarPorUsuario(usuarioId).stream()
                .map(PedidoGatewayMapper::toDomain)
                .toList();
    }

    @Override
    public boolean existePorId(UUID id) {
        return pedidoRepositoryGateway.existePorId(id);
    }
}
