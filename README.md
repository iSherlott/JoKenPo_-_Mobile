# JoKenPo\_-_Mobile"

Atividade da faculdade de analise e desenvolvimento de sistema.

O aplicativo teve como escolha o layout em branco por só conter uma única tela de visualização, como pode visualizar na imagem abaixo

<img>

Os Assetes foram obtidos no site gratispng.com, procuramos imagens que trazia lembranças do antigo jogo Alex Kidd, assim com o efeito sonoro usado durante o app.

Uma das manobras utilizada para armazenar os resultados e escolha dos jogadores foi o uso de Array e Matriz, por deixar o código mais limpo e de fácil compreensão.

<img>

Sendo assim foi feito a declaração do Array para armazenar o resultado do jogo dos dois players (vale lembra que o uso só foi feito por achar melhor manter 1 item guardando o resultado de escolha do que múltiplos).

Dentro da função de click, há todo o tratamento para a mudança de estado da aplicação, dentro dessa mudança foi efetuado a captura da escolha das jogadas.

<img>

Foi feito a mesma coisa na função de Random, que está sendo usada para escolher a opção da máquina.

<img>

Fazendo um contexto que o Cleverson normalmente usa e converter logica em números para melhor percepção, essa aplicação foi verificado um pequeno padrão onde foi utilizado para a construção do resultado dos jogos, isso é:

<img>

Olhando a imagem acima notara que a escolha do resultante esquerdo se correlaciona com o resultante de cima, sendo assim, passando essa imagem para uma matriz:

<img>

Se observar bem, convertendo pedra, papel e tesoura em números 0, 1, 2, podemos andar na matriz com as escolhas de cada jogador, isso é:

```
	Player1, escolhe Papel.
	Converto o resultado do Player1 para o número 1.
	Player2, escolhe Tesoura
	Converto o resultado do Player2 para o número 2.
```

    Ando na matriz com o número de escolha deles:

```
	Resultado[Player1][Player2]
	Que é equivalente a Lose (perder).
```

<img>

Para melhor exibição, foi colocado uma caixa de mensagem (Toast) para exibir o resultado do jogo.

<img>

## Biographia

<a href="https://erickfraga.github.io/JO-KEN-PO/">erickfraga<a>
<a href="https://www.passadefase.com/guia-de-conhecimento-gamer-alex-kidd-in-miracle-world"/>passadefase<a>
<a href="https://www.gratispng.com">gratispng<a>

## Creditos:

<a href="https://github.com/iSherlott">Cleverson Silva<a>
<a href="https://github.com/Gabrie2121">Gabriel Miranda<a>
<a href="https://github.com/Carlos3108">Carlos Silva<a>
