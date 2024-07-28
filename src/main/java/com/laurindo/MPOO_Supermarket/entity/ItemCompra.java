package com.laurindo.MPOO_Supermarket.entity;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.laurindo.MPOO_Supermarket.entity.pk.ItemCompraPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_itemCompra")
public class ItemCompra implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ItemCompraPK id = new ItemCompraPK();
	private Integer quantidade;
	private Double preco;
	private double desconto;
	
	public ItemCompra() {}
	
	public ItemCompra(Produto produto, Compra compra, Integer quantidade, Double preco) {
		setProduto(produto);
		setCompra(compra);
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	
	
	public Produto getProduto() {
		return id.getProduto();
	}
	public void setProduto(Produto produto) {
		id.setProduto(produto);
	}
	
	@JsonIgnore
	public Compra getCompra() {
		return id.getCompra();
	}
	public void setCompra(Compra compra) {
		id.setCompra(compra);
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Double getSubTotal() {
		return quantidade * preco - desconto;
	}
	

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemCompra other = (ItemCompra) obj;
		return Objects.equals(id, other.id);
	}

	
	
	
	
	
	
	

}
