package io.github_rafael01.aprendendo_spring.infraEstrutura.exceptions;

public class ConflictException extends  RuntimeException {

    public ConflictException(String mensagem){
        super(mensagem);
    }

    public ConflictException(String mensagem, Throwable throwable){
        super(mensagem);
    }
}
