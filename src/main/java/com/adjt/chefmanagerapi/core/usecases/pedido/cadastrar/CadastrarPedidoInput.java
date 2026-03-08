
package com.adjt.chefmanagerapi.core.usecases.pedido.cadastrar;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public record CadastrarPedidoInput(
        @NotNull UUID restauranteId,
        UUID usuarioId,
        @NotBlank List<CadastrarItemPedidoInput> itens
) {
}
