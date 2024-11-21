# Gerenciador de empréstimos de ferramentas
<hr/>
Projeto A3 da UC: Programação de soluções computacionais do curso de Engenharia da Computação da universidade Unisul.

<h3>Objetivos</h3>
Este é um software desktop para gerenciar o empréstimo de ferramentas.<br>
Nele é possível cadastrar uma lista de ferramentas e também uma lista de amigos.<br>
A partir das duas listas se realiza o empréstimo das ferramentas para os amigos fazendo a associação entre uma ferramenta e o amigo que pediu a ferramenta emprestada.<br>
O programa também é capaz de gerar alguns relatórios para melhor controle do susuário.

<h3>Características</h3>
Este programa utiliza a linguagem Java com o banco de dados MYSQL.<br>
O programa funciona com interface gráfica. Foi desenvolvido e testado apenas em ambiente Windows rodando a versão 8 do Java JDK.<br>
O programa permite cadastrar ferramentas e amigos, assim como, registrar com precisão todos os empréstimos e devolução de ferramentas.<br>
O programa também é capaz de gerar alguns tipos de relatórios, como por exemplo:<br>
<li>Listar as ferramentas e o valor gasto para adquiri-las;</li>
<li>Listar quais ferramentas estão emprestadas e quais estão disponíveis;</li>
<li>Listar quais amigos têm ferramentas emprestadas, tanto os que devolvem as ferramentas dentro do prazo legal do empréstimo ou devolvem com atraso;</li>
<li>Listar os amigos que nunca devolveram as ferramentas que pediram emprestadas.</li>

<h3>Alunos desenvolvedores</h3>
Elias Bernabé Turchiéllo - RA 162211618 (Turchiellows)<br>
João Vitor Iuncks - RA 162212085 (Iuncks)<br>
Pedro Henrique Medeiros - RA 162410853 (PedroMedeiros73423)<br> 

<h3>Requisitos funcionais</h3>
<li>Cadastro e edição de ferramentas;</li>
<li>Cadastro e edição de amigos;</li>
<li>Cadastro e edição de empréstimos;</li>
<li>Listar as ferramentas e o valor gasto de aquisição;</li>
<li>Listar as ferramentas emprestadas;</li>
<li>Listar as ferramentas disponíveis para empréstimos;</li>
<li>Listar os amigos com empréstimos em dia;</li>
<li>Listar os amigos com empréstimos atrasados;</li>
<li>Listar os empréstimos em dia;</li>
<li>Listar os empréstimos atrasados;</li>
<li>Listar os amigos que nunca devolveram as ferramentas que pediram emprestadas;</li>
<li>Verificar pendência de ferramentas não devolvidas pelo amigo antes de conceder novo empréstimo.</li>

<h3>Requisitos não funcionais</h3>
<li>O banco de dados deve estar instalado no mesmo computador onde o programa está rodando;</li>
<li>É necessário um computador com ambiente gráfico para rodar o programa;</li>
<li>É necessário a versão 8 do java instalado;</li>
<li>O software é destinado para uso pessoal de forma que nenhuma informação por ele manipulada é compartilhada, logo, a LGPD não se aplica nesse caso;</li>
<li>Não há criptografia dos dados manipulados, as informações são armazenadas no banco de dados em texto puro;</li>
<li>Eventuais manutenções e ampliações do software não fazem parte do escopo inicial devendo serem solicitadas aos desenvolvedores em outros momentos.</li>

<h3>Banco de dados</h3>
Script para criar o banco de dados:<br>
<pre><a href="https://github.com/PedroMedeiros73423/GerenciadorFerramentas/blob/main/banco.sql">banco.sql</a></pre>
O banco de dados deve estar localizado na mesma máquina onde o programa será rodado.
O banco é formado por apenas 3 tabelas: ferramentas, amigos e negócios.
Para não precisar modificar nada do código do programa em relação à conexão com o banco de dados, configure no SGBD as seguintes credenciais:<br>
Usuário: root<br>
Senha : unisul<br><br>
Caso precise editar o código fonte para cadastrar usuário e senha de seu banco de dados, faça no seguinte arquivo:<br>
<pre><a href="https://github.com/PedroMedeiros73423/GerenciadorFerramentas/blob/main/src/main/java/dao/ServidorDAO.java">src/main/java/dao/ServidorDAO.java</a></pre>
