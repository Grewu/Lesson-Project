CREATE TABLE users
(
    id    BIGSERIAL PRIMARY KEY,
    name  VARCHAR(255),
    email VARCHAR(255),
    cash  DECIMAL(10, 2)
);
CREATE TABLE bank
(
    id      BIGSERIAL PRIMARY KEY,
    user_id BIGINT,
    name    VARCHAR(30),
    FOREIGN KEY (user_id) REFERENCES users (id)
);
CREATE TABLE account
(
    id      BIGSERIAL PRIMARY KEY,
    user_id BIGINT,
    bank_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (bank_id) REFERENCES bank (id)
);
CREATE TABLE transaction
(
    id      BIGSERIAL PRIMARY KEY,
    user_id BIGINT,
    bank_id BIGINT,
    amount  NUMERIC(12, 2),
    time    TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (bank_id) REFERENCES bank (id)
);

INSERT INTO users (name, email, cash)
VALUES ('Alice', 'alice@example.com', 1000.00),
       ('Bob', 'bob@example.com', 2000.00),
       ('Charlie', 'charlie@example.com', 1500.50);

INSERT INTO bank (user_id, name)
VALUES (1, 'Bank of Alice'),
       (2, 'Bob Bank'),
       (3, 'Charlie Savings');

INSERT INTO account (user_id, bank_id)
VALUES (1, 1),
       (2, 2),
       (3, 3);

-- Вставим данные в таблицу "transaction"
INSERT INTO transaction (user_id, bank_id, amount, time)
VALUES (1, 1, 500.00, CURRENT_TIMESTAMP),
       (2, 2, -200.00, CURRENT_TIMESTAMP),
       (3, 3, 1000.50, CURRENT_TIMESTAMP);

-- Создание индексов
CREATE INDEX idx_transactions_user_id ON transaction (user_id);
CREATE INDEX idx_transactions_bank_id ON transaction (bank_id);
CREATE INDEX idx_transactions_time ON transaction (time);


DROP TABLE account;



CREATE TABLE account
(
    id             SERIAL PRIMARY KEY,
    account_number VARCHAR(20) NOT NULL,
    balance        DECIMAL(10, 2) DEFAULT 0.00,
    is_active      BOOLEAN        DEFAULT true,
    created_at     TIMESTAMP      DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO account (account_number, balance, is_active)
VALUES ('1234567890', 1000.00, true),
       ('0987654321', 500.50, true),
       ('1357924680', 750.75, false);
