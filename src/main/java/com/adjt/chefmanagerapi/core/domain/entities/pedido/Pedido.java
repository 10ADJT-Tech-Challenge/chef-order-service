package com.adjt.chefmanagerapi.core.domain.entities.pedido;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Pedido {
    private final UUID id;
    private UUID restauranteId;
    private UUID usuarioId;
    private OffsetDateTime dataPedido;
    private List<ItemPedido> itens;

    public Pedido(UUID id, UUID restauranteId, UUID usuarioId, OffsetDateTime dataPedido,  List<ItemPedido> itens) {
        this.id = id;
        this.restauranteId = restauranteId;
        this.usuarioId = usuarioId;
        this.dataPedido = dataPedido;
        this.itens = itens;
    }

    public Pedido(UUID restauranteId, UUID usuarioId, OffsetDateTime dataPedido, List<ItemPedido> itens) {
        this(UUID.randomUUID(), restauranteId, usuarioId, dataPedido, itens);
    }
}
