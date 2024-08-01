package com.laurindo.MPOO_Supermarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laurindo.MPOO_Supermarket.entity.Compra;
import com.laurindo.MPOO_Supermarket.repository.CaixaRepository;

@Service
public class CaixaService  {
	
	@Autowired
	CaixaRepository caixaRepository;
	
	@Autowired
	CompraService compraService;
	
	@Autowired
	ProdutoService produtoService;
	
	public Compra registrarCompra(Compra compra) {
		if(compra == null)
			throw new RuntimeException("Compra inválida!");
		
		compra.getItens().stream().forEach((item)-> {
			var produto = produtoService.findProdutoById(item.getProduto().getCod());
			produto.setEmEstoque(produto.getEmEstoque() - item.getQuantidade());
			produtoService.updateProduto(produto.getCod(), produto);
		});
		
		return compraService.saveCompra(compra);
	}

}
