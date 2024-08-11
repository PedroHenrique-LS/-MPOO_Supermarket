package com.laurindo.MPOO_Supermarket.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_funcionario")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	public static final double SALARIO_MINIMO = 1412.0;
	@Id
	private String cpf;
	private String nome;
	private double slario;
	
	
	public Funcionario() {
		calcularSalario();
	}
	
	
	public Funcionario(String cpf, String nome) {
		this.cpf = cpf;
		this.nome = nome;
		calcularSalario();
	}

	public abstract void calcularSalario();

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public double getSlario() {
		calcularSalario();
		return slario;
	}
	public void setSlario(double slario) {
		this.slario = slario;
	}
	public static double getSalarioMinimo() {
		return SALARIO_MINIMO;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(cpf, other.cpf);
	}
	
	

}
