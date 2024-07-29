package com.laurindo.MPOO_Supermarket.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laurindo.MPOO_Supermarket.entity.ItemCompra;
import com.laurindo.MPOO_Supermarket.entity.pk.ItemCompraPK;
import com.laurindo.MPOO_Supermarket.repository.ItemCompraRepository;

@Service
public class ItemCompraService {
	
	@Autowired
	ItemCompraRepository itemCompraRepository ;
	
	@Autowired
	CompraService compraService;
	
	@Autowired
	ProdutoService produtoService;
	
	public ItemCompra saveItemCompra(ItemCompra itemCompra) {
		return itemCompraRepository.save(itemCompra);
	}
	
	public ItemCompra findItemCompraById(long compraId, UUID produtoId) {
		var compra = compraService.findCompraById(compraId);
		var produto = produtoService.findProdutoById(produtoId);
		var itemCompraPK = new ItemCompraPK();
		itemCompraPK.setCompra(compra);
		itemCompraPK.setProduto(produto);
		var itemCompra = itemCompraRepository.findById(itemCompraPK).orElseThrow(() -> new IllegalArgumentException("ItemCompra não encontrado."));
		return itemCompra;
	}
	
	public List<ItemCompra> findAllItemCompra() {
		return itemCompraRepository.findAll();
	}
	
	public ItemCompra updateItemCompra(long compraId, UUID produtoId, ItemCompra itemCompraUpdated) {
		var oldItemCompra = findItemCompraById(compraId, produtoId);
		oldItemCompra.setDesconto(itemCompraUpdated.getDesconto());
		oldItemCompra.setQuantidade(itemCompraUpdated.getQuantidade());
		return itemCompraRepository.save(oldItemCompra);
	}
	
	
	public void deleteItemCompraById(long compraId, UUID produtoId) {
		var itemCompra = findItemCompraById(compraId, produtoId);
		itemCompraRepository.delete(itemCompra);
	}
	
	
}
