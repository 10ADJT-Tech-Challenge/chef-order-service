package com.adjt.chefmanagerapi.core.usecases.pedido;

import com.adjt.chefmanagerapi.core.domain.entities.pedido.ItemPedido;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemPedidoMapper {
    ItemPedidoOutput toOutput(ItemPedido itemPedido);
}
