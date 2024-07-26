package com.laurindo.MPOO_Supermarket.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_vendedor")
public class Vendedor extends Funcionario {
	private static final long serialVersionUID = 1L;
	
	public static final double TAXA_COMISSAO = 0.05;
	private double somaValorVendas;

	@Column(unique = true)
	private Long codVendedor;
	
	public Vendedor() {
		super();
	}
	
	public Vendedor(String cpf, String nome, Long codVendedor) {
		super(cpf, nome);
		this.codVendedor = codVendedor;
	}
	
	public double getComissao() {
		return getsomaValorVendas() * TAXA_COMISSAO;
	}

	@Override
	public void calcularSalario() {
		setSlario(SALARIO_MINIMO + (somaValorVendas * TAXA_COMISSAO));
		
	}
	
	public double getsomaValorVendas() {
		return somaValorVendas;
	}
	public void setsomaValorVendas(double valorVenda) {
		this.somaValorVendas += valorVenda;
	}
	public Long getCodVendedor() {
		return codVendedor;
	}
	public void setCodVendedor(Long codVendedor) {
		this.codVendedor = codVendedor;
	}
	public static double getTaxaComissao() {
		return TAXA_COMISSAO;
	}
	@Override
	public int hashCode() {
		return Objects.hash(codVendedor);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendedor other = (Vendedor) obj;
		return Objects.equals(codVendedor, other.codVendedor);
	}	
	
}
