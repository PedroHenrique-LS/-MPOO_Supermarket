package com.laurindo.MPOO_Supermarket.entity;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_compra")
public class Compra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private double desconto;
	private Instant momento;

	@OneToMany(mappedBy = "id.compra", cascade = CascadeType.ALL)
	private Set<ItemCompra> itens = new HashSet<>();

	@OneToOne(mappedBy = "compra", cascade = CascadeType.ALL)
	private Pagamento pagamento;

	public Compra() {
		this.momento = Instant.now();
	}

	public Compra(Long id, Pagamento pagamento) {
		this.id = id;
		this.momento = Instant.now();
		this.pagamento = pagamento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public Instant getMomento() {
		return momento;
	}

	public void setMomento(Instant momento) {
		this.momento = momento;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Set<ItemCompra> getItens() {
		return itens;
	}

	public Double getTotal() {
		var soma = 0.0;
		for (ItemCompra item : itens) {
			soma += item.getSubTotal();
			desconto += item.getDesconto();
		}
		
		return soma - desconto;
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
		Compra other = (Compra) obj;
		return Objects.equals(id, other.id);
	}

}
