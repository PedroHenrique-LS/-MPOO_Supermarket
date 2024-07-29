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

import com.laurindo.MPOO_Supermarket.entity.Compra;
import com.laurindo.MPOO_Supermarket.entity.Gerente;
import com.laurindo.MPOO_Supermarket.entity.ItemCompra;
import com.laurindo.MPOO_Supermarket.service.GerenteService;

@RestController
@RequestMapping(value = "gerente")
public class GerenteResource {

	@Autowired
	GerenteService gerenteService;

	@PutMapping(value = "/{novoValor}")
	public ResponseEntity<Compra> darDesconto(@RequestBody Compra compra, @PathVariable double novoValor) {
		return ResponseEntity.status(HttpStatus.OK).body(gerenteService.darDesconto(compra, novoValor));
	}
	
	@PutMapping(value = "/{novoValor}/{compraId}")
	public ResponseEntity<ItemCompra> darDesconto(@RequestBody ItemCompra itemCompra, @PathVariable double novoValor, @PathVariable long compraId) {
		return ResponseEntity.status(HttpStatus.OK).body(gerenteService.darDesconto(compraId, itemCompra, novoValor));
	}

	@PostMapping
	public ResponseEntity<Gerente> saveGerente(@RequestBody Gerente gerente) {
		return ResponseEntity.status(HttpStatus.CREATED).body(gerenteService.saveGerente(gerente));
	}

	@GetMapping(value = "/{cpf}")
	public ResponseEntity<Gerente> findGerenteById(@PathVariable String cpf) {
		return ResponseEntity.status(HttpStatus.OK).body(gerenteService.findGerenteById(cpf));
	}

	@GetMapping
	public ResponseEntity<List<Gerente>> findAllGerente() {
		return ResponseEntity.status(HttpStatus.OK).body(gerenteService.findAllGerente());
		
	}

	@PutMapping()
	public ResponseEntity<Gerente> updateGerente(@RequestBody Gerente gerenteUpdated) {
		return ResponseEntity.status(HttpStatus.OK).body(gerenteService.updateGerente(gerenteUpdated.getCpf(), gerenteUpdated));
	}

	@DeleteMapping(value = "/{cpf}")
	public ResponseEntity<Void> deleteGerenteById(@PathVariable String cpf) {
		gerenteService.deleteGerenteById(cpf);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
