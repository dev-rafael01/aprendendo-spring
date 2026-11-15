package io.github_rafael01.aprendendo_spring.infraEstrutura.repository;

import io.github_rafael01.aprendendo_spring.infraEstrutura.entity.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone,Long> {
}
