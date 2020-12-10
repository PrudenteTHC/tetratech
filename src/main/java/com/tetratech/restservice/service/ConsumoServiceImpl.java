package com.tetratech.restservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tetratech.restservice.model.Populacao;

@Service
public class ConsumoServiceImpl implements ConsumoService {

	private static final Logger logger = LoggerFactory.getLogger(ConsumoServiceImpl.class);

	@Autowired
	RestTemplate restTemplate;
	
	public static final String IBGE_URL = "https://servicodados.ibge.gov.br/api/v1/projecoes/populacao";
	
	public Long qtdPopulacao(String dataHora) {
		
		Populacao populacao = restTemplate.getForObject(
				IBGE_URL, Populacao.class);
		logger.info(populacao.toString());
		return populacao.getProjecao().getPopulacao();
	}
	
	public Long ultimas() {
		
		Populacao populacao = restTemplate.getForObject(
				IBGE_URL, Populacao.class);
		logger.info(populacao.toString());
		return populacao.getProjecao().getPopulacao();
	}

}
