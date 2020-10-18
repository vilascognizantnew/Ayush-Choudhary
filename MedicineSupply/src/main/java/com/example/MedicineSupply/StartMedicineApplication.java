package com.example.MedicineSupply;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class StartMedicineApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartMedicineApplication.class, args);
    }

	// init bean to insert 3 books into h2 database.
    @Bean
    CommandLineRunner initDatabase(MedicineRepository repository) {
        return args -> {
            repository.save(new Medicine());
            repository.save(new Medicine());
            repository.save(new Medicine());
        };
    }
}