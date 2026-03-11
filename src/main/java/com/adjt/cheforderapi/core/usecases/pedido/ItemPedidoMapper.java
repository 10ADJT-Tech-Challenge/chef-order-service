package com.adjt.cheforderapi.core.usecases.pedido;

import com.adjt.cheforderapi.core.domain.entities.pedido.ItemPedido;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemPedidoMapper {
    ItemPedidoOutput toOutput(ItemPedido itemPedido);
}
