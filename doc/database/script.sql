CREATE SCHEMA IF NOT EXISTS sistema_vendas DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE sistema_vendas ;

-- -----------------------------------------------------
-- Table produto
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS produto (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(150) NULL,
  estoque INT NULL,
  preco FLOAT NULL,
  peso FLOAT NULL,
  descricao TEXT NULL,
  PRIMARY KEY (id))
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
  PRIMARY KEY (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table funcionario
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS funcionario (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(70) NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table pedido
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS pedido (
  id INT NOT NULL AUTO_INCREMENT,
  status VARCHAR(45) NULL,
  data DATE NULL,
  produto_id INT NOT NULL,
  cliente_id INT NOT NULL,
  funcionario_id INT NOT NULL,
  PRIMARY KEY (id),
  INDEX fk_pedido_produto_idx (produto_id ASC),
  INDEX fk_pedido_cliente1_idx (cliente_id ASC),
  INDEX fk_pedido_funcionario1_idx (funcionario_id ASC),
  CONSTRAINT fk_pedido_produto
    FOREIGN KEY (produto_id)
    REFERENCES produto (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_pedido_cliente1
    FOREIGN KEY (cliente_id)
    REFERENCES cliente (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_pedido_funcionario1
    FOREIGN KEY (funcionario_id)
    REFERENCES funcionario (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;