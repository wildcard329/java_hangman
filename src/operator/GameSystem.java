package src.operator;

import java.util.List;

import src.constants.GameStrings;
import src.lists.CharList;
import src.lists.StrList;

public class GameSystem {
  public boolean checkGameOver(int amountCorrect, int amountTotal, int amountIncorrect) {
    GameStrings gStrings = new GameStrings();
    if (amountCorrect == amountTotal) {
      System.out.println(gStrings.winGame);
      return true;
    } else if (amountIncorrect == 6) {
      System.out.println(gStrings.loseGame);
      return true;
    } else {
      return false;
    }
  }

  public boolean checkGuess(List<Character> answers, Character guess) {
    return answers.contains(guess);
  }

  public String formatCharArrayToString(List<Character> chars) {
    int arrSize = chars.size();
    String outputStr = "attempts: ";
    for (int i = 0; i < arrSize; i++) {
      Character arrChar = chars.get(i);
      if (i == arrSize - 1) {
        outputStr += arrChar.toString() + ' ';
      } else {
        outputStr += arrChar.toString() + ", ";
      }
    }
    return outputStr;
  }

  public String getGameCard(int wrongCounter) {
    GameStrings gStrings = new GameStrings();
    switch (wrongCounter) {
      case 0:
        return gStrings.gameCard0;
      case 1:
        return gStrings.gameCard1;
      case 2:
        return gStrings.gameCard2;
      case 3:
        return gStrings.gameCard3;
      case 4:
        return gStrings.gameCard4;
      case 5:
        return gStrings.gameCard5;
      case 6:
        return gStrings.gameCard6;
      default:
        return gStrings.invalidCounter;
    }
  }

  public String getGameClue(List<Character> guesses, String answer) {
    GameStrings gStrings = new GameStrings();
    String gameCard = gStrings.emptyString;
    for (int i = 0; i < answer.length(); i++) {
      if (guesses.contains(answer.charAt(i)) || answer.charAt(i) == ' ') {
        gameCard += answer.charAt(i);
      } else {
        gameCard += gStrings.mysteryChar;
      }
    }
    return gameCard;
  }

  public List<Character> getGameWordChars(String gameWord) {
    CharList letterList = new CharList();
    List<Character> letters = letterList.initList();
    for (int i = 0; i < gameWord.length(); i++) {
      Character currentChar = gameWord.charAt(i);
      Boolean isCharInStrArr = letterList.checkListForChar(letters, currentChar);
      if (!isCharInStrArr && currentChar != ' ') {
        letterList.addArrChar(letters, currentChar);
      }
    }
    return letters;
  }

  public String initWord() {
    StrList strList = new StrList();
    GameStrings gStrings = new GameStrings();
    List<String> wordList = strList.initList();
    strList.addArrStr(wordList, gStrings.gameWord1);
    strList.addArrStr(wordList, gStrings.gameWord2);
    strList.addArrStr(wordList, gStrings.gameWord3);
    strList.addArrStr(wordList, gStrings.gameWord4);
    strList.addArrStr(wordList, gStrings.gameWord5);
    strList.addArrStr(wordList, gStrings.gameWord6);
    strList.addArrStr(wordList, gStrings.gameWord7);
    String word = strList.getRandomArrStr(wordList);
    return word;
  }

  public void printGameScreen(List<Character> correctGuesses, List<Character> guesses, String answer,
      int incorrectCount) {
    String gameCard = getGameCard(incorrectCount);
    String userGuesses = formatCharArrayToString(guesses);
    String gameHint = getGameClue(correctGuesses, answer);
    System.out.println(gameCard);
    System.out.println(userGuesses);
    System.out.println(gameHint);
  }
}
