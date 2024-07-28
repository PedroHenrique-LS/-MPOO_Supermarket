package com.laurindo.MPOO_Supermarket.resource;

import java.util.List;

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

import com.laurindo.MPOO_Supermarket.entity.Compra;
import com.laurindo.MPOO_Supermarket.service.CompraService;

@RestController
@RequestMapping(value = "compra")
public class CompraResource {
	
	@Autowired 
	CompraService compraService;
	
	@PostMapping
	public ResponseEntity<Compra> saveCompra(@RequestBody Compra compra) {
		return ResponseEntity.status(HttpStatus.CREATED).body(compraService.saveCompra(compra));
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Compra> findCompraById(@PathVariable long id) {
		return ResponseEntity.status(HttpStatus.OK).body(compraService.findCompraById(id));
	}
	
	@GetMapping
	public ResponseEntity<List<Compra>> findAllCompra() {
		return ResponseEntity.status(HttpStatus.OK).body(compraService.findAllCompra());
	}
	
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteCompraById(@PathVariable long id) {
		compraService.deleteCompraById(id); 
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
