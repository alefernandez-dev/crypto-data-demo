package dev.alejandro.cryptodatademo.domain;

import java.math.BigDecimal;

public record CrateNewTransactionInputData(String clientDocument, String creditCardToken, BigDecimal transactionValue) {
}
