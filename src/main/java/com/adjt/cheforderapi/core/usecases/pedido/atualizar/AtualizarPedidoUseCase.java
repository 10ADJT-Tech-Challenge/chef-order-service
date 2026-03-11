package com.adjt.cheforderapi.core.usecases.pedido.atualizar;

import com.adjt.cheforderapi.core.domain.entities.pedido.Pedido;
import com.adjt.cheforderapi.core.gateways.pedido.PedidoGateway;
import com.adjt.cheforderapi.core.usecases.pedido.PedidoMapper;
import com.adjt.cheforderapi.core.usecases.pedido.PedidoOutput;
import org.springframework.stereotype.Service;

@Service
public class AtualizarPedidoUseCase implements AtualizarPedido {

    private final PedidoGateway pedidoGateway;
    private final PedidoMapper pedidoMapper;

    public AtualizarPedidoUseCase(PedidoGateway pedidoGateway, PedidoMapper pedidoMapper) {
        this.pedidoGateway = pedidoGateway;
        this.pedidoMapper = pedidoMapper;
    }

    @Override
    public PedidoOutput executar(AtualizarPedidoInput input) {
        Pedido pedido = pedidoGateway.buscarPorId(input.pedidoId()).orElseThrow();
        pedido.setStatusPagamento(input.statusPagamento());
        var pedidoSalvo = pedidoGateway.salvar(pedido);

        return pedidoMapper.toOutput(pedidoSalvo);
    }
}

