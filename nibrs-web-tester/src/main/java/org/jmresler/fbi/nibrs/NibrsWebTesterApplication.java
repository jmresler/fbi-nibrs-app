package org.jmresler.fbi.nibrs;

import lombok.extern.slf4j.Slf4j;
import org.jmresler.fbi.nibrs.services.AgenciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.stream.IntStream;

@Slf4j
@SpringBootApplication
public class NibrsWebTesterApplication implements CommandLineRunner {

	@Autowired
	protected AgenciesService agenciesService;

	public static void main(String[] args) {
		SpringApplication.run(NibrsWebTesterApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		IntStream.range(49, 100).forEach(id -> {
			var agencies = agenciesService.findAgencyById(id);
			log.debug("Agencies -> {}", agencies.toString());

		});

	}
}
