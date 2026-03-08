
package com.adjt.chefmanagerapi.infrastructure.dataprovider.pedido;

import com.adjt.chefmanagerapi.core.gateways.interfaces.PedidoRepositoryGateway;
import com.adjt.chefmanagerapi.core.gateways.pedido.PedidoGatewayDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class PedidoJPARepositoryGateway implements PedidoRepositoryGateway {

    private final PedidoJPARepository repo;
    private final PedidoPersistenceMapper mapper;

    public PedidoJPARepositoryGateway(PedidoJPARepository repo,
                                      PedidoPersistenceMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public PedidoGatewayDto salvar(PedidoGatewayDto dto) {
        var entity = mapper.toEntity(dto);
        entity = repo.save(entity);
        return mapper.toDto(entity);
    }

    @Override
    public Optional<PedidoGatewayDto> buscarPorId(UUID id) {
        return repo.findById(id).map(mapper::toDto);
    }

    @Override
    public List<PedidoGatewayDto> buscarPorUsuario(UUID id) {
        return repo.findByUsuarioId(id).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public boolean existePorId(UUID id) {
        return repo.existsById(id);
    }
}
