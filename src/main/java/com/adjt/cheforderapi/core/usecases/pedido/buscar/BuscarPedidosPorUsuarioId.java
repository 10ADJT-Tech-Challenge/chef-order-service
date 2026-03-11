
package com.adjt.cheforderapi.core.usecases.pedido.buscar;

import com.adjt.cheforderapi.core.usecases.common.UseCase;
import com.adjt.cheforderapi.core.usecases.pedido.PedidoOutput;

import java.util.List;
import java.util.UUID;

public interface BuscarPedidosPorUsuarioId extends UseCase<UUID, List<PedidoOutput>> {
}