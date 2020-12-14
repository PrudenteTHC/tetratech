package com.tetratech.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tetratech.model.Populacao;
import com.tetratech.service.ConsumoService;

/**
 * Classe Controller
 * 
 * @author Thiago Prudente
 *
 */
@RestController
public class IBGEController {
	
	private static final Integer amount = new Integer(10);
	
	@Autowired
	private ConsumoService consumoService;

	@GetMapping("/estimativa")
	public Long estimativa(@RequestParam(value = "dataHora", defaultValue = "10/12/2020") String dataHora) {;

		return consumoService.qtdPopulacao("");
	}

	@GetMapping("/ultimas")
	public ResponseEntity<List<Populacao>> ultimas() {
		try {
			return new ResponseEntity<List<Populacao>>(consumoService.ultimas(amount), HttpStatus.OK);
		} catch (IOException e) {
			return new ResponseEntity<List<Populacao>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
