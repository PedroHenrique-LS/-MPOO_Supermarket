package com.laurindo.MPOO_Supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laurindo.MPOO_Supermarket.entity.Compra;
import com.laurindo.MPOO_Supermarket.entity.ItemCompra;

public interface ItemCompraRepository extends JpaRepository<ItemCompra, Long> {

}
