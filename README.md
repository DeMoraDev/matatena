<h1 align="center">Matatena</h1>

<div align="center">
  <img src="https://github.com/user-attachments/assets/583766e4-d6f3-466f-a9bd-ae06e3e3f9e8" width="200" alt="DoubleIa">
</div>

Matatena is a dice game developed in Android Studio using Java with XML. The game combines elements of strategy and luck.

## Game Overview

The game consists of two 3x3 boards, one for each player. Players take turns playing. At the beginning of a turn, the player rolls a 6-sided die and places it in a position on their board. Each player has a score, which is the sum of all the values of the dice on their board. To play against an opponent, players must wager gold coins. If you lose, you lose the gold; if you win, you earn gold. Each opponent costs more gold to play against.

## Technologies Used

  <img src="https://img.shields.io/badge/Java-007396.svg?style=for-the-badge&logo=java&logoColor=white" alt="Java Badge">
  <img src="https://img.shields.io/badge/XML-FF6600.svg?style=for-the-badge&logo=xml&logoColor=white" alt="XML Badge">


## Game Mechanics

### Multiplication of Points

If a player places multiple dice of the same value in the same column, the score of those dice is multiplied: doubled if there are 2, or tripled if there are 3.

<div align="center">
  <img src="https://github.com/user-attachments/assets/cf843b22-b51b-4182-8820-e1d60bbd5238" width="200" alt="DoubleIa" style="margin: 10px;">
  <img src="https://github.com/user-attachments/assets/d11f1ef4-5053-4852-b1fe-69d1cff1fe9c" width="200" alt="TriplePlayer" style="margin: 10px;">
</div>

### Elimination of Enemy Dice

When a player places a die, all dice of the same value in the corresponding column on the opponent's board are destroyed.

<div align="center">
  <img src="https://github.com/user-attachments/assets/d8f32bea-0137-4148-ae91-53a04e066a71" width="200" alt="TriplePlayer" style="margin: 10px;">
</div>

## Design

<div align="center">
  <table>
    <tr>
      <td align="center">
        <h3>Main Menu</h3>
        <img src="https://github.com/user-attachments/assets/71d87de4-a48c-4ff4-a45c-160cdee931a8" width="200" alt="Main Menu">
      </td>
      <td align="center">
        <h3>Opponent Selection</h3>
        <img src="https://github.com/user-attachments/assets/a73fb041-a961-4fdd-ad29-63aa60c7eb5b" width="200" alt="Opponent Selection">
      </td>
      <td align="center">
        <h3>Game Screen</h3>
        <img src="https://github.com/user-attachments/assets/4d1891c7-2cc0-4ee0-9895-a5d67837fffa" width="200" alt="Game Screen">
      </td>
    </tr>
  </table>
</div>

## Enemies
Each AI difficulty is represented by a different enemy. There are 3 at the moment (They're literally my sister's cats):

<div align="center">
  <table>
    <tr>
      <td align="center">
        <h3>Vaquito</h3>
        <img src="https://github.com/user-attachments/assets/d7dbfa44-df73-4507-9bef-bfc32e070802" width="200" alt="Boss Vaquito">
      </td>
      <td align="center">
        <h3>Sally</h3>
        <img src="https://github.com/user-attachments/assets/b00a2b9e-f6e3-4039-9115-23cf1ee3f62b" width="200" alt="Boss Sally">
      </td>
      <td align="center">
        <h3>Pi</h3>
        <img src="https://github.com/user-attachments/assets/67cb0194-dfd0-4f0f-85d4-2c17308bd77e" width="200" alt="Boss Pi">
      </td>
    </tr>
  </table>
</div>

## Implementation of Game Logic

### Score Counter

Each column has a score according to the dice it contains, and the total score is the sum of the scores of the 3 columns.

<div align="center">
  <img src="https://github.com/user-attachments/assets/3b6e1b70-069f-4813-893f-9c2be299c629" width="200" alt="Score Counter" style="margin: 10px;">
</div>

## AI Integration

Depending on the difficulty level, the AI selects a position on the board:

- **Difficulty 0:** Selects a random position.
- **Difficulty 1:** Tries to eliminate enemy dice, multiply its own dice, or, failing that, selects a random position.
- **Difficulty 2:** Decides to eliminate enemy dice or multiply its own dice, depending on which is more advantageous.

This is achieved through auxiliary methods that help each difficulty level achieve its objectives. These methods iterate through the array to perform a task and return it to the AI for decision-making based on the difficulty level.

### IA's Auxiliary Methods

- Returns a valid empty position on the board.
- Searches for dice to multiply on its own board.
- Searches for enemy dice to eliminate on the opponent's board.
