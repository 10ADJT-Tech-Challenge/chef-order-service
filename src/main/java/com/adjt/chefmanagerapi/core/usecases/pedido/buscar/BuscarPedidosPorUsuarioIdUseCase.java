package com.adjt.chefmanagerapi.core.usecases.pedido.buscar;

import com.adjt.chefmanagerapi.core.domain.entities.pedido.Pedido;
import com.adjt.chefmanagerapi.core.gateways.pedido.PedidoGateway;
import com.adjt.chefmanagerapi.core.usecases.pedido.PedidoMapper;
import com.adjt.chefmanagerapi.core.usecases.pedido.PedidoOutput;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BuscarPedidosPorUsuarioIdUseCase implements BuscarPedidosPorUsuarioId {

    private final PedidoGateway pedidoGateway;
    private final PedidoMapper pedidoMapper;

    public BuscarPedidosPorUsuarioIdUseCase(PedidoGateway pedidoGateway, PedidoMapper pedidoMapper) {
        this.pedidoGateway = pedidoGateway;
        this.pedidoMapper = pedidoMapper;
    }

    @Override
    public List<PedidoOutput> executar(UUID usuarioId) {
        List<Pedido> pedidos = pedidoGateway.buscarPorUsuario(usuarioId);
        return pedidos.stream()
                .map(pedidoMapper::toOutput)
                .collect(Collectors.toList());
    }
}
