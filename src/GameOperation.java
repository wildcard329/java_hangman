package src;

import java.util.List;

import src.constants.GameStrings;

public class GameOperation {
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

  public void printGameScreen(List<Character> guesses, String answer, int incorrectCount) {
    String gameCard = getGameCard(incorrectCount);
    String gameHint = getGameClue(guesses, answer);
    System.out.println(gameCard);
    System.out.println(gameHint);
  }
}
