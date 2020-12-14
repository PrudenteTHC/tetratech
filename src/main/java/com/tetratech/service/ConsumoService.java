package com.tetratech.service;

import java.io.IOException;
import java.util.List;

import com.tetratech.model.Populacao;

public interface ConsumoService {

	public Long qtdPopulacao(String dataHora);
	
	public List<Populacao> ultimas(Integer total) throws IOException;
	
}
