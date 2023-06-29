package src;

import java.util.List;

import src.constants.GameStrings;

public class GameOperation {
  public boolean checkGuess(List<Character> answers, Character guess) {
    return answers.contains(guess);
  }

  public String getGameCard(int wrongCounter) {
    String gameCard;
    GameStrings gStrings = new GameStrings();
    switch (wrongCounter) {
      case 0:
        gameCard = gStrings.gameCard0;
        break;
      case 1:
        gameCard = gStrings.gameCard1;
        break;
      case 2:
        gameCard = gStrings.gameCard2;
        break;
      case 3:
        gameCard = gStrings.gameCard3;
        break;
      case 4:
        gameCard = gStrings.gameCard4;
        break;
      case 5:
        gameCard = gStrings.gameCard5;
        break;
      case 6:
        gameCard = gStrings.gameCard6;
        break;
      default:
        gameCard = gStrings.gameCard0;
    }
    return gameCard;
  }

  public String getGameClue(List<Character> guesses, String answer) {
    String gameCard = "";
    for (int i = 0; i < answer.length(); i++) {
      if (guesses.contains(answer.charAt(i)) || answer.charAt(i) == ' ') {
        gameCard += answer.charAt(i);
      } else {
        gameCard += "_";
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
