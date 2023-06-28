package src;

import java.util.List;

public class GameWord {
  // public LetterList getCharList(String str) {
  // LetterList letterList = new LetterList();
  // List<Character> letters = letterList.initList();
  // for (int i = 0; i < str.length(); i++) {
  // Boolean isCharInStrArr = letterList.checkListForChar(letters, str.charAt(i));
  // if (!isCharInStrArr && str.charAt(i) != ' ') {
  // letterList.addArrChar(letters, str.charAt(i));
  // }
  // }
  // return letterList;
  // }
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

  // public String getGameClue(List<Character> guesses, String gameString) {
  // String gameCard = "";
  // for (int i = 0; i < gameString.length(); i++) {
  // if (guesses.contains(gameString.charAt(i)) || gameString.charAt(i) == ' ') {
  // gameCard += gameString.charAt(i);
  // } else {
  // gameString += "_";
  // }
  // }
  // return gameCard;
  // }
}
