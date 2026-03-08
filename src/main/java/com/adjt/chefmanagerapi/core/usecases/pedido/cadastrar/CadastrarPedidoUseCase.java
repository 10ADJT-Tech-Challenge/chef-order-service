package com.adjt.chefmanagerapi.core.usecases.pedido.cadastrar;

import com.adjt.chefmanagerapi.core.domain.entities.pedido.ItemPedido;
import org.springframework.stereotype.Service;
import com.adjt.chefmanagerapi.core.domain.entities.pedido.Pedido;
import com.adjt.chefmanagerapi.core.gateways.pedido.PedidoGateway;
import com.adjt.chefmanagerapi.core.usecases.pedido.PedidoMapper;
import com.adjt.chefmanagerapi.core.usecases.pedido.PedidoOutput;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CadastrarPedidoUseCase implements CadastrarPedido {

    private final PedidoGateway pedidoGateway;
    private final PedidoMapper pedidoMapper;

    public CadastrarPedidoUseCase(PedidoGateway pedidoGateway, PedidoMapper pedidoMapper) {
        this.pedidoGateway = pedidoGateway;
        this.pedidoMapper = pedidoMapper;
    }

    @Override
    public PedidoOutput executar(CadastrarPedidoInput input) {
        UUID pedidoId = UUID.randomUUID();
        OffsetDateTime dataPedido = OffsetDateTime.now();

        List<ItemPedido> itens = input.itens().stream()
                .map(item -> new ItemPedido(pedidoId, item.itemCardapioId(), item.descricao(), item.preco(), item.quantidade()))
                .collect(Collectors.toList());

        Pedido pedido = new Pedido(
                pedidoId,
                input.restauranteId(),
                input.usuarioId(),
                dataPedido,
                itens
        );
        var salvo = pedidoGateway.salvar(pedido);
        return pedidoMapper.toOutput(salvo);
    }
}
