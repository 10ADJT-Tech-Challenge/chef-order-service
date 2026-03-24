package com.adjt.cheforderapi.core.usecases.pedido.buscar;

import java.util.UUID;

public class BuscarPedidoPorIdInput {
    private UUID pedidoId;
    private UUID usuarioId;

    public BuscarPedidoPorIdInput(UUID pedidoId, UUID usuarioId) {
        this.pedidoId = pedidoId;
        this.usuarioId = usuarioId;
    }

    public UUID getPedidoId() {
        return pedidoId;
    }

    public UUID getUsuarioId() {
        return usuarioId;
    }
}
