package com.adjt.chefmanagerapi.core.usecases.pedido;

import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class PedidoOutput {
    private UUID id;
    private UUID restauranteId;
    private OffsetDateTime dataPedido;
    private List<ItemPedidoOutput> itens;
}
