package dev.alejandro.cryptodatademo.config;

import dev.alejandro.cryptodatademo.domain.CryptoManagerService;
import dev.alejandro.cryptodatademo.domain.Transactions;
import dev.alejandro.cryptodatademo.repository.TransactionJdbcH2Repository;
import dev.alejandro.cryptodatademo.service.CreateNewTransactionService;
import dev.alejandro.cryptodatademo.service.ReadTransactionService;
import dev.alejandro.cryptodatademo.service.UserDataCryptoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.simple.JdbcClient;

@Configuration
public class TransactionBeanConfiguration {

    @Bean
    CryptoManagerService cryptoManagerService() {
        return new UserDataCryptoService();
    }

    @Bean
    Transactions transactionRepository(JdbcClient jdbcClient) {
        return new TransactionJdbcH2Repository(jdbcClient);
    }

    @Bean
    CreateNewTransactionService createTransactionUseCase(CryptoManagerService cryptoManagerService, Transactions transactionRepository) {
        return new CreateNewTransactionService(cryptoManagerService, transactionRepository);
    }

    @Bean
    ReadTransactionService readTransactionsUseCase(CryptoManagerService cryptoManagerService, Transactions transactionRepository) {
        return new ReadTransactionService(cryptoManagerService, transactionRepository);
    }
}
