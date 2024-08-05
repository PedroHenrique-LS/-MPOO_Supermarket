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
		var vendedor = vendedorRepository.findById(cpf).orElseThrow(() -> new IllegalArgumentException("Produto de código: " + cpf + " não encontrado."));
		return vendedor;
	}
	
	public List<Vendedor> findAllVendedor() {
		return vendedorRepository.findAll();
	}
	
	public Vendedor updateVendedor(String cpf, Vendedor vendedorUpdated) {
		var oldVendedor = findVendedorById(cpf);
		oldVendedor.setNome(vendedorUpdated.getNome());
		oldVendedor.setsomaValorVendas(vendedorUpdated.getsomaValorVendas());
		return vendedorRepository.save(oldVendedor);
	}
	
	
	public void deleteVendedorById(String cpf) {
		var vendedor = findVendedorById(cpf);
		vendedorRepository.delete(vendedor);
	}

}
