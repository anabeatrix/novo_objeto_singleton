# :bulb: Entendendo os problemas de atribuir um novo objeto ao Singleton

Na aplicação temos dois serviços REST disponíveis: /config e /relatorio. :page_with_curl:

As alterações propostas abaixo foram implementadas: 
- Altere o código do método `updateConfig(Config newConfig)` para `this.config = newConfig;` 
- Crie uma nova classe de recurso chamada `RelatorioResource`  como uma cópia da `ConfigResource`, alterando a anotação `@Path` para `@Path("/relatorio")`

1. Acesse os métodos nos dois e informe qual o problema ocorrido com a alteração do código do `updateConfig`.

É preciso ter em mente que o padrão de projeto **_Singleton_ "garante a existência de uma ÚNICA instância de uma classe, mantendo um ponto de acesso global ao seu objeto"**.

No trecho de código abaixo temos um método que permite alterar as configurações (através do método http PUT) e recebe um parâmetro 
que representa as novas configurações recebidas.
 ~~~ 
 @PUT
    public void updateConfig(Config newConfig) {
        // this.config = newConfig;
    }
 ~~~
Como é possível observar no trecho a seguir, o atributo Config foi injetado e por isso tem seu ciclo de vida controlado pelo CDI.
 ~~~
 @Inject
    Config config;
 ~~~
 Assim, não podemos definir o parâmetro `newConfig` e atribuí-lo a `config`, porque estaríamos criando um NOVO objeto `newConfig` violando o padrão Singleton, isto é, **não**
teríamos uma **ÚNICA** instância, mas duas, gerando valores diferentes para o objeto que deveria ser _single_ :x:
~~~
this.config = newConfig;
~~~

![url_relatorio](https://user-images.githubusercontent.com/46926584/107446802-ef6c2e00-6b1d-11eb-9c96-e1079bedc14e.png)

![relatorio](https://user-images.githubusercontent.com/46926584/107446618-943a3b80-6b1d-11eb-82ab-58c2589ed7cf.png)

![url_config](https://user-images.githubusercontent.com/46926584/107446832-fdba4a00-6b1d-11eb-8bb1-b506fd847d27.png)

![config](https://user-images.githubusercontent.com/46926584/107446639-9d2b0d00-6b1d-11eb-8a65-aec35796019b.png)
