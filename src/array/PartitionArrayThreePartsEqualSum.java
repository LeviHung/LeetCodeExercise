package array;
import java.util.Arrays;

public class PartitionArrayThreePartsEqualSum
{
  public static boolean canThreePartsEqualSum(int[] arr)
  {
    int total = 0;

    for (int val: arr) {
      total += val;
    }
    if (total % 3 != 0) {
      return false;
    }
    total = total / 3;
    int sum = 0;
    int index = 0;
    for (int i = 0; i < arr.length - 2; i++) {
      sum += arr[i];
      if (sum == total) {
        index = i + 1;
        break;
      }
    }
    if (index == 0) {
      return false;
    }
    int prevIndex = index;
    sum = 0;
    for (int i = index; i < arr.length - 1; i++) {
      sum += arr[i];
      if (sum == total) {
        index = i + 1;
        break;
      }
    }
    if (index == prevIndex)
      return false;

    return true; 
  }

  public static boolean canThreePartsEqualSumOpt(int[] arr) 
  {
    int sum=0;
    for(int i:arr){
      sum+=i;
    }
    if(sum%3!=0)return false;
    int k = sum/3;
    sum =0;
    int count=0;
    for(int i=0;i<arr.length;i++){
      sum += arr[i];
      if(sum==k){
        count++;
        sum=0;
      }
    }
    return count>=3?true:false;
  }
  
  public static void readme()
  {
    String str = "Given an array of integers arr, return true if we can partition the array into three non-empty parts with equal sums.\n\n";

    str += "Formally, we can partition the array if we can find indexes i + 1 < j with (arr[0] + arr[1] + ... + arr[i] == arr[i + 1] + arr[i + 2] + ... + arr[j - 1] == arr[j] + arr[j + 1] + ... + arr[arr.length - 1])\n";

    System.out.println(str);
  }

  public static void main()
  {
    PartitionArrayThreePartsEqualSum.readme();

    // arr = [0,2,1,-6,6,-7,9,1,2,0,1] = true
    int [] arr1 = {0,2,1,-6,6,-7,9,1,2,0,1};
    System.out.println("canThreePartsEqualSum(" + Arrays.toString(arr1) + ") = " +
                       canThreePartsEqualSum(arr1));

    // arr = [0,2,1,-6,6,7,9,-1,2,0,1] = false
    int [] arr2 = {0,2,1,-6,6,7,9,-1,2,0,1};
    System.out.println("canThreePartsEqualSum(" + Arrays.toString(arr2) + ") = " +
                       canThreePartsEqualSum(arr2));

    // arr = [3,3,6,5,-2,2,5,1,-9,4] => true
    int [] arr3 = {3,3,6,5,-2,2,5,1,-9,4};
    System.out.println("canThreePartsEqualSum(" + Arrays.toString(arr3) + ") = " +
                       canThreePartsEqualSum(arr3));

    System.out.println("canThreePartsEqualSumOpt(" + Arrays.toString(arr3) + ") = " +
     canThreePartsEqualSumOpt(arr3));


  }
}