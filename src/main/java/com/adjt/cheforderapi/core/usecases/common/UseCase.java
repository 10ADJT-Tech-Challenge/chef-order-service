package com.adjt.cheforderapi.core.usecases.common;

public interface UseCase<I, O> {
    O executar(I input);
}
