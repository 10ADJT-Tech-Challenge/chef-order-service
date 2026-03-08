package com.adjt.chefmanagerapi.core.usecases.pedido.cadastrar;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.util.UUID;

public record CadastrarItemPedidoInput(
    @NotBlank UUID itemCardapioId,
    @NotBlank String descricao,
    @NotBlank BigDecimal preco,
    @NotBlank int quantidade
) { }
