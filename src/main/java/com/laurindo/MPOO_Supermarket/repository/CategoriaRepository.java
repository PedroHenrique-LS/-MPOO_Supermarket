package com.laurindo.MPOO_Supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laurindo.MPOO_Supermarket.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
