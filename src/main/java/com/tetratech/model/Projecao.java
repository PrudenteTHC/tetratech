package com.tetratech.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Projecao {

	private Long populacao;
	
	private PeriodoMedio periodoMedio;

	public Projecao() {
	}

	public Long getPopulacao() {
		return populacao;
	}

	public void setPopulacao(Long populacao) {
		this.populacao = populacao;
	}

	public PeriodoMedio getPeriodoMedio() {
		return periodoMedio;
	}

	public void setPeriodoMedio(PeriodoMedio periodoMedio) {
		this.periodoMedio = periodoMedio;
	}
}