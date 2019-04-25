package com.amondin;

import com.amondin.model.entities.Bell;
import com.amondin.model.services.BellService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class AmonDinApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmonDinApplication.class, args);
	}

	 //Добавление тестовых звонков
	@Bean
	CommandLineRunner initList(BellService bellService) {
		return args -> {
			bellService.save(new Bell(1L, LocalDateTime.now().minusHours(5).minusMinutes(30)));
			bellService.save(new Bell(2L, LocalDateTime.now()));
		};
	}

}
