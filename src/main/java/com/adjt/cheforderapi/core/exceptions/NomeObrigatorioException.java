package com.adjt.cheforderapi.core.exceptions;

public class NomeObrigatorioException extends BaseException {
    public static final String MSG_NOME_OBRIGATORIO = "Nome não pode ser nulo ou vazio";

    public NomeObrigatorioException() {
        super(MSG_NOME_OBRIGATORIO);
    }
}
