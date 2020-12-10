package com.tetratech.restservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Populacao {

	private String localidade;
	
	private String horario;
	
	private Projecao projecao;

	public Populacao() {
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public Projecao getProjecao() {
		return projecao;
	}

	public void setProjecao(Projecao projecao) {
		this.projecao = projecao;
	}
}