package org.jmresler.fbi.nibrs;

import lombok.extern.slf4j.Slf4j;
import org.jmresler.fbi.nibrs.dao.AgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	protected AgencyRepository repository;

	private static final Agencies EMPTY_AGENCY = new Agencies();

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var agency49 = repository.findById(49).orElse(EMPTY_AGENCY);
		log.debug("Public Agency Name {}, UCR Agency Name {}", agency49.getPubAgencyName(), agency49.getUcrAgencyName());
	}
}
