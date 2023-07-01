package src.lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StrList {
  public List<String> strArr = new ArrayList<>();

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
