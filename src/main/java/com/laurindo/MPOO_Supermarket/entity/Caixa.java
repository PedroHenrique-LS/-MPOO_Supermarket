package com.laurindo.MPOO_Supermarket.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_caixa")
public class Caixa extends Funcionario {
	private static final long serialVersionUID = 1L;
	
	public Caixa() {
		super();
	}

	public Caixa(String cpf, String nome) {
		super(cpf, nome);
	}
	
	@Override
	public void calcularSalario() {
		setSlario(SALARIO_MINIMO);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
