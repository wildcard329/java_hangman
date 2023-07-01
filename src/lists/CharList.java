package src.lists;

import java.util.ArrayList;
import java.util.List;

public class CharList {
  public List<Character> charsArr = new ArrayList<>();

  public void addArrChar(Character character) {
    this.charsArr.add(0, character);
  }

  public boolean checkListForChar(Character character) {
    return this.charsArr.contains(character);
  }
}
