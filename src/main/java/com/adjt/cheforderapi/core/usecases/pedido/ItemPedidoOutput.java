package com.adjt.cheforderapi.core.usecases.pedido;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ItemPedidoOutput {
    private UUID id;
    private UUID itemCardapioId;
    private String descricao;
    private BigDecimal preco;
    private Integer quantidade;
    private BigDecimal valorTotal;
}
