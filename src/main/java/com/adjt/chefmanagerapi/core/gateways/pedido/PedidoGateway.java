
package com.adjt.chefmanagerapi.core.gateways.pedido;

import com.adjt.chefmanagerapi.core.domain.entities.pedido.Pedido;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PedidoGateway {
    Pedido salvar(Pedido pedido);
    Optional<Pedido> buscarPorId(UUID id);
    List<Pedido> buscarPorUsuario(UUID usuarioId);
    boolean existePorId(UUID id);
}
