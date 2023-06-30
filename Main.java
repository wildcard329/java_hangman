import java.util.List;
import java.util.Scanner;

import src.constants.GameStrings;
import src.lists.CharList;
import src.operator.GameSystem;

public class Main {
  public static void main(String[] args) {
    GameSystem gameSystem = new GameSystem();
    GameStrings gStrings = new GameStrings();
    CharList guessList = new CharList();
    CharList correctGuessList = new CharList();
    Scanner scanner = new Scanner(System.in);

    String word = gameSystem.initWord();
    List<Character> letters = gameSystem.getGameWordChars(word);
    List<Character> guesses = guessList.initList();
    List<Character> correctGuesses = correctGuessList.initList();
    int wrongCharCounter = 0;
    int rightCharCounter = 0;
    int totalCharCounter = letters.size();
    gameSystem.printGameScreen(correctGuesses, guesses, word, wrongCharCounter);

    while (!gameSystem.checkGameOver(rightCharCounter, totalCharCounter, wrongCharCounter)) {
      System.out.print(gStrings.inputPrompt);
      String guessInput = scanner.nextLine();
      Character guess = guessInput.charAt(0);
      Boolean isCharInStrArr = gameSystem.checkGuess(letters, guess);
      guessList.addArrChar(guesses, guess);
      if (isCharInStrArr) {
        rightCharCounter++;
        correctGuessList.addArrChar(correctGuesses, guess);
      } else {
        wrongCharCounter++;
      }
      gameSystem.printGameScreen(correctGuesses, guesses, word, wrongCharCounter);
    }
    scanner.close();
  }
}