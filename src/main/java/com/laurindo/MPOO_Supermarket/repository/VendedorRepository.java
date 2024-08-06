package com.laurindo.MPOO_Supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laurindo.MPOO_Supermarket.entity.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, String> {

	Vendedor findByCodVendedor(Long codVendedor);
}
