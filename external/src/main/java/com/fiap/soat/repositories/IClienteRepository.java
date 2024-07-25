package com.fiap.soat.repositories;

import com.fiap.soat.models.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IClienteRepository extends JpaRepository<ClienteEntity, Long> {
    boolean existsByCpf(String cpf);
    boolean existsByEmail(String email);
    Optional<ClienteEntity> findByCpf(String cpf);
}
