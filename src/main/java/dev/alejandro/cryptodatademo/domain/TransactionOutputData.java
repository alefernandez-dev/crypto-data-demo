package dev.alejandro.cryptodatademo.domain;

import java.math.BigDecimal;

public record TransactionOutputData(Integer id, String clientDocument, String creditCardToken, BigDecimal transactionValue) {
}
