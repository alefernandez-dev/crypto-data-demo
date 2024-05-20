package dev.alejandro.cryptodatademo.service;

import dev.alejandro.cryptodatademo.domain.*;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class CreateNewTransactionService  {

    private final CryptoManagerService cryptoManagerService;
    private final Transactions transactionRepository;

    public CreateNewTransactionService(CryptoManagerService cryptoManagerService, Transactions transactionRepository) {
        this.cryptoManagerService = cryptoManagerService;
        this.transactionRepository = transactionRepository;
    }

    public void create(CrateNewTransactionInputData inputData) {

        var newTransaction = Transaction.of(
                cryptoManagerService.encrypt(inputData.clientDocument()),
                cryptoManagerService.encrypt(inputData.creditCardToken()),
                inputData.transactionValue()
        );

        transactionRepository.save(newTransaction);

    }
}
