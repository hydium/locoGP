package locoGP.problems;
public class Sort1Loops1Problem203 {
  public static Integer[] sort(  Integer[] a,  Integer length){
    for (int h=1; h > 0; h--) {
      for (int i=0; i < length; i++) {
        for (int j=0; j < length - 1; j++) {
          if (a[j] > a[j + 1]) {
            int k=a[j];
            a[j]=a[j + 1];
            a[j + 1]=k;
          }
        }
      }
    }
    return a;
  }
}

