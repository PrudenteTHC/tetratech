package com.tetratech.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tetratech.controller.IBGEController;

@SpringBootTest
public class TetraTechTest {

	@Autowired
	private IBGEController ibgeController;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(ibgeController).isNotNull();
	}
}
