package com.laurindo.MPOO_Supermarket.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.laurindo.MPOO_Supermarket.entity.Caixa;
import com.laurindo.MPOO_Supermarket.entity.Gerente;
import com.laurindo.MPOO_Supermarket.entity.Vendedor;
import com.laurindo.MPOO_Supermarket.repository.CaixaRepository;
import com.laurindo.MPOO_Supermarket.repository.GerenteRepository;
import com.laurindo.MPOO_Supermarket.repository.VendedorRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

	@Autowired
	GerenteRepository gerenteRepository;
	
	@Autowired
	VendedorRepository vendedorRepository;
	
	@Autowired
	CaixaRepository caixaRepository;
	
	
	
	@Override
	public void run(String... args) throws Exception {
		
		var g1 = new Gerente("999.999.999-99", "Flavio");
		var v1 = new Vendedor("222.222.222-22", "João", 123L);
		var v2 = new Vendedor("3333.333.333-33", "Carlos", 456L);
		var c1 = new Caixa("444.444.444-44", "Roberto");
		
		gerenteRepository.save(g1);
		vendedorRepository.save(v1);
		vendedorRepository.save(v2);
		caixaRepository.save(c1);
		
	}

}
