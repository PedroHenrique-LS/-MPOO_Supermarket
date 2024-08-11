package com.laurindo.MPOO_Supermarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laurindo.MPOO_Supermarket.entity.Vendedor;
import com.laurindo.MPOO_Supermarket.repository.CaixaRepository;
import com.laurindo.MPOO_Supermarket.repository.VendedorRepository;

@Service
public class VendedorService  {
	
	@Autowired
	CaixaRepository caixaRepository;
	
	@Autowired
	VendedorRepository vendedorRepository;
	
	public Vendedor saveVendedor(Vendedor vendedor) {
		return vendedorRepository.save(vendedor);
	}
	
	public Vendedor findVendedorById(String cpf) {
		var vendedor = vendedorRepository.findById(cpf).orElseThrow(() -> new IllegalArgumentException("Vendedor de código: " + cpf + " não encontrado."));
		return vendedor;
	}
	
	public Vendedor findVendedorByCodVendedor(Long codVendedor) {
		var vendedor = vendedorRepository.findByCodVendedor(codVendedor);
		if (vendedor == null)
			throw new IllegalArgumentException("Vendedor de código: " + codVendedor + " não encontrado.");
		vendedor.calcularSalario();
		return vendedor;
	}
	
	public List<Vendedor> findAllVendedor() {
		return vendedorRepository.findAll();
	}
	
	public Vendedor updateVendedor(Long codVendedor, Vendedor vendedorUpdated) {
		var oldVendedor = findVendedorByCodVendedor(codVendedor);
		oldVendedor.setNome(vendedorUpdated.getNome());
		oldVendedor.setsomaValorVendas(vendedorUpdated.getsomaValorVendas());
		return vendedorRepository.save(oldVendedor);
	}
	
	
	public void deleteVendedorByCodVendedor(Long codVendedor) {
		var vendedor = findVendedorByCodVendedor(codVendedor);
		vendedorRepository.delete(vendedor);
	}

}
