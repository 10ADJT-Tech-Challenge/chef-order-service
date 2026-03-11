package com.adjt.cheforderapi.core.exceptions;

public class EmailJaCadastradoException extends BaseException {
    public EmailJaCadastradoException(String email) {
        super("E-mail já cadastrado: " + email);
    }
}
