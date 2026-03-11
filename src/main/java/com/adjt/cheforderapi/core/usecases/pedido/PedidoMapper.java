package com.adjt.cheforderapi.core.usecases.pedido;

import com.adjt.cheforderapi.core.domain.entities.pedido.Pedido;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = ItemPedidoMapper.class)
public interface PedidoMapper {
    PedidoOutput toOutput(Pedido pedido);
}
