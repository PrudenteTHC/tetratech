package com.tetratech.service;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tetratech.interceptor.RequestResponseLoggingInterceptor;
import com.tetratech.model.Populacao;
import com.tetratech.restservice.util.FileUtil;

/**
 * Classe de Serviço
 * 
 * @author Thiago Prudente
 *
 */
@Service
public class ConsumoServiceImpl implements ConsumoService {

	@Autowired
	RestTemplate restTemplate;
	
	public static final String IBGE_URL = "https://servicodados.ibge.gov.br/api/v1/projecoes/populacao";
	
	public static final String FILE_NAME = "tetraTechRest";
	
	public Long qtdPopulacao(String dataHora) {
		
		interceptRest();
		
		Populacao populacao = restTemplate.getForObject(
				IBGE_URL, Populacao.class);
		
		return populacao.getProjecao().getPopulacao();
	}
	
	public List<Populacao> ultimas(Integer total) throws IOException {
		
			List<Populacao> populacao = FileUtil.getInstance().readLinesFromFile(FILE_NAME);
			
			if (populacao.size() < total)
				total = populacao.size();
			
			return populacao.subList((populacao.size() - total), populacao.size());
	}
	
	private void interceptRest() {
		restTemplate.setInterceptors(Collections.singletonList(new RequestResponseLoggingInterceptor()));
	}

}
