package com.adjt.cheforderapi.core.exceptions;

public class SenhaObrigatoriaException extends BaseException {

    public static final String MSG_NOVA_SENHA_OBRIGATORIA = "Nova senha não pode ser nula";

    public SenhaObrigatoriaException() {
        super(MSG_NOVA_SENHA_OBRIGATORIA);
    }
}
