package com.laurindo.MPOO_Supermarket.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.laurindo.MPOO_Supermarket.entity.Caixa;
import com.laurindo.MPOO_Supermarket.entity.Categoria;
import com.laurindo.MPOO_Supermarket.entity.Gerente;
import com.laurindo.MPOO_Supermarket.entity.ItemCompra;
import com.laurindo.MPOO_Supermarket.entity.Produto;
import com.laurindo.MPOO_Supermarket.entity.Vendedor;
import com.laurindo.MPOO_Supermarket.repository.CaixaRepository;
import com.laurindo.MPOO_Supermarket.repository.CategoriaRepository;
import com.laurindo.MPOO_Supermarket.repository.CompraRepository;
import com.laurindo.MPOO_Supermarket.repository.GerenteRepository;
import com.laurindo.MPOO_Supermarket.repository.ItemCompraRepository;
import com.laurindo.MPOO_Supermarket.repository.ProdutoRepository;
import com.laurindo.MPOO_Supermarket.repository.VendedorRepository;
import com.laurindo.MPOO_Supermarket.service.CaixaService;

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
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	CaixaService caixaService;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		var gerente1 = new Gerente("99999999999", "Flávio");
		var vendedor1 = new Vendedor("22222222222", "João", 123L);
		var vendedor2 = new Vendedor("333333333333", "Carlos", 456L);
		var caixa1 = new Caixa("444.444.444-44", "Roberto");
		var compra1 = caixaService.criarCompra();
		var produto1 = new Produto(null, "TV", 1500.0, 40, "Smart TV", false);
		var produto2 = new Produto(null, "Iphoe", 2300.0, 10, "Iphone 15", false);
		var categoria1 = new Categoria(null, "Eletrônicos");
		var categoria2 = new Categoria(null, "TVs");
		var categoria3 = new Categoria(null, "Celulares");
		
		
		categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2, categoria3));
		gerenteRepository.save(gerente1);
		vendedorRepository.save(vendedor1);
		vendedorRepository.save(vendedor2);
		caixaRepository.save(caixa1);
		produto1.getCategorias().addAll(Arrays.asList(categoria1, categoria2));
		produto2.getCategorias().addAll(Arrays.asList(categoria1, categoria3));
		produtoRepository.saveAll(Arrays.asList(produto1, produto2));
		
		//var pagamento1 = new Pagamento(null, compra1);
		//compra1.setPagamento(pagamento1);
		//caixaService.registrarCompra(compra1);
		
		//var itemCompra1 = new ItemCompra(produto1, compra1, 3);
		//var itemCompra2 = new ItemCompra(produto2, compra1, 3);
		//compra1.getItens().addAll(Arrays.asList(itemCompra1, itemCompra2));
		//itemCompraRepository.saveAll(Arrays.asList(itemCompra1, itemCompra2));
		
//		caixaService.registrarCompra(compra1, 456L);
	
		//caixaService.registrarCompra(compra1, 456L);
		
		
		
	}

}
