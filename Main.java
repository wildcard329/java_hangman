import java.util.List;
import java.util.Scanner;

import src.constants.GameStrings;
import src.lists.CharList;
import src.operator.GameSystem;

public class Main {
  public static void main(String[] args) {
    GameSystem gameSystem = new GameSystem();
    GameStrings gStrings = new GameStrings();
    String word = gameSystem.initWord();

    List<Character> letters = gameSystem.getGameWordChars(word);

    CharList guessList = new CharList();
    CharList correctGuessList = new CharList();
    List<Character> guesses = guessList.initList();
    List<Character> correctGuesses = correctGuessList.initList();
    Scanner scanner = new Scanner(System.in);
    int wrongCounter = 0;
    gameSystem.printGameScreen(correctGuesses, word, wrongCounter);
    while (!gameSystem.checkGameOver(correctGuesses.size(), letters.size(), wrongCounter)) {
      System.out.print(gStrings.inputPrompt);
      String guessInput = scanner.nextLine();
      Character guess = guessInput.charAt(0);
      Boolean isCharInStrArr = gameSystem.checkGuess(letters, guess);
      guessList.addArrChar(guesses, guess);
      if (isCharInStrArr) {
        correctGuessList.addArrChar(correctGuesses, guess);
      } else {
        wrongCounter++;
      }
      gameSystem.printGameScreen(correctGuesses, word, wrongCounter);
    }
    scanner.close();
  }
}