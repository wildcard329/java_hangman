import java.util.List;
import java.util.Scanner;

import src.GameList;
import src.GameWord;
import src.LetterList;

public class Main {
  public static void main(String[] args) {
    GameList gameList = new GameList();
    List<String> wordList = gameList.initList();
    gameList.addArrStr(wordList, "full moon");
    gameList.addArrStr(wordList, "silver bullet");
    gameList.addArrStr(wordList, "creepy doll");
    gameList.addArrStr(wordList, "haunted mansion");
    gameList.addArrStr(wordList, "ghost stories");
    gameList.addArrStr(wordList, "spooky scary skeletons");
    gameList.addArrStr(wordList, "chills and thrills");
    String word = gameList.getRandomArrStr(wordList);

    LetterList letterList = new LetterList();
    List<Character> letters = letterList.initList();
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
    GameWord gameWord = new GameWord();
    Scanner scanner = new Scanner(System.in);
    int wrongCounter = 0;
    // String hints = gameWord.getGameClue(correctGuesses, word);
    while (correctGuesses.size() < letters.size()) {
      if (wrongCounter == 6) {
        System.out.println("Sorry, you lose. Good game.");
        break;
      }
      System.out.print("Guess a letter");
      String guessInput = scanner.nextLine();
      Character guess = guessInput.charAt(0);
      Boolean isCharInStrArr = letterList.checkListForChar(letters, guess);
      guessList.addArrChar(guesses, guess);
      if (isCharInStrArr) {
        correctGuessList.addArrChar(correctGuesses, guess);
      } else {
        wrongCounter++;
      }
      String hints = gameWord.getGameClue(correctGuesses, word);
      System.out.println("Hint: " + hints);
    }

    scanner.close();
    // System.out.println(letters);
  }
}