package com.adjt.cheforderapi.infrastructure.dataprovider.pedido;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "itens_pedido")
@NoArgsConstructor
@Getter
@Setter
public class ItemPedidoEntity {

    @Id
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id", nullable = false)
    private PedidoEntity pedido;

    @Column(name = "item_cardapio_id", nullable = false)
    private UUID itemCardapioId;

    @Column(nullable = false)
    private String descricao;

    @Column(precision = 12, scale = 2, nullable = false)
    private BigDecimal preco;

    @Column(nullable = false)
    private int quantidade;
}
