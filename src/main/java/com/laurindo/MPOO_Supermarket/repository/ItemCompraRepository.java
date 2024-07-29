package com.laurindo.MPOO_Supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laurindo.MPOO_Supermarket.entity.ItemCompra;
import com.laurindo.MPOO_Supermarket.entity.pk.ItemCompraPK;

public interface ItemCompraRepository extends JpaRepository<ItemCompra, ItemCompraPK> {

}
