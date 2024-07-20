package com.laurindo.MPOO_Supermarket.entity.pk;

import java.io.Serializable;
import java.util.Objects;

import com.laurindo.MPOO_Supermarket.entity.Compra;
import com.laurindo.MPOO_Supermarket.entity.Produto;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ItemCompraPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "compra_id")
	private Compra compra;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	@Override
	public int hashCode() {
		return Objects.hash(compra, produto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemCompraPK other = (ItemCompraPK) obj;
		return Objects.equals(compra, other.compra) && Objects.equals(produto, other.produto);
	}
	
	

}
