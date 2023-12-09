package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.jmresler.fbi.nibrs.services.AgenciesService;
import org.jmresler.fbi.nibrs.services.MonthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class NibrsWebTesterApplication implements CommandLineRunner {

    @Autowired
    protected MonthService monthService;

    public static void main(String[] args) {
        SpringApplication.run(NibrsWebTesterApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        monthService.getAllMonths().forEach(month -> {
            log.debug(month.toString());
        });
    }
}
