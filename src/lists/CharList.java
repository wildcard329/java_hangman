package src.lists;

import java.util.ArrayList;
import java.util.List;

public class CharList {
  public List<Character> initList() {
    return new ArrayList<>();
  }

  public void addArrChar(List<Character> arr, Character character) {
    arr.add(0, character);
  }

  public boolean checkListForChar(List<Character> arr, Character character) {
    return arr.contains(character);
  }
}
