package com.asmwtickets;

import com.asmwtickets.event.Event;
import com.asmwtickets.event.EventRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TicketsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketsApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(EventRepository repository){
	    return e -> repository.save(new Event("Teatro Cubano", "Krakow","15-05-2017"));
    }
}
