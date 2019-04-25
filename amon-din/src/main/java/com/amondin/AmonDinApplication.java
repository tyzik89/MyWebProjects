package com.amondin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AmonDinApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmonDinApplication.class, args);
	}

	/* //Добавление тестовых звонков в список (для List_Repository)
	@Bean
	CommandLineRunner initList(BellService bellService) {
		return args -> {
			bellService.save(new Bell(1L, LocalDateTime.now().minusHours(5).minusMinutes(30)));
			bellService.save(new Bell(2L, LocalDateTime.now()));
		};
	}*/

}
