# RPG de Combate com Padrão Strategy em Java

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Design Pattern](https://img.shields.io/badge/Pattern-Strategy-blue?style=for-the-badge)

## 📜 Descrição

Este projeto é uma implementação de um sistema de combate por turnos para um RPG medieval, desenvolvido em Java. O objetivo principal foi aplicar o padrão de projeto comportamental **Strategy** para criar um sistema flexível e extensível, onde as armas equipadas pelos personagens definem suas estratégias de ataque.

O sistema permite que diferentes classes de personagens (Guerreiro, Arqueiro, Mago) utilizem variados tipos de armas, cada uma com dano, custo de mana, requisitos e efeitos especiais únicos.

## ✨ Funcionalidades Implementadas

-   **Padrão de Projeto Strategy**: A lógica de ataque é desacoplada do personagem e encapsulada em diferentes classes de `Arma`, permitindo a troca dinâmica de "estratégias".
-   **Sistema de Personagens**: Classes distintas como `Guerreiro`, `Arqueiro`, `Mago` e `Paladino`, cada uma com atributos e habilidades passivas únicas.
-   **Sistema de Armas e Efeitos**: 5 tipos de armas implementadas (`Espada Longa`, `Machado de Guerra`, `Arco Élfico`, `Adaga Sombria`, `Cajado Arcano`), cada uma com efeitos especiais como sangramento, atordoamento e dano extra.
-   **Sistema de Status**: Efeitos como `Sangramento`, `Queimadura` e `Atordoado` que afetam os personagens ao longo dos turnos.
-   **Gerenciador de Batalha**: Uma classe `Batalha` que orquestra o combate por turnos, aplicando efeitos, gerenciando ações e declarando o vencedor.
-   **Extensões Implementadas**:
    -   ✅ **Dano Crítico**: Sistema de acerto crítico que aumenta o dano de forma aleatória.
    -   ✅ **Troca de Armas em Combate**: Os personagens possuem um inventário e podem trocar de arma durante a batalha.
    -   ✅ **Classe Híbrida**: Inclusão do `Paladino`, um personagem que mistura atributos de Força e Inteligência.

## 📐 Padrão de Projeto Aplicado: Strategy

O padrão **Strategy** foi o núcleo deste projeto.

-   **Context (`Personagem`)**: A classe que utiliza uma estratégia. Possui uma referência para a interface `Arma`.
-   **Strategy (`Arma`)**: A interface que define o método comum (`atacar`) que todas as estratégias devem implementar.
-   **Concrete Strategies (`EspadaLonga`, `CajadoArcano`, etc.)**: As classes que implementam a interface `Arma`, cada uma com seu próprio algoritmo de ataque.

Isso permite que o comportamento de `atacar` de um `Personagem` mude simplesmente ao equipar uma nova `Arma`, sem alterar nenhuma linha de código da classe `Personagem`.

## 📁 Estrutura do Projeto

```
rpg.medieval/
├── .gitignore
└── rpg/
    ├── combate/
    │   ├── Arma.java
    │   ├── Personagem.java
    │   ├── StatusEffect.java
    │   ├── Guerreiro.java
    │   ├── Mago.java
    │   ├── Paladino.java
    │   ├── ... (e todos os outros arquivos de lógica)
    │
    └── main/
        └── Main.java
```

## 🚀 Como Executar

### 1. Via IDE (VS Code, Eclipse, IntelliJ)
1.  Abra a pasta raiz do projeto (`rpg.medieval`) na sua IDE.
2.  Navegue até o arquivo `rpg/main/Main.java`.
3.  Clique no botão "Run" que aparece acima do método `main`.
4.  O resultado da batalha será exibido no console da IDE.

### 2. Via Linha de Comando
1.  Abra um terminal ou prompt de comando na pasta raiz do projeto (`rpg.medieval`).
2.  Compile todos os arquivos `.java`:
    ```sh
    javac -d . rpg/combate/*.java rpg/main/*.java
    ```
3.  Execute a classe principal:
    ```sh
    java rpg.main.Main
    ```

## 🎬 Exemplo de Saída

```
--- EQUIPANDO E PREPARANDO PERSONAGENS ---
Uther, o Arauto da Luz equipou Espada Longa!
Cajado Arcano foi adicionada ao inventário de Uther, o Arauto da Luz.
Ryze, o Mago Rúnico equipou Cajado Arcano!
-----------------------------------------

### BATALHA DE TESTE: PALADINO VS MAGO ###
====== A BATALHA COMEÇOU! ======
Uther, o Arauto da Luz VS Ryze, o Mago Rúnico

======== TURNO 1 ========
[Uther, o Arauto da Luz] Vida: 100/100 | Mana: 80/80 | Efeitos: Nenhum
[Ryze, o Mago Rúnico] Vida: 70/70 | Mana: 150/150 | Efeitos: Nenhum
** Início do turno de Uther, o Arauto da Luz: Aplicando efeitos... **
--- Turno de Uther, o Arauto da Luz ---
Uther, o Arauto da Luz ataca Ryze, o Mago Rúnico com a Espada Longa!
Ryze, o Mago Rúnico recebeu 15 de dano! Vida restante: 55

... (a batalha continua) ...

====== FIM DA BATALHA! ======
O vencedor é Uther, o Arauto da Luz!
```
