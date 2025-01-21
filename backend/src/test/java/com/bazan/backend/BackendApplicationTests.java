package com.bazan.backend;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;

class BackendApplicationTests {
	static ApplicationModules module  = ApplicationModules.of(BackendApplication.class);

	@Test
	void contextLoads() {

		module.forEach(System.out::println);

		module.verify();
	}

}
