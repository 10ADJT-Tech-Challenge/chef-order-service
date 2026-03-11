package com.adjt.cheforderapi.core.domain.entities.pedido;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class ItemPedido {
    private UUID id;
    private UUID pedidoId;
    private UUID itemCardapioId;
    private String descricao;
    private BigDecimal preco;
    private Integer quantidade;

    public ItemPedido(UUID id, UUID pedidoId, UUID itemCardapioId, String descricao, BigDecimal preco, Integer quantidade) {
        this.id = id;
        this.pedidoId = pedidoId;
        this.itemCardapioId = itemCardapioId;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public ItemPedido(UUID pedidoId, UUID itemCardapioId, String descricao, BigDecimal preco, Integer quantidade) {
        this(UUID.randomUUID(), pedidoId, itemCardapioId, descricao, preco, quantidade);
    }
}
