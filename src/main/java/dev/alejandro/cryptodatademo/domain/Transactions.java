package dev.alejandro.cryptodatademo.domain;

import java.util.List;

public interface Transactions {
    List<Transaction> findAll();
    void save(Transaction transaction);
}
