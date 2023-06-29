import java.util.List;
import java.util.Scanner;

import src.GameOperation;
import src.constants.GameStrings;
import src.lists.CharList;
import src.lists.StrList;

public class Main {
  public static void main(String[] args) {
    GameOperation game = new GameOperation();
    StrList strList = new StrList();
    GameStrings gStrings = new GameStrings();
    CharList letterList = new CharList();
    List<String> wordList = strList.initList();
    List<Character> letters = letterList.initList();
    strList.addArrStr(wordList, gStrings.gameWord1);
    strList.addArrStr(wordList, gStrings.gameWord2);
    strList.addArrStr(wordList, gStrings.gameWord3);
    strList.addArrStr(wordList, gStrings.gameWord4);
    strList.addArrStr(wordList, gStrings.gameWord5);
    strList.addArrStr(wordList, gStrings.gameWord6);
    strList.addArrStr(wordList, gStrings.gameWord7);
    String word = strList.getRandomArrStr(wordList);

    for (int i = 0; i < word.length(); i++) {
      Boolean isCharInStrArr = letterList.checkListForChar(letters, word.charAt(i));
      if (!isCharInStrArr && word.charAt(i) != ' ') {
        letterList.addArrChar(letters, word.charAt(i));
      }
    }

    CharList guessList = new CharList();
    CharList correctGuessList = new CharList();
    List<Character> guesses = guessList.initList();
    List<Character> correctGuesses = correctGuessList.initList();
    Scanner scanner = new Scanner(System.in);
    int wrongCounter = 0;
    game.printGameScreen(correctGuesses, word, wrongCounter);
    while (!game.checkGameOver(correctGuesses.size(), letters.size(), wrongCounter)) {
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
    scanner.close();
  }
}