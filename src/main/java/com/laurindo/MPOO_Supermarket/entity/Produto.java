package com.laurindo.MPOO_Supermarket.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_product")
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID cod;
	private String nome;
	private Double preco;
	private Integer emEstoque;
	private String descricao;
	private Boolean perecivel;
	
	@ManyToMany
	@JoinTable(name = "tb_produto_categoria", joinColumns = @JoinColumn(name = "produto_id"), inverseJoinColumns = @JoinColumn(name = "categoria_id"))
	private Set<Categoria> categorias = new HashSet<>();
	

	public Produto() {}
	
	public Produto(UUID cod, String nome, Double preco, Integer emEstoque, String descricao, Boolean perecivel) {
		this.cod = cod;
		this.nome = nome;
		this.preco = preco;
		this.emEstoque = emEstoque;
		this.descricao = descricao;
		this.perecivel = perecivel;
	}
	
	public Produto(UUID cod, String nome, Double preco, String descricao, Boolean perecivel) {
		this.cod = cod;
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		this.perecivel = perecivel;
	}

	public UUID getCod() {
		return cod;
	}

	public void setCod(UUID cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getEmEstoque() {
		return emEstoque;
	}

	public void setEmEstoque(Integer emEstoque) {
		this.emEstoque = emEstoque;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getPerecivel() {
		return perecivel;
	}

	public void setPerecivel(Boolean perecivel) {
		this.perecivel = perecivel;
	}
	
	public Set<Categoria> getCategorias() {
		return categorias;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cod);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(cod, other.cod);
	}
	
	

}
