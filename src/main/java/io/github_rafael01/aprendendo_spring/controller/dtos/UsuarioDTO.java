package io.github_rafael01.aprendendo_spring.controller.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private String email;
    private String senha;
}
