package com.adjt.chefmanagerapi.infrastructure.api.controller.pedido;

import com.adjt.chefmanagerapi.PedidoApi;
import com.adjt.chefmanagerapi.core.usecases.pedido.PedidoOutput;
import com.adjt.chefmanagerapi.core.usecases.pedido.buscar.BuscarPedidoPorId;
import com.adjt.chefmanagerapi.core.usecases.pedido.buscar.BuscarPedidosPorUsuarioId;
import com.adjt.chefmanagerapi.core.usecases.pedido.cadastrar.CadastrarItemPedidoInput;
import com.adjt.chefmanagerapi.core.usecases.pedido.cadastrar.CadastrarPedido;
import com.adjt.chefmanagerapi.core.usecases.pedido.cadastrar.CadastrarPedidoInput;
import com.adjt.chefmanagerapi.model.PedidoRequest;
import com.adjt.chefmanagerapi.model.PedidoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class PedidoController implements PedidoApi {

    private final CadastrarPedido cadastrarPedido;
    private final BuscarPedidoPorId buscarPedidoPorId;
    private final BuscarPedidosPorUsuarioId buscarPedidosPorUsuarioId;

    public PedidoController(CadastrarPedido cadastrarPedido,
                            BuscarPedidoPorId buscarPedidoPorId,
                            BuscarPedidosPorUsuarioId buscarPedidosPorUsuarioId) {
        this.cadastrarPedido = cadastrarPedido;
        this.buscarPedidoPorId = buscarPedidoPorId;
        this.buscarPedidosPorUsuarioId = buscarPedidosPorUsuarioId;
    }

    @Override
    public ResponseEntity<PedidoResponse> buscarPedidoPorId(UUID id) {
        PedidoOutput pedido = buscarPedidoPorId.executar(id);
        return ResponseEntity.ok(PedidoApiMapper.toResponse(pedido));
    }

    @Override
    public ResponseEntity<List<PedidoResponse>> buscarPedidosPorUsuarioId() {
        List<PedidoOutput> outputs;

        var usuarioId = UUID.randomUUID();
        outputs = buscarPedidosPorUsuarioId.executar(usuarioId);

        var body = outputs.stream().map(PedidoApiMapper::toResponse).toList();
        if (body.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(body);
    }

    @Override
    public ResponseEntity<PedidoResponse> criarPedido(PedidoRequest pedidoRequest) {
        var itens = pedidoRequest.getItens().stream()
                .map(item -> new CadastrarItemPedidoInput(
                        item.getItemCardapioId(),
                        item.getDescricao(),
                        item.getPreco(),
                        item.getQuantidade()))
                .collect(Collectors.toList());
        UUID usuarioId = UUID.randomUUID();

        CadastrarPedidoInput input = new CadastrarPedidoInput(
                pedidoRequest.getRestauranteId(),
                usuarioId,
                itens
        );

        PedidoOutput pedidoOutput = cadastrarPedido.executar(input);
        return ResponseEntity.status(HttpStatus.CREATED).body(PedidoApiMapper.toResponse(pedidoOutput));
    }
}
