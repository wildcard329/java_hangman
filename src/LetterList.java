package src;

import java.util.ArrayList;
import java.util.List;

public class LetterList {
  public List<Character> initList() {
    return new ArrayList<>();
  }

  public void addArrChar(List<Character> arr, Character character) {
    arr.add(0, character);
  }

  public boolean checkListForChar(List<Character> arr, Character character) {
    return arr.contains(character);
  }

  public int getCharListLen(List<Character> arr) {
    return arr.size();
  }
}
