package dev.alejandro.cryptodatademo.domain;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

public record Transaction(@Id Integer id, String clientDocument, String creditCardToken, BigDecimal transactionValue) {

    public static Transaction of(String clientDocument, String creditCardToken, BigDecimal transactionValue) {
        return new Transaction(null, clientDocument, creditCardToken, transactionValue);
    }

}
