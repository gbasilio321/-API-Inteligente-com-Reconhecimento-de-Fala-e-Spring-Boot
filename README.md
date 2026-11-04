# Budgeting API com Spring AI

## O que o projeto faz
API de orçamento que recebe comandos de voz, transcreve o áudio,
usa IA (Tool Calling) para escolher uma função da aplicação,
salva ou consulta transações e responde em áudio.

## Como executar
1. Java 25 e Docker Desktop instalados
2. Defina a chave: `$env:OPENAI_API_KEY="..."`
3. Na pasta 05-spring-ai: `.\gradlew.bat bootRun`

## Melhoria implementada
Validação no domínio (`Transaction`), com testes unitários.

Ao criar uma nova transação, agora são verificadas 3 regras:
- a descrição não pode ser vazia;
- o valor deve ser maior que zero;
- a categoria é obrigatória.

Se alguma regra falhar, é lançada uma `IllegalArgumentException`.

Escolhi o domínio porque a regra vale tanto para o REST quanto para a IA,
sem precisar repetir código em outros lugares.

Arquivos alterados:
- `src/main/java/dio/budgeting/domain/Transaction.java`
- `src/test/java/dio/budgeting/domain/TransactionTest.java` (novo)

## Tecnologias
Java, Spring Boot, Spring AI, OpenAI, JPA, MySQL, Gradle, JUnit, Docker

## Como testar
`.\gradlew.bat test --tests "*TransactionTest"`

![Resultado dos testes](public/capturaDeTela.png)

## O que aprendi
Aprendi que o projeto separa o código em camadas (domínio, aplicação e infraestrutura) e que a IA chama os mesmos casos de uso que o REST, sem pular essas camadas.
Implementei a validação no domínio (`Transaction`) para que valor zero ou negativo, descrição vazia e categoria ausente sejam barrados tanto pela API quanto pela IA, e aprendi a provar isso com testes unitários em JUnit.
Também aprendi a lidar com problemas de ambiente (Docker, WSL, versão do Java e o lugar certo dos arquivos de teste), o que me ajudou a entender melhor como o projeto roda.