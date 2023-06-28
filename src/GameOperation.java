package src;

import java.util.List;

public class GameOperation {
  // public List<String> generateGameWords() {

  // }
  public boolean checkGuess(List<Character> answers, Character guess) {
    return answers.contains(guess);
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
}
