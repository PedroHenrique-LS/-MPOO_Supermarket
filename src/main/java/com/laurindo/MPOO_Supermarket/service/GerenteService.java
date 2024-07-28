package com.laurindo.MPOO_Supermarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laurindo.MPOO_Supermarket.entity.Compra;
import com.laurindo.MPOO_Supermarket.entity.Gerente;
import com.laurindo.MPOO_Supermarket.entity.ItemCompra;
import com.laurindo.MPOO_Supermarket.repository.GerenteRepository;

@Service
public class GerenteService {
	
	@Autowired
	GerenteRepository gerenteRepository;
	
	public void darDesconto(ItemCompra item, double novoValor) {
		
		if(item == null)
			throw new IllegalArgumentException("O item passado não é válido.");
		
		var valorItem = item.getSubTotal() + item.getDesconto();
		
		if(novoValor < valorItem - valorItem * 0.10 )
			throw new IllegalArgumentException("Desconto não aprovado. Descontos não podem ultrapassar 10% do valor do item");
		
		item.setDesconto(valorItem - novoValor);
	}

	public void darDesconto(Compra compra, double novoValor) {
		
		if(compra == null)
			throw new IllegalArgumentException("A compra passada não é válida.");
		
		var valorCompra = compra.getTotal() + compra.getDesconto();
		
		if(valorCompra <= 100)
			throw new IllegalArgumentException("Desconto não aprovado. Descontos só estão liberados para compras com valor total acima de R$ 100,0");
		
		if(novoValor < valorCompra - valorCompra * 0.10 )
			throw new IllegalArgumentException("Desconto não aprovado. Descontos não podem ultrapassar 10% do valor compra");
		
		
		compra.setDesconto(valorCompra - novoValor);
		
		
	}
	
	
	public Gerente saveGerente(Gerente gerente) {
		return gerenteRepository.save(gerente);
	}
	
	public Gerente findGerenteById(String cpf) {
		var gerente = gerenteRepository.findById(cpf).orElseThrow(() -> new IllegalArgumentException("Gerente de cpf: " + cpf + " não encontrado."));
		return gerente;
	}
	
	public List<Gerente> findAllGerente() {
		return gerenteRepository.findAll();
	}
	
	public Gerente updateGerente(String cpf, Gerente gerenteUpdated) {
		var oldGerente = findGerenteById(cpf);
		oldGerente.setNome(gerenteUpdated.getNome());
		return gerenteRepository.save(oldGerente);
	}
	
	
	public void deleteGerenteById(String cpf) {
		var gerente = gerenteRepository.findById(cpf).orElseThrow(() -> new IllegalArgumentException("Gerente de cpf: " + cpf + " não encontrado."));
		gerenteRepository.delete(gerente);;
	}
	
	
}
