package dev.alejandro.cryptodatademo;

import dev.alejandro.cryptodatademo.domain.CrateNewTransactionInputData;
import dev.alejandro.cryptodatademo.service.CreateNewTransactionService;
import dev.alejandro.cryptodatademo.service.ReadTransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class CryptoDataDemoApplication {

	Logger logger = LoggerFactory.getLogger(CryptoDataDemoApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(CryptoDataDemoApplication.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner(CreateNewTransactionService createNewTransactionService, ReadTransactionService readTransactionService) {
		return args -> {
			createNewTransactionService.create(new CrateNewTransactionInputData("31210014", "12h5-de74-sok9-ad6g", BigDecimal.valueOf(25000)));

			readTransactionService.read().forEach(t -> logger.info(t.toString()));

		};
	}

}
