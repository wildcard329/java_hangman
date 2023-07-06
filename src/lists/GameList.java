package src.lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameList {
  public List<Character> charsArr = new ArrayList<>();
  public List<String> strArr = new ArrayList<>();

  public void addArrChar(Character character) {
    this.charsArr.add(0, character);
  }

  public boolean checkListForChar(Character character) {
    return this.charsArr.contains(character);
  }

  public void addArrStr(String str) {
    this.strArr.add(str);
  }

  public String getArrStr(int itemIndex) {
    return this.strArr.get(itemIndex);
  }

  public String getRandomArrStr() {
    Random random = new Random();
    int randomIndex = random.nextInt(this.strArr.size());
    String randomString = getArrStr(randomIndex);
    return randomString;
  }
}
