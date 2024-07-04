package easy;
import java.util.Arrays;

public class MajorityElement
{
  public static int majorityElement(int[] nums)
  {
    if (nums.length == 1 || nums.length == 2) {
        return nums[0];
    }
    int result = 0;
    int resultNum = 0;

    int result2 = 0;
    int resultNum2 = 0;

    int result3 = 0;
    int resultNum3 = 0;

    int first;
    int second;
    int third;

    int firstNum = 0;
    int secondNum = 0;
    int thirdNum = 0;
    int fourthNum = 0;

    for (int i = 1; i < nums.length-1; i++) {
      first = nums[i-1];
      second = nums[i];
      third = nums[i+1];

      firstNum = 0;
      secondNum = 0;
      thirdNum = 0;

      if (first == second || first == third ) {
        firstNum++;
      } 
      if (second == first || second == third ) {
        secondNum++;
      } 
      if (third == first || third == second ) {
        thirdNum++;
      } 
      
      if (firstNum >= secondNum && firstNum >= thirdNum ) {
        result = first;
        resultNum = firstNum;
      } else if (secondNum >= firstNum && secondNum >= thirdNum) {
        result = second;
        resultNum = secondNum;
      } else if (thirdNum >= firstNum && thirdNum >= secondNum) {
        result = third;
        resultNum = thirdNum;
      }
      //System.out.print("resultNum = " + resultNum);
      //System.out.print(", resultNum2 = " + resultNum2);
      //System.out.println(", result = " + result);
      if (resultNum > 0 && resultNum2 == 0) {
        result2 = result;
        resultNum2 += resultNum;
      } else if (result != result2) {
        result3 = result;
      }
    }
    //System.out.println(", result = " + result);
    //System.out.println(", result2 = " + result2);
    //System.out.println(", result3 = " + result3);

    if (result2 != result3 && result3 != 0) {
      resultNum2 = 0;
      resultNum3 = 0;
      for (int i = 0; i < nums.length; i++) {
        if (result2 == nums[i]) {
          resultNum2++;
        } else if (result3 == nums[i]) {
          resultNum3++;
        }
      }
      if (resultNum2 > resultNum3) {
        return result2;
      } else {
        return result3;
      }
    }
    return result2;
  }

  public static int majorityElementOpt(int[] nums) 
  {
    //return helper(nums,0,nums[0]);
    int candidate = nums[0];
    int count = 1;
    int i = 1;
    while (i < nums.length) {
      if (candidate == nums[i]) {
        count++;
      } else if (count > 1) {
        count--;
      } else {
        candidate = nums[i];
      }
      i++;
    }
    
    return candidate;
  }
  
  static int helper(int[] arr,int start,int majority){
    int count=0;
    for(int i=start;i<arr.length;i++){
        if(arr[i]==majority) count++;
        else count--;
        if(count==-1) return helper(arr,i,arr[i]);
    }
    return majority;
  }
  
  public static void readme()
  {
    String str = "Given an array nums of size n, return the majority element.\n\n";

    str += "The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.\n";

    System.out.println(str);
  }

  public static void main() 
  {
    MajorityElement.readme();
    // nums = [3,2,3] => 3
    int [] nums = {3, 2, 3};
    System.out.println("majorityElement(" + Arrays.toString(nums) + 
     ") = " + MajorityElement.majorityElementOpt(nums));

    // nums = [2,2,1,1,1,2,2] => 2
    int [] nums2 = {2,2,1,1,1,2,2};
    System.out.println("majorityElement(" + Arrays.toString(nums2) + 
     ") = " + MajorityElement.majorityElementOpt(nums2));

    // nums = [1,5,4,2,4,3,4,4,4]
    int [] nums3 = {1,5,4,2,4,3,4,4,4};
    System.out.println("majorityElement(" + Arrays.toString(nums3) + 
     ") = " + MajorityElement.majorityElementOpt(nums3));

    // nums = [-1,100,2,100,100,4,100]
    int [] nums4 = {-1,100,2,100,100,4,100};
    System.out.println("majorityElement(" + Arrays.toString(nums4) + 
     ") = " + MajorityElement.majorityElementOpt(nums4));

    // nums = [8,8,7,7,7]
    int [] nums5 = {8,8,7,7,7};
    System.out.println("majorityElement(" + Arrays.toString(nums5) + 
     ") = " + MajorityElement.majorityElementOpt(nums5));

    // nums = [8,8,8,7,7,7,7,7,7,7,8,8,8]
    int [] nums6 = {8,8,8,7,7,7,7,7,7,7,8,8,8};
    System.out.println("majorityElementOpt(" + Arrays.toString(nums6) + 
     ") = " + MajorityElement.majorityElementOpt(nums6));

  }
}