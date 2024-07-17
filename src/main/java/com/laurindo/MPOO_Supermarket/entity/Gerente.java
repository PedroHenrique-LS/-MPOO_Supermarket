package com.laurindo.MPOO_Supermarket.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_gerente")
public class Gerente extends Funcionario {
	private static final long serialVersionUID = 1L;

	public Gerente() {
		super();
	}

	public Gerente(String cpf, String nome) {
		super(cpf, nome);
	}

	@Override
	public void calcularSalario() {
		setSlario(SALARIO_MINIMO * 5); 
	}

}
