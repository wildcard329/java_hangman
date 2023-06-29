package src;

import java.util.List;

public class GameOperation {
  // public List<String> generateGameWords() {

  // }
  public boolean checkGuess(List<Character> answers, Character guess) {
    return answers.contains(guess);
  }

  public String getGameCard(int wrongCounter) {
    String gameCard;
    String gameCard0 = "HANGMAN\n" +
        "  _  \n" +
        " | | \n" +
        " |   \n" +
        " |   \n" +
        " |   \n" +
        "-----";
    String gameCard1 = "HANGMAN\n" +
        "  _  \n" +
        " | | \n" +
        " | O \n" +
        " |   \n" +
        " |   \n" +
        "-----";
    String gameCard2 = "HANGMAN\n" +
        "  _  \n" +
        " | | \n" +
        " | O \n" +
        " | | \n" +
        " |   \n" +
        "-----";
    String gameCard3 = "HANGMAN\n" +
        "  _  \n" +
        " | | \n" +
        " | O \n" +
        " |/| \n" +
        " |   \n" +
        "-----";
    String gameCard4 = "HANGMAN\n" +
        "  _  \n" +
        " | | \n" +
        " | O \n" +
        " |/|\\\n" +
        " |   \n " +
        "-----";
    String gameCard5 = "HANGMAN\n" +
        "  _  \n" +
        " | | \n" +
        " | O \n" +
        " |/|\\\n" +
        " |   \n" +
        "-----";
    String gameCard6 = "HANGMAN\n" +
        "  _  \n" +
        " | | \n" +
        " | O \n" +
        " |/|\\\n" +
        " |/  \n " +
        "-----";
    String gameCard7 = "HANGMAN\n" +
        "  _  \n" +
        " | | \n" +
        " | O \n" +
        " |/|\\\n" +
        " |/ \\\n" +
        "-----";
    switch (wrongCounter) {
      case 0:
        gameCard = gameCard0;
        break;
      case 1:
        gameCard = gameCard1;
        break;
      case 2:
        gameCard = gameCard2;
        break;
      case 3:
        gameCard = gameCard3;
        break;
      case 4:
        gameCard = gameCard4;
        break;
      case 5:
        gameCard = gameCard5;
        break;
      case 6:
        gameCard = gameCard6;
        break;
      case 7:
        gameCard = gameCard7;
        break;
      default:
        gameCard = gameCard0;
    }
    return gameCard;
  }

  public String getGameClue(List<Character> guesses, String gameString) {
    String gameCard = "";
    for (int i = 0; i < gameString.length(); i++) {
      if (guesses.contains(gameString.charAt(i)) || gameString.charAt(i) == ' ') {
        gameCard += gameString.charAt(i);
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
