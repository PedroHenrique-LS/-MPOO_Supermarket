package com.laurindo.MPOO_Supermarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laurindo.MPOO_Supermarket.entity.Compra;
import com.laurindo.MPOO_Supermarket.repository.CompraRepository;

@Service
public class CompraService {
	
	@Autowired
	CompraRepository compraRepository;
	
	public Compra saveCompra(Compra compra) {
		return compraRepository.save(compra);
	}
	
	public Compra findCompraById(long id) {
		var compra = compraRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Compra de id: " + id + " não encontrada."));
		return compra;
	}
	
	public List<Compra> findAllCompra() {
		return compraRepository.findAll();
	}
	
	public Compra updateCompra(long id, Compra compraUpdated) {
		var oldCompra = findCompraById(id);
		oldCompra.setDesconto(compraUpdated.getDesconto());
		return compraRepository.save(oldCompra);
	}
	
	
	public void deleteCompraById(long id) {
		var compra = findCompraById(id);
		compraRepository.delete(compra);;
	}

}
