package com.tetratech.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tetratech.restservice.service.ConsumoService;

@RestController
public class IBGEController {
	
	@Autowired
	private ConsumoService consumoService;

	@GetMapping("/estimativa")
	public Long estimativa(@RequestParam(value = "dataHora", defaultValue = "10/12/2020") String dataHora) {
		
		return consumoService.qtdPopulacao("");
	}

	@GetMapping("/ultimas")
	public Long ultimas() {
		
		return consumoService.qtdPopulacao("");
	}
}
