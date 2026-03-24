package com.adjt.cheforderapi.core.usecases.pedido.buscar;

import com.adjt.cheforderapi.core.domain.entities.pedido.Pedido;
import com.adjt.cheforderapi.core.exceptions.PedidoNaoEncontradoException;
import com.adjt.cheforderapi.core.gateways.pedido.PedidoGateway;
import com.adjt.cheforderapi.core.usecases.pedido.PedidoMapper;
import com.adjt.cheforderapi.core.usecases.pedido.PedidoOutput;
import com.adjt.cheforderapi.core.exceptions.PedidoNaoPertenceAoUsuarioException;
import org.springframework.stereotype.Service;

@Service
public class BuscarPedidoPorIdUseCase implements BuscarPedidoPorId {

    private final PedidoGateway pedidoGateway;
    private final PedidoMapper pedidoMapper;

    public BuscarPedidoPorIdUseCase(PedidoGateway pedidoGateway, PedidoMapper pedidoMapper) {
        this.pedidoGateway = pedidoGateway;
        this.pedidoMapper = pedidoMapper;
    }

    @Override
    public PedidoOutput executar(BuscarPedidoPorIdInput input) {
        Pedido opt = pedidoGateway.buscarPorId(input.getPedidoId()).orElseThrow(() -> new PedidoNaoEncontradoException());

        if (!opt.getUsuarioId().equals(input.getUsuarioId())) {
            throw new PedidoNaoPertenceAoUsuarioException();
        }
        return pedidoMapper.toOutput(opt);
    }
}
