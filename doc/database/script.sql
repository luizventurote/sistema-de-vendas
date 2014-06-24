CREATE SCHEMA IF NOT EXISTS sistema_vendas DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE sistema_vendas ;

-- -----------------------------------------------------
-- Table pedido
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS pedido (
  id INT NOT NULL AUTO_INCREMENT,
  status VARCHAR(45) NULL,
  data DATE NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table produto
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS produto (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(150) NULL,
  estoque INT NULL,
  preco FLOAT NULL,
  peso FLOAT NULL,
  desc TEXT NULL,
  pedido_id INT NOT NULL,
  PRIMARY KEY (id),
  INDEX fk_produto_pedido1_idx (pedido_id ASC),
  CONSTRAINT fk_produto_pedido1
    FOREIGN KEY (pedido_id)
    REFERENCES pedido (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table cliente
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS cliente (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(70) NULL,
  email VARCHAR(45) NULL,
  dataNasc DATE NULL,
  telFixo VARCHAR(45) NULL,
  telCel VARCHAR(45) NULL,
  endereco VARCHAR(80) NULL,
  numero INT NULL,
  bairro VARCHAR(50) NULL,
  cidade VARCHAR(45) NULL,
  uf VARCHAR(3) NULL,
  complemento VARCHAR(100) NULL,
  pedido_id INT NOT NULL,
  PRIMARY KEY (id),
  INDEX fk_cliente_pedido1_idx (pedido_id ASC),
  CONSTRAINT fk_cliente_pedido1
    FOREIGN KEY (pedido_id)
    REFERENCES pedido (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table funcionario
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS funcionario (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(70) NULL,
  pedido_id INT NOT NULL,
  PRIMARY KEY (id),
  INDEX fk_funcionario_pedido_idx (pedido_id ASC),
  CONSTRAINT fk_funcionario_pedido
    FOREIGN KEY (pedido_id)
    REFERENCES pedido (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;