
package com.adjt.cheforderapi.infrastructure.dataprovider.pedido;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PedidoJPARepository extends JpaRepository<PedidoEntity, UUID> {
    List<PedidoEntity> findByUsuarioId(UUID usuarioId);
}
