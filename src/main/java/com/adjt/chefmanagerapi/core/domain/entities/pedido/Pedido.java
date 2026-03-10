package com.adjt.chefmanagerapi.core.domain.entities.pedido;

import com.adjt.chefmanagerapi.infrastructure.dataprovider.pedido.StatusPagamentoEnum;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
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
    private BigDecimal valorTotal;
    private StatusPagamentoEnum statusPagamento;

    public Pedido(UUID id, UUID restauranteId, UUID usuarioId, OffsetDateTime dataPedido,  List<ItemPedido> itens, StatusPagamentoEnum statusPagamento) {
        this.id = id;
        this.restauranteId = restauranteId;
        this.usuarioId = usuarioId;
        this.dataPedido = dataPedido;
        this.itens = itens;
        this.statusPagamento = statusPagamento;
        this.valorTotal = calcularValorTotal();
    }

    public Pedido(UUID restauranteId, UUID usuarioId, OffsetDateTime dataPedido, List<ItemPedido> itens, StatusPagamentoEnum statusPagamento) {
        this(UUID.randomUUID(), restauranteId, usuarioId, dataPedido, itens, statusPagamento);
    }

    private BigDecimal calcularValorTotal() {
        if (itens == null || itens.isEmpty()) {
            return BigDecimal.ZERO;
        }

        return itens.stream()
                .map(item -> item.getPreco().multiply(BigDecimal.valueOf(item.getQuantidade())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
