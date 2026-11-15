package io.github_rafael01.aprendendo_spring.business;



import io.github_rafael01.aprendendo_spring.infraEstrutura.entity.Usuario;
import io.github_rafael01.aprendendo_spring.infraEstrutura.exceptions.ConflictException;
import io.github_rafael01.aprendendo_spring.infraEstrutura.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.RequestParam;

@Service
@RequiredArgsConstructor
public class UsuarioService {

   private final UsuarioRepository usuarioRepository;
   private final PasswordEncoder passwordEncoder;

   public Usuario salvarUsuario(Usuario usuario){
       try {
            emailExiste(usuario.getEmail());
            usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
           return usuarioRepository.save(usuario);

       }catch(ConflictException e ){
            throw new ConflictException("Email ja cadastrado " + e.getCause());
       }
   }

   public void emailExiste(String email){
       try {
           boolean existe = verificarEmailExistente(email);
           if(existe){
               throw new ConflictException("Email ja cadastrado " + email);
           }
       }catch (ConflictException e ){
           throw new ConflictException("Email ja cadastrado", e.getCause());
       }
   }

   public boolean verificarEmailExistente(String email){
       return usuarioRepository.existsByEmail(email);
   }

   public Usuario salvarUsuarioPorEmail(@RequestParam String email){
       return usuarioRepository.findByEmail(email).orElseThrow(
               () -> new RuntimeException("Email ja cadastrado " + email));
   }

   public void deleteUsuarioPorEmail(String email){
       usuarioRepository.deleteByEmail(email);
   }
}
