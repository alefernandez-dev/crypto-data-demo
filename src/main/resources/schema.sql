CREATE TABLE IF NOT EXISTS transactions (
    id SERIAL PRIMARY KEY,
    client_document VARCHAR(255) NOT NULL,
    credit_card_token VARCHAR(255) NOT NULL,
    transaction_value DECIMAL(19,2) NOT NULL
);
