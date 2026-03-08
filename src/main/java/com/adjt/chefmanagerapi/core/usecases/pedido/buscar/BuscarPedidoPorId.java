
package com.adjt.chefmanagerapi.core.usecases.pedido.buscar;

import com.adjt.chefmanagerapi.core.usecases.common.UseCase;
import com.adjt.chefmanagerapi.core.usecases.pedido.PedidoOutput;

import java.util.UUID;

public interface BuscarPedidoPorId extends UseCase<UUID, PedidoOutput> {
}