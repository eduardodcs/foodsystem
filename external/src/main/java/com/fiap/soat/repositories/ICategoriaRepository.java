package com.fiap.soat.repositories;

import com.fiap.soat.models.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriaRepository extends JpaRepository<CategoriaEntity, Long> {

}
