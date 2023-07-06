import java.util.List;
import java.util.Scanner;

import src.constants.Constants;
import src.lists.CharList;
import src.operator.GameSystem;

public class Main {
  public static void main(String[] args) {
    GameSystem gameSystem = new GameSystem();
    CharList guessList = new CharList();
    CharList correctGuessList = new CharList();
    Scanner scanner = new Scanner(System.in);

    String word = gameSystem.initWord();
    List<Character> letters = gameSystem.getGameWordChars(word);
    List<Character> guesses = guessList.charsArr;
    List<Character> correctGuesses = correctGuessList.charsArr;
    int wrongCharCounter = 0;
    int rightCharCounter = 0;
    int totalCharCounter = letters.size();
    gameSystem.printGameScreen(correctGuesses, guesses, word, wrongCharCounter);

    while (!gameSystem.checkGameOver(rightCharCounter, totalCharCounter, wrongCharCounter)) {
      System.out.print(Constants.inputPrompt);
      String guessInput = scanner.nextLine();
      Character guess = guessInput.charAt(0);
      int guessRes = gameSystem.processUserGuess(guesses, letters, guess);
      if (guessRes == 1) {
        rightCharCounter++;
        guessList.addArrChar(guess);
        correctGuessList.addArrChar(guess);
      } else if (guessRes == 0) {
        System.out.println("You have already guessed this letter.");
        System.out.print("Press enter key to continue.");
        scanner.nextLine();
      } else {
        guessList.addArrChar(guess);
        wrongCharCounter++;
      }
      gameSystem.printGameScreen(correctGuesses, guesses, word, wrongCharCounter);
    }
    scanner.close();
  }
}