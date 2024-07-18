package com.laurindo.MPOO_Supermarket.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_compra")
public class Compra implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double valorTotal;
	
	@OneToOne(mappedBy = "compra", cascade = CascadeType.ALL)
	private Pagamento pagamento;
	
	public Compra() {}
	
	public Compra(Long id, Double valorTotal) {
		this.id = id;
		this.valorTotal = valorTotal;
	}

	public Compra(Long id, Double valorTotal, Pagamento pagamento) {
		this.id = id;
		this.valorTotal = valorTotal;
		this.pagamento = pagamento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
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
