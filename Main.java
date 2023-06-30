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
      // Boolean isCharInStrArr = gameSystem.checkGuess(letters, guess);
      int guessRes = gameSystem.processUserGuess(guesses, letters, guess);
      if (guessRes == 1) {
        rightCharCounter++;
        guessList.addArrChar(guesses, guess);
        correctGuessList.addArrChar(correctGuesses, guess);
      } else if (guessRes == 0) {
        System.out.println("You have already guessed this letter.");
        System.out.print("Press enter key to continue.");
        scanner.nextLine();
      } else {
        guessList.addArrChar(guesses, guess);
        wrongCharCounter++;
      }
      gameSystem.printGameScreen(correctGuesses, guesses, word, wrongCharCounter);
    }
    scanner.close();
  }
}