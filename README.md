Source-Code-Inspection [![Build Status](https://travis-ci.org/Prof-Calebe/Source-Code-Inspection.svg?branch=master)](https://travis-ci.org/Prof-Calebe/Source-Code-Inspection)
======================

Link para o Travis-CI: https://travis-ci.org/Prof-Calebe/Source-Code-Inspection



## Documentação do Projeto
Este projeto simula uma máquina de vender bilhetes de transporte público, que permite ao usuário inserir dinheiro, solicitar bilhetes e receber troco. A máquina mantém um saldo total acumulado de todas as transações.

## Requisitos

### 1. Catálogo dos Atores
- **Cliente**: O usuário que interage com a máquina para comprar bilhetes ou solicitar troco.

### 2. Casos de Uso

#### CSU01 - Inserir Dinheiro
- **Ator**: Cliente
- **Descrição**: O cliente insere uma nota de papel-moeda na máquina.
- **Pós-condição**: O valor inserido é adicionado ao saldo total da máquina.
- **Fluxo Principal**:
  1. O cliente insere uma nota de papel-moeda.
  2. A máquina valida a nota.
  3. O valor é adicionado ao saldo.
  4. A máquina informa o saldo atual.
- **Fluxo de Exceção**:
  - Caso a nota seja inválida, a máquina a devolve e informa ao cliente.

#### CSU02 - Solicitar Bilhete
- **Ator**: Cliente
- **Descrição**: O cliente solicita a impressão de um bilhete de transporte.
- **Pós-condição**: Um bilhete é impresso e o valor é debitado do saldo.
- **Fluxo Principal**:
  1. O cliente solicita um bilhete.
  2. A máquina verifica o saldo e imprime o bilhete.
  3. A máquina atualiza e informa o saldo restante.
- **Fluxo de Exceção**:
  - Caso o saldo seja insuficiente, a máquina informa o cliente e retorna ao fluxo principal.

#### CSU03 - Solicitar Troco
- **Ator**: Cliente
- **Descrição**: O cliente solicita o troco restante.
- **Pós-condição**: O troco é devolvido e o saldo é zerado.
- **Fluxo Principal**:
  1. O cliente solicita o troco.
  2. A máquina devolve o valor em papel-moeda.
  3. A máquina zera o saldo e informa ao cliente.

## Projeto Orientado a Objetos

### Diagrama de Classes Principal
O projeto utiliza um diagrama de classes que modela os principais componentes e suas interações.

### Diagramas de Sequência
Foram criados diagramas de sequência para os seguintes casos de uso:
- **Inserir Dinheiro**
- **Solicitar Bilhete**
- **Solicitar Troco**
