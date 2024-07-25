package com.fiap.soat.foodsystem.external.repositories;


import com.fiap.soat.foodsystem.external.models.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriaRepository extends JpaRepository<CategoriaEntity, Long> {

}
