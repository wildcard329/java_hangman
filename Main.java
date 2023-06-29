import java.util.List;
import java.util.Scanner;

import src.GameList;
import src.GameOperation;
import src.LetterList;
import src.constants.GameStrings;

public class Main {
  public static void main(String[] args) {
    GameOperation game = new GameOperation();
    GameList gameList = new GameList();
    GameStrings gStrings = new GameStrings();
    LetterList letterList = new LetterList();
    List<String> wordList = gameList.initList();
    List<Character> letters = letterList.initList();
    gameList.addArrStr(wordList, gStrings.gameWord1);
    gameList.addArrStr(wordList, gStrings.gameWord2);
    gameList.addArrStr(wordList, gStrings.gameWord3);
    gameList.addArrStr(wordList, gStrings.gameWord4);
    gameList.addArrStr(wordList, gStrings.gameWord5);
    gameList.addArrStr(wordList, gStrings.gameWord6);
    gameList.addArrStr(wordList, gStrings.gameWord7);
    String word = gameList.getRandomArrStr(wordList);

    for (int i = 0; i < word.length(); i++) {
      Boolean isCharInStrArr = letterList.checkListForChar(letters, word.charAt(i));
      if (!isCharInStrArr && word.charAt(i) != ' ') {
        letterList.addArrChar(letters, word.charAt(i));
      }
    }

    LetterList guessList = new LetterList();
    LetterList correctGuessList = new LetterList();
    List<Character> guesses = guessList.initList();
    List<Character> correctGuesses = correctGuessList.initList();
    Scanner scanner = new Scanner(System.in);
    int wrongCounter = 0;
    game.printGameScreen(correctGuesses, word, wrongCounter);
    while (correctGuesses.size() < letters.size()) {
      if (wrongCounter == 6) {
        System.out.println(gStrings.loseGame);
        break;
      }
      System.out.print(gStrings.inputPrompt);
      String guessInput = scanner.nextLine();
      Character guess = guessInput.charAt(0);
      Boolean isCharInStrArr = letterList.checkListForChar(letters, guess);
      guessList.addArrChar(guesses, guess);
      if (isCharInStrArr) {
        correctGuessList.addArrChar(correctGuesses, guess);
      } else {
        wrongCounter++;
      }
      game.printGameScreen(correctGuesses, word, wrongCounter);
    }
    System.out.println(gStrings.winGame);
    scanner.close();
  }
}