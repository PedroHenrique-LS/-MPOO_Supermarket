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

import com.laurindo.MPOO_Supermarket.entity.Caixa;
import com.laurindo.MPOO_Supermarket.entity.Compra;
import com.laurindo.MPOO_Supermarket.service.CaixaService;

@RestController
@RequestMapping(value = "caixa")
public class CaixaResource  {
	
	@Autowired
	CaixaService caixaService;
	
	@PostMapping(value = "/registrar-compra")
	public ResponseEntity<Compra> registrarCompra(@RequestBody Compra compra) {
		return ResponseEntity.status(HttpStatus.CREATED).body(caixaService.registrarCompra(compra));
	}
	
	@PostMapping(value = "/registrar-compra/{codVendedor}")
	public ResponseEntity<Compra> registrarCompra(@RequestBody Compra compra, @PathVariable Long codVendedor) {
		return ResponseEntity.status(HttpStatus.CREATED).body(caixaService.registrarCompra(compra, codVendedor));
	}
	
	@PostMapping
	public ResponseEntity<Caixa> saveCaixa(@RequestBody Caixa caixa) {
		return ResponseEntity.status(HttpStatus.CREATED).body(caixaService.saveCaixa(caixa));
	}
	
	@GetMapping(value = "/{cpf}")
	public ResponseEntity<Caixa> findCaixaById(@PathVariable String cpf) {
		return ResponseEntity.status(HttpStatus.OK).body(caixaService.findCaixaById(cpf));
	}
	
	@GetMapping
	public ResponseEntity<List<Caixa>> findAllCaixa() {
		return ResponseEntity.status(HttpStatus.OK).body(caixaService.findAllCaixa());
	}
	
	@PutMapping(value = "/{cpf}")
	public ResponseEntity<Caixa> updateCaixa(@PathVariable String cpf, @RequestBody Caixa caixaUpdated) {
		return ResponseEntity.status(HttpStatus.OK).body(caixaService.updateCaixa(cpf, caixaUpdated));
	}
	
	@DeleteMapping(value = "/{cpf}")
	public ResponseEntity<Void> deleteCaixaById(@PathVariable String cpf) {
		caixaService.deleteCaixaById(cpf);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
