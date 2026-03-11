package com.adjt.cheforderapi.core.exceptions;

public class LoginJaCadastradoException extends BaseException {
    public LoginJaCadastradoException(String login) {
        super("Login já cadastrado: " + login);
    }
}
