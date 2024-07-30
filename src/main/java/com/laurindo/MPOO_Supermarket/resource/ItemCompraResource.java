package com.laurindo.MPOO_Supermarket.resource;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laurindo.MPOO_Supermarket.entity.ItemCompra;
import com.laurindo.MPOO_Supermarket.service.ItemCompraService;

@RestController
@RequestMapping(value = "itemCompra")
public class ItemCompraResource {
	
	@Autowired 
	ItemCompraService itemCompraService;
	
	@PostMapping
	public ResponseEntity<ItemCompra> saveItemCompra(@RequestBody ItemCompra itemCompra) {
		return ResponseEntity.status(HttpStatus.CREATED).body(itemCompraService.saveItemCompra(itemCompra));
	}
	
	@GetMapping(value = "/{compraId}/{produtoId}")
	public ResponseEntity<ItemCompra> findItemCompraById(@PathVariable long compraId, UUID produtoId) {
		return ResponseEntity.status(HttpStatus.OK).body(itemCompraService.findItemCompraById(compraId, produtoId));
	}
	
	@GetMapping
	public ResponseEntity<List<ItemCompra>> findAllItemCompra() {
		return ResponseEntity.status(HttpStatus.OK).body(itemCompraService.findAllItemCompra());
	}
	
	
	@DeleteMapping(value = "/{compraId}/{produtoId}")
	public ResponseEntity<Void> deleteItemCompraById(@PathVariable long compraId, UUID produtoId) {
		itemCompraService.deleteItemCompraById(compraId, produtoId); 
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
