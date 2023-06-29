import java.util.List;
import java.util.Scanner;

import src.GameList;
import src.GameWord;
import src.LetterList;

public class Main {
  public static void main(String[] args) {
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
        " |/\\\n" +
        "-----";

    GameList gameList = new GameList();
    List<String> wordList = gameList.initList();
    List<String> gameCards = gameList.initList();
    gameList.addArrStr(wordList, "full moon");
    gameList.addArrStr(wordList, "silver bullet");
    gameList.addArrStr(wordList, "creepy doll");
    gameList.addArrStr(wordList, "haunted mansion");
    gameList.addArrStr(wordList, "ghost stories");
    gameList.addArrStr(wordList, "spooky scary skeletons");
    gameList.addArrStr(wordList, "chills and thrills");
    gameList.addArrStr(gameCards, gameCard0);
    gameList.addArrStr(gameCards, gameCard1);
    gameList.addArrStr(gameCards, gameCard2);
    gameList.addArrStr(gameCards, gameCard3);
    gameList.addArrStr(gameCards, gameCard4);
    gameList.addArrStr(gameCards, gameCard5);
    gameList.addArrStr(gameCards, gameCard6);
    gameList.addArrStr(gameCards, gameCard7);

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
    System.out.println(gameCard0);
    while (correctGuesses.size() < letters.size()) {
      if (wrongCounter == 7) {
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
      String currentGameCard = gameList.getArrStr(gameCards, wrongCounter);
      System.out.println(currentGameCard);
      System.out.println("Hint: " + hints);
    }

    scanner.close();
  }
}