package com.laurindo.MPOO_Supermarket.resource;

import java.util.List;

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

import com.laurindo.MPOO_Supermarket.entity.Vendedor;
import com.laurindo.MPOO_Supermarket.service.VendedorService;

@RestController
@RequestMapping(value = "vendedor")
public class VendedorResource  {
	
	
	@Autowired
	VendedorService vendedorService;
	
	@PostMapping
	public ResponseEntity<Vendedor> saveVendedor(@RequestBody Vendedor vendedor) {
		return ResponseEntity.status(HttpStatus.CREATED).body(vendedorService.saveVendedor(vendedor));
	}
	
	@GetMapping(value = "/{codVendedor}")
	public ResponseEntity<Vendedor> findVendedorByCodVendedor(@PathVariable Long codVendedor) {
		return ResponseEntity.status(HttpStatus.OK).body(vendedorService.findVendedorByCodVendedor(codVendedor));
	}
	
	@GetMapping
	public ResponseEntity<List<Vendedor>> findAllVendedor() {
		return ResponseEntity.status(HttpStatus.OK).body(vendedorService.findAllVendedor()) ;
	}
	
	@PutMapping(value = "/{codVendedor}")
	public ResponseEntity<Vendedor> updateVendedor(@PathVariable Long codVendedor, @RequestBody Vendedor vendedorUpdated) {
		return ResponseEntity.status(HttpStatus.OK).body(vendedorService.updateVendedor(codVendedor, vendedorUpdated));
	}
	
	@DeleteMapping(value = "/{codVendedor}")
	public ResponseEntity<Void> deleteVendedorById(@PathVariable Long codVendedor) {
		vendedorService.deleteVendedorByCodVendedor(codVendedor);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
