# Tic Tac Toe 
This repository contains a simple implementation of the Tic Tac Toe game in Java. The game supports various player types, including Human, Clever, Whatever, and Genius players. You can customize the board size, win streak, and rendering options.

![Tic Tac Toe](https://github.com/libbyyosef/Tic-Tac-Toe/assets/36642026/d0a5ebf5-8bf9-4c81-8eba-b179b47e1395)


**Table of Contents**
- Classes
- How to Play
- Player Strategies
- Tournament
- Build and Run

**Classes**

**'Board'**

The Board class represents the game board. It supports different board sizes and allows players to make moves by placing their marks (X or O) on the board.

**'CleverPlayer'**

The CleverPlayer class represents a player with a clever strategy. The player attempts to fill the board row by row, moving to the next row if the current one is already filled. If the end of the board is reached, it wraps around and continues.

**'ConsoleRenderer'**

The ConsoleRenderer class is responsible for rendering the game board in the console. It displays the current state of the board after each move.

**'Game'**

The Game class orchestrates the Tic Tac Toe game. It manages player turns, checks for a winner or a tie, and updates the game state accordingly.

**'GeniusPlayer'**

The GeniusPlayer class represents a player with a genius strategy. The player attempts to fill the columns of the board, moving to the next column if the current one is already filled. If the end of the board is reached, it wraps around and continues.

**'HumanPlayer'**

The HumanPlayer class allows a human player to interact with the game. It prompts the player to input the desired coordinates for their move.

**'Mark'**

The Mark enum represents the possible marks on the Tic Tac Toe board: BLANK, X, and O.

**'Player'**

The Player interface defines the contract for different player types. Players must implement the playTurn method to make moves on the board.

**'PlayerFactory'**

The PlayerFactory class is responsible for creating instances of different player types based on input strings.

**'Renderer'**

The Renderer interface defines the contract for different rendering strategies. Renderers must implement the renderBoard method to display the current state of the game board.

**'RendererFactory'**

The RendererFactory class is responsible for creating instances of different renderer types based on input strings.

**'Tournament'**

The Tournament class allows players to compete in a series of Tic Tac Toe games. It keeps track of the number of wins and ties for each player throughout the tournament.

**'VoidRenderer'**

The VoidRenderer class implements a rendering strategy that does not display the game board. Useful for running simulations without a visual interface.

**'WhateverPlayer'**

The WhateverPlayer class represents a player with a "whatever" strategy. The player makes random moves on the board until a valid move is found.

**'How to Play'**

To play the game, you can run the Tournament class with the appropriate command-line arguments. The arguments specify the number of rounds, board size, win streak, renderer type, and player types for Player 1 and Player 2.

Example command:
*java Tournament 5 3 3 console Human Clever*
This command runs a tournament of 5 rounds on a 3x3 board with a win streak of 3. The game will be rendered in the console, and Player 1 is a Human player, while Player 2 is a Clever player.

**Player Strategies**
- **Human Player:** Asks the user to input coordinates for their move.
- **Clever Player:** Tries to fill the board row by row, moving to the next row if the current one is already filled.
- **Genius Player:** Tries to fill the columns of the board, moving to the next column if the current one is already filled.
- **Whatever Player:** Makes random moves on the board until a valid move is found.

**Tournament**

The Tournament class allows players to compete in a series of rounds. After each round, it displays the current standings, including the number of wins for each player and the number of ties.

**Build and Run**

To build and run the Tic Tac Toe game, you can use the following commands:
- Compile the Java files:  javac *.java
- Run the Tournament class with command-line arguments:                                    
java Tournament rounds boardSize winStreak renderer player1 player2
(Replace rounds, boardSize, winStreak, renderer, player1 and player2 with your desired values).

Enjoy playing Tic Tac Toe!






