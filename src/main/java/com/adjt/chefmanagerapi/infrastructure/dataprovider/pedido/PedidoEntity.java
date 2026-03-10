package com.adjt.chefmanagerapi.infrastructure.dataprovider.pedido;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "pedido")
@NoArgsConstructor
@Getter
@Setter
public class PedidoEntity {

    @Id
    private UUID id;

    @Column(name = "restaurante_id", nullable = false)
    private UUID restauranteId;

    @Column(name = "usuario_id", nullable = false)
    private UUID usuarioId;

    private OffsetDateTime dataPedido;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<ItemPedidoEntity> itens;

    private BigDecimal valorTotal;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_pagamento")
    private StatusPagamentoEnum statusPagamento;
}
