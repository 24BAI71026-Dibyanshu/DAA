import java.util.*;
public class Knapscak_algo{
  public static void main(String[] args) {

    int[] V = {60,100,120};   //values 
    int[] W = {10,20,30};  //weight 

    float total =0;
    float[] ratio = new float[3];
    Integer[] index = new Integer[3];

    for(int i=0; i<3; i++){
      ratio[i] =(float)V[i]/W[i];
      index[i] =i;
    }

    Arrays.sort(index , (i,j) -> Float.compare(ratio[j], ratio[i]));

    float capacity = 50;
    float profit =0;

    for (int i=0; i<3; i++){
      int idx = index[i];

      if (capacity>=W[idx]){
        capacity-=W[idx];
        profit+=V[idx];
      }else {
        profit+=ratio[idx]*capacity;
        break;
      }
    }
   System.out.println("Maximun profit =" + profit);
  }
}
