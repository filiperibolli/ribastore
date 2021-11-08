<h1> RibaStore </h3>
Sistema de loja de coins(Moeda do jogo 'Tibia') com arquitetura de microservicos  


<h3> ribastore-loja - Microservico responsavel por realizar a compra </h3>

<p> spring-cloud-starter-config -> utilizando sistema de configuracao em nuvem </p>
<p> spring-cloud-starter-netflix-eureka-client -> registrando o servico no EUREKA </p>
<p> spring-cloud-starter-openfeign -> realiza a comunicacao entre os microservicos </p>
<p> spring-cloud-starter-netflix-hystrix -> administra os erros e fallbacks tanto quanto o bulkhead e threads</p>
<p> spring-boot-starter-security -> Administra a autenticacao entre a comunicacao dos servicos
<p> spring-cloud-starter-oauth2 -> Protocolo utlizado de autenticacao com server
<p> lombok -> utilizado para genrenciamento dos dto's </p>
<p> swagger -> http://{{host}}:{{port}}/swagger-ui.html/ </p>
 
<h3> ribastore-delivery - Sistema de entrega de pedido  </h3>

<p> spring-cloud-starter-config -> utilizando sistema de configuracao em nuvem </p>
<p> spring-cloud-starter-netflix-eureka-client -> registrando o servico no EUREKA </p>
<p> lombok -> utilizado para genrenciamento dos dto's </p>
<p> swagger -> http://{{host}}:{{port}}/swagger-ui.html/ </p>
 
 <h3> ribastore-estoque - Servico responsavel pelo gerenciamento de pedidos e estoque  </h3>

<p> spring-cloud-starter-config -> Utilizando sistema de configuracao em nuvem </p>
<p> spring-cloud-starter-netflix-eureka-client -> Registrando o servico no EUREKA </p>
<p> spring-boot-starter-security -> Administra a autenticacao entre a comunicacao dos servicos
<p> spring-cloud-starter-oauth2 -> Protocolo utlizado de autenticacao com server
<p> spring-boot-starter-data-jpa -> Utilizacao nas consultas ao banco de dados dedicado
<p> lombok -> utilizado para genrenciamento dos dto's </p>
<p> swagger -> http://{{host}}:{{port}}/swagger-ui.html/ </p>


<h3> eureka - Netflix server descovery </h3>

<p> spring-cloud-starter-netflix-eureka-server -> Integracao de microservicos e loadbalancer utilizando 'EUREKA' (Service discovery) e 'Ribbon'(Load balancer).</p>

 
<h3>configuration - Servico responsavel pelo gerenciamento de configuracoes do ecosistema RibaStore  </h3>

<p> spring-cloud-config-server -> tecnologia utilizada para gerenciar as configuracoes do sistema </p>
<p> Configuracoes do projeto do em: https://github.com/filiperibolli/ribastore-config </p>

<h3> authentication - Servico responsavel pelo controle de autenticacao OAUTH2 </h3>
 
<p> spring-boot-starter-security -> Administra a autenticacao entre a comunicacao dos servicos
<p> spring-cloud-starter-oauth2 -> Protocolo utlizado de autenticacao com server

<h3>apigateway-zuul - servico de api gateway (proxy) utilizando Spring zuul </h3>

<p> spring-cloud-starter-netflix-zuul -> api gateway Spring zuul implementado para facilitar as chamadas backend e execucao do proxy</p>
<p> spring-cloud-starter-netflix-eureka-client -> integrado com o zuul faz com que essa funcionalidade funcione quase que sozinha </p>


<h3> Pontos em melhoria </h3>

<p> Aumentar % de cobertura de testes </p>
<p> Fluxo de fallBack de reprocessar e cancelar compra </p>
<p> Integracao fina com algumas funcionalidades do swagger </p>
