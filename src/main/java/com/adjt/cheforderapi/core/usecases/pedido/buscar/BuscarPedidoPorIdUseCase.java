package com.adjt.cheforderapi.core.usecases.pedido.buscar;

import com.adjt.cheforderapi.core.domain.entities.pedido.Pedido;
import com.adjt.cheforderapi.core.gateways.pedido.PedidoGateway;
import com.adjt.cheforderapi.core.usecases.pedido.PedidoMapper;
import com.adjt.cheforderapi.core.usecases.pedido.PedidoOutput;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class BuscarPedidoPorIdUseCase implements BuscarPedidoPorId {

    private final PedidoGateway pedidoGateway;
    private final PedidoMapper pedidoMapper;

    public BuscarPedidoPorIdUseCase(PedidoGateway pedidoGateway, PedidoMapper pedidoMapper) {
        this.pedidoGateway = pedidoGateway;
        this.pedidoMapper = pedidoMapper;
    }

    @Override
    public PedidoOutput executar(UUID pedidoId) {
        Optional<Pedido> opt = pedidoGateway.buscarPorId(pedidoId);
        if (opt.isEmpty()) {
            throw new NoSuchElementException("Nenhum pedido encontrado com o id: " + pedidoId);
        }
        return pedidoMapper.toOutput(opt.get());
    }
}
