package com.tetratech.restservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PeriodoMedio {

	private Integer incrementoPopulacional;

	private Integer nascimento;

	private Integer obito;

	public PeriodoMedio() {
	}

	public Integer getIncrementoPopulacional() {
		return incrementoPopulacional;
	}

	public void setIncrementoPopulacional(Integer incrementoPopulacional) {
		this.incrementoPopulacional = incrementoPopulacional;
	}

	public Integer getNascimento() {
		return nascimento;
	}

	public void setNascimento(Integer nascimento) {
		this.nascimento = nascimento;
	}

	public Integer getObito() {
		return obito;
	}

	public void setObito(Integer obito) {
		this.obito = obito;
	}
}