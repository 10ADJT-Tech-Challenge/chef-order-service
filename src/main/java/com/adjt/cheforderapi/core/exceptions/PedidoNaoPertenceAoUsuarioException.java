package com.adjt.cheforderapi.core.exceptions;

public class PedidoNaoPertenceAoUsuarioException extends RuntimeException {

    public PedidoNaoPertenceAoUsuarioException() {
        super("O pedido não pertence ao usuário autenticado.");
    }
}