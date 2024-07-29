package com.laurindo.MPOO_Supermarket.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laurindo.MPOO_Supermarket.entity.Produto;
import com.laurindo.MPOO_Supermarket.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	public Produto saveProduto(Produto compra) {
		return produtoRepository.save(compra);
	}
	
	public Produto findProdutoById(UUID cod) {
		var compra = produtoRepository.findById(cod).orElseThrow(() -> new IllegalArgumentException("Produto de código: " + cod + " não encontrado."));
		return compra;
	}
	
	public List<Produto> findAllProduto() {
		return produtoRepository.findAll();
	}
	
	public Produto updateProduto(UUID cod, Produto produtoUpdated) {
		var oldProduto = findProdutoById(cod);
		oldProduto.setPerecivel(produtoUpdated.getPerecivel());
		oldProduto.setNome(produtoUpdated.getNome());
		oldProduto.setEmEstoque(produtoUpdated.getEmEstoque());
		oldProduto.setDescricao(produtoUpdated.getDescricao());
		return produtoRepository.save(oldProduto);
	}
	
	
	public void deleteProdutoById(UUID cod) {
		var compra = findProdutoById(cod);
		produtoRepository.delete(compra);;
	}

}
