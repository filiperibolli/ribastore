<h1> RibaStore </h3>
Sistema de loja de coins(Moeda do jogo 'Tibia') com arquitetura de microservicos  

 
<h3> ribastore-delivery - Sistema de entrega de pedido  </h3>

<p> spring-cloud-starter-config -> utilizando sistema de configuracao em nuvem </p>
<p> spring-cloud-starter-netflix-eureka-client -> registrando o servico no EUREKA </p>
<p> lombok -> utilizado para genrenciamento dos dto's </p>
 
 <h3> ribastore-estoque - Servico responsavel pelo gerenciamento de pedidos e estoque  </h3>

<p> spring-cloud-starter-config -> Utilizando sistema de configuracao em nuvem </p>
<p> spring-cloud-starter-netflix-eureka-client -> Registrando o servico no EUREKA </p>
<p> spring-boot-starter-security -> Administra a autenticacao entre a comunicacao dos servicos
<p> spring-cloud-starter-oauth2 -> Protocolo utlizado de autenticacao com server
<p> spring-boot-starter-data-jpa -> Utilizacao nas consultas ao banco de dados dedicado
<p> lombok -> utilizado para genrenciamento dos dto's </p>


<h3> eureka - Netflix server descovery </h3>

<p> Integracao de microservicos e loadbalancer utilizando 'EUREKA' (Service discovery) e 'Ribbon'(Load balancer).</p>

 
<h3>configuration - Servico responsavel pelo gerenciamento de configuracoes do ecosistema RibaStore  </h3>

<p> spring-cloud-config-server -> tecnologia utilizada para gerenciar as configuracoes do sistema </p>
<p> Configuracoes do projeto do em: https://github.com/filiperibolli/ribastore-config </p>

<h3> authentication - Servico responsavel pelo controle de autenticacao OAUTH2 </h3>
 
<p> spring-boot-starter-security -> Administra a autenticacao entre a comunicacao dos servicos
<p> spring-cloud-starter-oauth2 -> Protocolo utlizado de autenticacao com server