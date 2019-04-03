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
	CommandLineRunner initDatabase(BellService bellService) {
		Bell bell_1 = new Bell();
		bell_1.setId(new Long(1));
		bell_1.setDate(new Date());
		Bell bell_2 = new Bell();
		bell_2.setId(new Long(2));
		bell_2.setDate(new Date());
		return args -> {
			bellService.save(bell_1);
			bellService.save(bell_2);
		};
	}

}
