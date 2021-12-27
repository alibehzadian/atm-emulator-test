CREATE DATABASE IF NOT EXISTS bank_service_db;

USE bank_service_db;

CREATE TABLE IF NOT EXISTS card (
  id bigint NOT NULL AUTO_INCREMENT,
  auth_method varchar(255) DEFAULT NULL,
  balance decimal(21,9) DEFAULT NULL,
  card_number varchar(255) DEFAULT NULL,
  card_pin varchar(255) DEFAULT NULL,
  finger_print varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS card_transaction (
  id bigint NOT NULL AUTO_INCREMENT,
  after_balance decimal(21,9) DEFAULT NULL,
  amount decimal(21,9) DEFAULT NULL,
  before_balance decimal(21,9) DEFAULT NULL,
  create_date_time datetime(6) DEFAULT NULL,
  transaction_type varchar(255) DEFAULT NULL,
  card_id bigint DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK_CARD_TRANSACTION (card_id),
  CONSTRAINT FK_CARD_TRANSACTION FOREIGN KEY (card_id) REFERENCES card (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;