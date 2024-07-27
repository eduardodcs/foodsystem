package com.fiap.soat.foodsystem.external.repositories;

import com.fiap.soat.foodsystem.external.models.ParametrosEntity;
import com.fiap.soat.foodsystem.external.models.ParametrosIdEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IParametrosRepository extends JpaRepository<ParametrosEntity, ParametrosIdEntity> {
}
