package com.amondin;

import com.amondin.model.entities.Bell;
import com.amondin.model.services.BellService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class AmonDinApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmonDinApplication.class, args);
	}

	@Bean
	CommandLineRunner initList(BellService bellService) {
		return args -> {
			bellService.save(new Bell(new Long(1), new Date()));
			bellService.save(new Bell(new Long(2), new Date()));
		};
	}

}
