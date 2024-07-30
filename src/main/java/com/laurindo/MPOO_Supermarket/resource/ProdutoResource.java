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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laurindo.MPOO_Supermarket.entity.Produto;
import com.laurindo.MPOO_Supermarket.service.ProdutoService;

@RestController
@RequestMapping(value = "produto")
public class ProdutoResource {
	
	@Autowired
	ProdutoService produtoService;
	
	@PostMapping
	public ResponseEntity<Produto> saveProduto(@RequestBody Produto produto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.saveProduto(produto));
	}
	
	@GetMapping(value = "/{cod}")
	public ResponseEntity<Produto> findProdutoById(@PathVariable UUID cod) {
		return ResponseEntity.status(HttpStatus.OK).body(produtoService.findProdutoById(cod));
	}
	
	@GetMapping()
	public ResponseEntity<List<Produto>> findAllProduto() {
		return ResponseEntity.status(HttpStatus.OK).body(produtoService.findAllProduto());
	}
	
	@PutMapping(value = "/{cod}")
	public ResponseEntity<Produto> updateProduto(@PathVariable UUID cod, @RequestBody Produto produtoUpdated) {
		return ResponseEntity.status(HttpStatus.OK).body(produtoService.updateProduto(cod, produtoUpdated));
	}
	
	@DeleteMapping(value = "/{cod}")
	public ResponseEntity<Void> deleteProdutoById(@PathVariable UUID cod) {
		produtoService.deleteProdutoById(cod);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
