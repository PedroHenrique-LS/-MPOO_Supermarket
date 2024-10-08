package com.laurindo.MPOO_Supermarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laurindo.MPOO_Supermarket.entity.Caixa;
import com.laurindo.MPOO_Supermarket.entity.Compra;
import com.laurindo.MPOO_Supermarket.entity.ItemCompra;
import com.laurindo.MPOO_Supermarket.repository.CaixaRepository;

@Service
public class CaixaService {

	@Autowired
	CaixaRepository caixaRepository;

	@Autowired
	CompraService compraService;

	@Autowired
	ProdutoService produtoService;

	@Autowired
	VendedorService vendedorService;

	@Autowired
	ItemCompraService itemCompraService;

	

	public Compra criarCompra() {
		
		var compra = new Compra();

		Compra compraSalva = compraService.saveCompra(compra);
		
		return compraSalva;
	}

	public Compra registrarCompra(Compra compra) {
		if (compra == null)
			throw new RuntimeException("Compra inválida!");

		var compra02 = compraService.findCompraById(compra.getId());
		
		compra.getItens().stream().forEach((item) -> {
			var produto = produtoService.findProdutoById(item.getProduto().getCod());
			produto.setEmEstoque(produto.getEmEstoque() - item.getQuantidade());
			item.setCompra(compra02);
			produtoService.updateProduto(produto.getCod(), produto);
			compra02.getItens().add(item);
		});

		return compraService.saveCompra(compra02);
	}

	public Compra registrarCompra(Compra compra, Long codVendedor) {
		if (compra == null)
			throw new RuntimeException("Compra inválida!");
		
		var compra02 = compraService.findCompraById(compra.getId());

		var vendedor = vendedorService.findVendedorByCodVendedor(codVendedor);

		compra.getItens().stream().forEach((item) -> {
			var produto = produtoService.findProdutoById(item.getProduto().getCod());
			produto.setEmEstoque(produto.getEmEstoque() - item.getQuantidade());
			item.setCompra(compra02);
			produtoService.updateProduto(produto.getCod(), produto);
			compra02.getItens().add(item);
		});

		vendedor.setsomaValorVendas(compra02.getTotal());
		vendedorService.saveVendedor(vendedor);

		return compraService.saveCompra(compra02);
	}

	public Caixa saveCaixa(Caixa caixa) {
		return caixaRepository.save(caixa);
	}

	public Caixa findCaixaById(String cpf) {
		var caixa = caixaRepository.findById(cpf)
				.orElseThrow(() -> new IllegalArgumentException("Produto de código: " + cpf + " não encontrado."));
		return caixa;
	}

	public List<Caixa> findAllCaixa() {
		return caixaRepository.findAll();
	}

	public Caixa updateCaixa(String cpf, Caixa caixaUpdated) {
		var oldCaixa = findCaixaById(cpf);
		oldCaixa.setNome(caixaUpdated.getNome());
		return caixaRepository.save(oldCaixa);
	}

	public void deleteCaixaById(String cpf) {
		var caixa = findCaixaById(cpf);
		caixaRepository.delete(caixa);
	}

}
