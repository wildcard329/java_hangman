package src.operator;

import java.util.List;

import src.constants.Constants;
// import src.lists.CharList;
// import src.lists.StrList;
import src.lists.GameList;

public class GameSystem {
  public boolean checkGameOver(int amountCorrect, int amountTotal, int amountIncorrect) {
    if (amountCorrect == amountTotal) {
      System.out.println(Constants.winGame);
      return true;
    } else if (amountIncorrect == 6) {
      System.out.println(Constants.loseGame);
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
    String outputStr = Constants.attempsSubStr;
    for (int i = 0; i < arrSize; i++) {
      Character arrChar = chars.get(i);
      if (i == arrSize - 1) {
        outputStr += arrChar.toString() + Constants.spaceChar;
      } else {
        outputStr += arrChar.toString() + Constants.commaSeparator;
      }
    }
    return outputStr;
  }

  public String getGameCard(int wrongCounter) {
    switch (wrongCounter) {
      case 0:
        return Constants.gameCard0;
      case 1:
        return Constants.gameCard1;
      case 2:
        return Constants.gameCard2;
      case 3:
        return Constants.gameCard3;
      case 4:
        return Constants.gameCard4;
      case 5:
        return Constants.gameCard5;
      case 6:
        return Constants.gameCard6;
      default:
        return Constants.invalidCounter;
    }
  }

  public String getGameClue(List<Character> guesses, String answer) {
    String gameCard = Constants.emptyString;
    for (int i = 0; i < answer.length(); i++) {
      if (guesses.contains(answer.charAt(i)) || answer.charAt(i) == Constants.spaceChar) {
        gameCard += answer.charAt(i);
      } else {
        gameCard += Constants.mysteryChar;
      }
    }
    return gameCard;
  }

  public List<Character> getGameWordChars(String gameWord) {
    GameList letterList = new GameList();
    List<Character> letters = letterList.charsArr;
    for (int i = 0; i < gameWord.length(); i++) {
      Character currentChar = gameWord.charAt(i);
      Boolean isCharInStrArr = letterList.checkListForChar(currentChar);
      if (!isCharInStrArr && currentChar != Constants.spaceChar) {
        letterList.addArrChar(currentChar);
      }
    }
    return letters;
  }

  public String initWord() {
    GameList strList = new GameList();
    strList.addArrStr(Constants.gameWord1);
    strList.addArrStr(Constants.gameWord2);
    strList.addArrStr(Constants.gameWord3);
    strList.addArrStr(Constants.gameWord4);
    strList.addArrStr(Constants.gameWord5);
    strList.addArrStr(Constants.gameWord6);
    strList.addArrStr(Constants.gameWord7);
    String word = strList.getRandomArrStr();
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

  public int processUserGuess(List<Character> guesses, List<Character> answers, Character guessChar) {
    int result;
    if (guesses.contains(guessChar)) {
      result = Constants.neutralGuess;
    } else if (answers.contains(guessChar)) {
      result = Constants.confirmGuess;
    } else {
      result = Constants.negateGuess;
    }
    return result;
  }
}
