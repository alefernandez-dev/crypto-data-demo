package dev.alejandro.cryptodatademo.repository;

import dev.alejandro.cryptodatademo.domain.Transaction;
import dev.alejandro.cryptodatademo.domain.Transactions;
import org.springframework.jdbc.core.simple.JdbcClient;

import java.util.List;

public class TransactionJdbcH2Repository implements Transactions {

    private final JdbcClient jdbcClient;

    public TransactionJdbcH2Repository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public List<Transaction> findAll() {
        return jdbcClient.sql("SELECT * FROM transactions").query(Transaction.class).list();
    }

    @Override
    public void save(Transaction transaction) {

        jdbcClient.sql("""
            INSERT INTO transactions (client_document, credit_card_token, transaction_value)
            VALUES (:cd, :cct, :tv)
            """)
                .param("cd", transaction.clientDocument())
                .param("cct", transaction.creditCardToken())
                .param("tv", transaction.transactionValue())
                .update();

    }
}
