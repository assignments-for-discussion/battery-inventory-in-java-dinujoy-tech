package bunchbysoh;
import java.util.*;

public class Main {
  static class CountsBySoH {
    public int healthy = 0;
    public int exchange = 0;
    public int failed = 0;
  };

  static CountsBySoH countBatteriesByHealth(int[] presentCapacities) {
    
    CountsBySoH counts = new CountsBySoH();
    Scanner sc=new Scanner(System.in);
    int rated_capacity=sc.nextInt();
    for(int i=0;i<presentCapacities.length;i++){
      float SoH=0;
      SoH=100*presentCapacities[i]/rated_capacity;
      if(SoH>80 && SoH<=100)
        healthy++; //if SoH is between 80% and 100% increment count of healthy
      else if(SoH>62 && SoH<=80)
        exchange++; //if SoH is between 62% and 80% increment count of exchange
      else
        failed++; //increment count of failed if it is less than 62%
    }
    
    return counts;
  }

  static void testBucketingByHealth() {
    System.out.println("Counting batteries by SoH...\n");
    int[] presentCapacities = {113, 116, 80, 95, 92, 70};
    CountsBySoH counts = countBatteriesByHealth(presentCapacities);
    assert(counts.healthy == 2);
    assert(counts.exchange == 3);
    assert(counts.failed == 1);
    System.out.println("Done counting :)\n");
  }

  public static void main(String[] args) {
    testBucketingByHealth();
  }
}
