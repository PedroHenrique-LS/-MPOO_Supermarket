package com.laurindo.MPOO_Supermarket.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laurindo.MPOO_Supermarket.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {

}
