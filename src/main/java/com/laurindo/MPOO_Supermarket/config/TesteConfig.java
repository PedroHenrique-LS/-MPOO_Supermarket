package com.laurindo.MPOO_Supermarket.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.laurindo.MPOO_Supermarket.entity.Caixa;
import com.laurindo.MPOO_Supermarket.entity.Compra;
import com.laurindo.MPOO_Supermarket.entity.Gerente;
import com.laurindo.MPOO_Supermarket.entity.ItemCompra;
import com.laurindo.MPOO_Supermarket.entity.Produto;
import com.laurindo.MPOO_Supermarket.entity.Vendedor;
import com.laurindo.MPOO_Supermarket.repository.CaixaRepository;
import com.laurindo.MPOO_Supermarket.repository.CompraRepository;
import com.laurindo.MPOO_Supermarket.repository.GerenteRepository;
import com.laurindo.MPOO_Supermarket.repository.ItemCompraRepository;
import com.laurindo.MPOO_Supermarket.repository.ProdutoRepository;
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
	
	@Autowired
	CompraRepository compraRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	ItemCompraRepository itemCompraRepository;
	
	
	
	@Override
	public void run(String... args) throws Exception {
		
		var gerente1 = new Gerente("999.999.999-99", "Flavio");
		var vendedor1 = new Vendedor("222.222.222-22", "João", 123L);
		var vendedor2 = new Vendedor("3333.333.333-33", "Carlos", 456L);
		var caixa1 = new Caixa("444.444.444-44", "Roberto");
		var compra1 = new Compra();
		var produto1 = new Produto(null, "TV", 1500.0, 40, "Smart TV", false);
		var produto2 = new Produto(null, "Iphoe", 2300.0, 10, "Iphone 15", false);
		var itemCompra1 = new ItemCompra(produto1, compra1, 3, produto1.getPreco());
		var itemCompra2 = new ItemCompra(produto2, compra1, 3, produto2.getPreco());
		
		compra1.getItens().add(itemCompra1);
		compra1.getItens().add(itemCompra2);
		
		gerenteRepository.save(gerente1);
		vendedorRepository.save(vendedor1);
		vendedorRepository.save(vendedor2);
		caixaRepository.save(caixa1);
		produtoRepository.saveAll(Arrays.asList(produto1, produto2));
		compraRepository.save(compra1);
		itemCompraRepository.saveAll(Arrays.asList(itemCompra1, itemCompra2));
		
		
		
	}

}
