package com.adjt.chefmanagerapi.core.usecases.pedido;

import com.adjt.chefmanagerapi.core.domain.entities.pedido.Pedido;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = ItemPedidoMapper.class)
public interface PedidoMapper {
    PedidoOutput toOutput(Pedido pedido);
}
