package dev.alejandro.cryptodatademo.service;

import dev.alejandro.cryptodatademo.domain.CryptoManagerService;
import dev.alejandro.cryptodatademo.domain.TransactionOutputData;
import dev.alejandro.cryptodatademo.domain.Transactions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ReadTransactionService {

    Logger logger = LoggerFactory.getLogger(ReadTransactionService.class);

    private final CryptoManagerService cryptoManagerService;
    private final Transactions transactionRepository;

    public ReadTransactionService(CryptoManagerService cryptoManagerService, Transactions transactionRepository) {
        this.cryptoManagerService = cryptoManagerService;
        this.transactionRepository = transactionRepository;
    }

    public List<TransactionOutputData> read() {
        return transactionRepository
                .findAll()
                .stream()
                .peek(t -> logger.info(t.toString()))
                .map(t -> new TransactionOutputData(
                        t.id(),
                        cryptoManagerService.decrypt(t.clientDocument()),
                        cryptoManagerService.decrypt(t.creditCardToken()),
                        t.transactionValue()))
                .toList();
    }
}
