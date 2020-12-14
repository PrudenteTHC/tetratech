# tetratech
Requisitos para execução do projeto:
Maven 3.6+
JDK 8+

Build:
baixe o projeto clonando.
execute na raiz do projeto: mvn clean instal

Crie na pasta raiz C:\\
o diretório: report
e o arquivo vazio: tetraTechRest.txt

Executar:
No diretório target execute o seguinte:
java -jar rest-service-0.0.1-SNAPSHOT.jar

Utilizando os serviços no browser:

1. estimativa da população
http://localhost:8080/estimativa
passe o parâmetro:
name:dataHora
value: valor da data e hora para a estimativa da população.

2. Últimas 10 chamadas na API.
http://localhost:8080/ultimas
