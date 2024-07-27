package com.laurindo.MPOO_Supermarket.service;

import org.springframework.stereotype.Service;

import com.laurindo.MPOO_Supermarket.entity.Compra;
import com.laurindo.MPOO_Supermarket.entity.ItemCompra;

@Service
public class GerenteService {
	
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
	
}