# clean-architecture

Projeto criado para treinar Clean Architecture no Spring Framework, houve a utilização de SonarLint para detecção de erros, mas ressalto que a prioridade deste projeto foi o aprendizado desta arquitetura, sendo assim, não houve a preocupação com testes unitários ou Implementação de handler. Muito importante destacar que os arquivos dockers estão implementados com usuários 'root' e senhas 'example', caso siga o modelo no dia-dia, considere a utilização de .env file.

## Features

- Implementação de Clean Architecture;
- Implementação de MongoDB;
- Implementação de Kafka;
- Implementação de Wiremock;
- Dockerização;

## Tech

Foram utilizados:

- Java: V11;
- Kafka;
- Maven: V3.8.7;
- MongoDB;
- Spring-Boot: V2.7.6-RELEASE;
- Wiremock : V2.35.0.

## O projeto
##

- Foi criada uma API de Cliente em que ocorre um CRUD.
- Para inserção do cliente, existe uma busca numa API de Endereço utilizando do CEP.
- Uma vez que validado, os dados são salvos numa base MongoDB.
- Em seguida, o CPF é enviado para uma fila do Kafka para que a API de validação de CPF o receba, valide ou não, e em seguida postará em nova fila, onde teremos um consumidor que irá ler e alterar os dados junto a API de Cliente.

** Importante ressaltar que API de validação de CPF está simulada e API de Endereço utilizamos do Wiremock para exibição de dados na tela **

##

## Comandos Úteis
##
Executar o arquivo docker-compose.yml no diretório "docker-local"
```sh
docker-compose up
```
##
Acessar o container Mongo e executar comando de consulta
Atenção: Utilize o "docker ps" para verificar o ID do Container Mongo.
```sh
docker ps
docker exec -it {CONTAINER_ID_MONGO} /bin/bash
mongosh -u root -p
-- digite a senha especificada no docker-compose --
db.container.find()
```
##
Executar o arquivo wiremock-jre8-standalone-2.35.0.jar no diretório "wiremock" que irá ler os jsons do diretório "mappings".
```sh
java -jar wiremock-jre8-standalone-2.35.0.jar --port 8082
```