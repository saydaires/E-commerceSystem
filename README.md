Passos para executar a aplicação:

PASSO I) **BANCO DE DADOS**
1.1 Crie um Schema no mySQL chamado "ecommerce_db", em seguida, no **REPOSITÓRIO DO PROJETO** vá até o seguinte caminho:
"Arquivos de texto MySQL\Comandos DDL\estrutura_database.sql"
O arquivo "estrutura_database.sql" contém todas as declarações que estruturam o schema/banco de dados.
O banco de dados criado deve estar configurado **de modo a não ter senha**, uma vez que por questões de portabilidade, a aplicação
possui uma conexão estabelecida com o banco de dados em usuário ROOT **que não possui senha.**

1.2 Vá até o caminho:
**"Arquivos de texto MySQL\Comandos INSERT\insert_database.sql"**
O arquivo "insert_database.sql" contém todas as declarações que inserem DADOS no esquema, preparando-o para seu uso prévio.

PASSO II) **EXECUTANDO A APLICAÇÃO**
1.1 APLICAÇÃO PARA FUNCIONÁRIO/ADMIN
Para executar essa aplicação, vá até o seguinte caminho  no repositório do projeto:
**"E-commerce Application\src\VIEW\ADMIN\LoginMenuPrincipal\AdministradorApp.java"**
Em seguida, execute o arquivo AdministradorApp.java.

1.2 **APLICAÇÃO PARA CLIENTE:**
Para executar essa aplicação, vá até o seguinte caminho  no repositório do projeto:
**"E-commerce Application\src\VIEW\CLIENT\LoginMenuPrincipal\ClienteApp.java"**
Em seguida, execute o arquivo ClienteApp.java.

**OBSERVAÇÃO IMPORTANTE:**
Não tente executar outras telas da aplicação CLIENT sem antes ter executado a tela de **ClienteApp.java** e ter feito um Login bem sucedido.
Isso se dá devido ao fato de que outras telas chamadas a partir do Login em *ClienteApp.java* **operam com as credenciais do usuário então logado**
e por esse motivo, o Login é completamente fundamental e **obrigatório** para que aplicação CLIENT seja executada corretamente.
