package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameList {
  public List<String> initList() {
    return new ArrayList<>();
  }

  public void addArrStr(List<String> arr, String item) {
    arr.add(item);
  }

  public String getArrStr(List<String> arr, int itemIndex) {
    return arr.get(itemIndex);
  }

  public String getRandomArrStr(List<String> arr) {
    Random random = new Random();
    int randomIndex = random.nextInt(arr.size());
    String randomString = getArrStr(arr, randomIndex);
    return randomString;
  }

  public void rmArrStr(List<String> arr, String item) {
    arr.remove(item);
  }
}
