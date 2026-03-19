package com.adjt.cheforderapi.infrastructure.api.controller.pedido;

import com.adjt.cheforderapi.PedidoApi;
import com.adjt.cheforderapi.core.usecases.pedido.PedidoOutput;
import com.adjt.cheforderapi.core.usecases.pedido.buscar.BuscarPedidoPorId;
import com.adjt.cheforderapi.core.usecases.pedido.buscar.BuscarPedidosPorUsuarioId;
import com.adjt.cheforderapi.core.usecases.pedido.cadastrar.CadastrarItemPedidoInput;
import com.adjt.cheforderapi.core.usecases.pedido.cadastrar.CadastrarPedido;
import com.adjt.cheforderapi.core.usecases.pedido.cadastrar.CadastrarPedidoInput;
import com.adjt.cheforderapi.model.PedidoRequest;
import com.adjt.cheforderapi.model.PedidoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.oauth2.jwt.Jwt;


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

        Jwt jwt = (Jwt) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        UUID usuarioId = UUID.fromString(jwt.getSubject());
        outputs = buscarPedidosPorUsuarioId.executar(usuarioId);

        var body = outputs.stream().map(PedidoApiMapper::toResponse).toList();
        if (body.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(body);
    }

    @Override
    public ResponseEntity<PedidoResponse> criarPedido(PedidoRequest pedidoRequest) {

        Jwt jwt = (Jwt) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        UUID usuarioId = UUID.fromString(jwt.getSubject());

        var itens = pedidoRequest.getItens().stream()
                .map(item -> new CadastrarItemPedidoInput(
                        item.getItemCardapioId(),
                        item.getDescricao(),
                        item.getPreco(),
                        item.getQuantidade()))
                .collect(Collectors.toList());


        CadastrarPedidoInput input = new CadastrarPedidoInput(
                pedidoRequest.getRestauranteId(),
                usuarioId,
                itens
        );

        PedidoOutput pedidoOutput = cadastrarPedido.executar(input);
        return ResponseEntity.status(HttpStatus.CREATED).body(PedidoApiMapper.toResponse(pedidoOutput));
    }
}
