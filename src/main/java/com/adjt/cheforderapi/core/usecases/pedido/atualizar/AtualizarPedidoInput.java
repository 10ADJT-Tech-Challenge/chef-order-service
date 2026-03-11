package com.adjt.cheforderapi.core.usecases.pedido.atualizar;

import com.adjt.cheforderapi.infrastructure.dataprovider.pedido.StatusPagamentoEnum;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record AtualizarPedidoInput(
        @NotBlank UUID pedidoId,
        @NotBlank StatusPagamentoEnum statusPagamento
        ) { }
