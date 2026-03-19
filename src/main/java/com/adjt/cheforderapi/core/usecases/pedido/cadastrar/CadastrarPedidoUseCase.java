package com.adjt.cheforderapi.core.usecases.pedido.cadastrar;

import com.adjt.cheforderapi.core.domain.entities.pedido.ItemPedido;
import com.adjt.cheforderapi.core.domain.entities.pedido.Pedido;
import com.adjt.cheforderapi.core.gateways.interfaces.PedidoEventPublisher;
import com.adjt.cheforderapi.core.gateways.pedido.PedidoGateway;
import com.adjt.cheforderapi.core.usecases.pedido.PedidoMapper;
import com.adjt.cheforderapi.core.usecases.pedido.PedidoOutput;
import com.adjt.cheforderapi.infrastructure.dataprovider.pedido.StatusPagamentoEnum;
import com.adjt.cheforderapi.infrastructure.messaging.dto.EventoPedidoCriadoMapper;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CadastrarPedidoUseCase implements CadastrarPedido {

    private final PedidoGateway pedidoGateway;
    private final PedidoMapper pedidoMapper;
    private final PedidoEventPublisher eventPublisher;

    public CadastrarPedidoUseCase(PedidoGateway pedidoGateway, PedidoMapper pedidoMapper, PedidoEventPublisher eventPublisher) {
        this.pedidoGateway = pedidoGateway;
        this.pedidoMapper = pedidoMapper;
        this.eventPublisher = eventPublisher;
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
                itens,
                StatusPagamentoEnum.PENDENTE
        );
        var pedidoSalvo = pedidoGateway.salvar(pedido);

//        var eventoCriadoMessage = EventoPedidoCriadoMapper.toDto(pedidoSalvo);
  //      eventPublisher.publicarPedidoCriado(eventoCriadoMessage);

        return pedidoMapper.toOutput(pedidoSalvo);
    }
}
