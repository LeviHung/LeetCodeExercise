package math;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class BinaryWatch
{
  public static List<String> readBinaryWatch(int turnedOn)
  {
    List<String> list = new ArrayList<>();
    
    String[] arrayH;
    String[] arrayM;
    int indexH = 0;
    int indexM = 0;
    
    for (int digitH = 0, digitM = turnedOn - digitH; 
         digitH <= turnedOn && digitH <= 3; 
         digitH++, digitM--) {
      arrayH = getHours(digitH);
      arrayM = getMins(digitM);
      indexH = 0;
      indexM = 0;
      while (arrayH[indexH] != null) {
        while (arrayM[indexM] != null) {
          list.add(arrayH[indexH] + arrayM[indexM++]);
        }
        indexH++;
        indexM = 0;
      } 
    }
    
    return list;
  }

  public static final String [] getHours(int bits) 
  {
    String [] hours = new String[6]; 
    switch (bits) {
      case 0:
        hours[0] = "0:";
        break;
      case 1:
        hours[0] = "1:";
        hours[1] = "2:";
        hours[2] = "4:";
        hours[3] = "8:";
        break;
      case 2:
        hours[0] = "3:";
        hours[1] = "5:";
        hours[2] = "6:";
        hours[3] = "9:";
        hours[4] = "10:";
        break;
      case 3:
        hours[0] = "7:";
        hours[1] = "11:";
        break;
      default:
        break;        
    }
    return hours;
  }

  public static final String [] getMins(int bits) 
  {
    String [] mins = new String[21];
    switch (bits) {
      case 0:
        mins[0] = "00";
        break;
      case 1:
        mins[0] = "01";
        mins[1] = "02";
        mins[2] = "04";
        mins[3] = "08";
        mins[4] = "16";
        mins[5] = "32";
        break;
      case 2:
        mins[0] = "03";
        mins[1] = "05";
        mins[2] = "06";
        mins[3] = "09";
        mins[4] = "10";
        mins[5] = "12";
        mins[6] = "17";
        mins[7] = "18";
        mins[8] = "20";
        mins[9] = "24";
        mins[10] = "33";
        mins[11] = "34";
        mins[12] = "36";
        mins[13] = "40";
        mins[14] = "48";

        break;
      case 3:
        mins[0] = "07";
        mins[1] = "11";
        mins[2] = "13";
        mins[3] = "14";
        mins[4] = "19";
        mins[5] = "21";
        mins[6] = "22";
        mins[7] = "25";
        mins[8] = "26";
        mins[9] = "28";
        mins[10] = "35";
        mins[11] = "37";
        mins[12] = "38";
        mins[13] = "41";
        mins[14] = "42";
        mins[15] = "44";
        mins[16] = "49";
        mins[17] = "50";
        mins[18] = "52";
        mins[19] = "56";
        break;
      case 4:
        mins[0] = "15";
        mins[1] = "23";
        mins[2] = "27";
        mins[3] = "29";
        mins[4] = "30";
        mins[5] = "39";
        mins[6] = "43";
        mins[7] = "45";
        mins[8] = "46";
        mins[9] = "51";
        mins[10] = "53";
        mins[11] = "54";
        mins[12] = "57";
        mins[13] = "58";
        break;
      case 5:
        mins[0] = "31";
        mins[1] = "47";
        mins[2] = "55";
        mins[3] = "59";
        break;
      default:
        break;        
    }
    return mins;
  }

  public static List<String> readBinaryWatchOpt(int turnedOn) 
  {
    //I don't know how to generate all the possibilities

    //8 and 4 cannot be turned on together

    //32+16+8 cannot be turned on together
    // a list of boolean
    // a list of all possible places to put turnedOn to true, everything else false
    // add to the final list using formatting/ conversion -> we convert the list of
    // boolean into strings, but we check to see if 8H is on, we then check to see if
    // 4H is on, if 4H is on, skip this iteration (8 and 4 can't be on together)
    // If 32M, 16M, and 8M are on, if 4M is on, skip this iteration.

    ArrayList<String> result = new ArrayList<>();
    generate(0, turnedOn, new boolean[10], 0, result);
    return result;
  }

  public static void generate(int i, int toTurnOn, boolean[] soFar, int turnedOn, ArrayList<String> toAdd) 
  {
    if (i == 10) {
        if ((soFar[0] && soFar[1]) || (soFar[4] && soFar[5] && soFar[6] && soFar[7])) {
            return;
        } 
        toAdd.add(translate(soFar));
        return;
    }

    if (i + (toTurnOn - turnedOn) == 10) {
        soFar[i] = true;
        generate(i + 1, toTurnOn, soFar, turnedOn + 1, toAdd);
    } else if (turnedOn == toTurnOn) {
        soFar[i] = false;
        generate(i + 1, toTurnOn, soFar, turnedOn, toAdd);
    } else {
        soFar[i] = true;
        generate(i + 1, toTurnOn, soFar, turnedOn + 1, toAdd);
        soFar[i] = false;
        generate(i + 1, toTurnOn, soFar, turnedOn, toAdd);
    }
  }

  public static String translate(boolean[] toTranslate) {
    //hours
    int hourResult = 0;
    for (int i = 0; i < 4; i++) {
        if (toTranslate[3 - i]) {
            hourResult += Math.pow(2, i);
        }
    }

    //minutes
    int minuteResult = 0;
    for (int i = 0; i < 6; i++) {
        if (toTranslate[9 - i]) {
            minuteResult += Math.pow(2, i);
        }
    }

    StringBuilder sb = new StringBuilder();
    sb.append(hourResult).append(":");
    if (minuteResult < 10) {
        sb.append("0");
    }
    sb.append(minuteResult);
    return sb.toString();

  }
  
  public static void readme()
  {
    String str = "A binary watch has 4 LEDs on the top to represent the hours (0-11), and 6 LEDs on the bottom to represent the minutes (0-59). Each LED represents a zero or one, with the least significant bit on the right.\n\n";

    str += "For example, the below binary watch reads \"4:51\".\n\n";
    str += "Given an integer turnedOn which represents the number of LEDs that are currently on (ignoring the PM), return all possible times the watch could represent. You may return the answer in any order.\n\n";
    str += "The hour must not contain a leading zero.\n\n";
    str += "For example, \"01:00\" is not valid. It should be \"1:00\".\n\n";
    str += "The minute must consist of two digits and may contain a leading zero.\n\n";
    str += "For example, \"10:2\" is not valid. It should be \"10:02\".\n\n";
System.out.println(str);
  }

  public static void main()
  {
    BinaryWatch.readme();

    int turnedOn;
    // turnedOn = 1 =>
    // ["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
    turnedOn = 1;
    System.out.println("readBinaryWatch(" + turnedOn + ") = ");     
    List list1 = readBinaryWatch(turnedOn);
    if (list1 != null) {
      System.out.println(Arrays.toString(list1.toArray()));
    }
    
    // turnedOn = 9 => [];
    turnedOn = 2;
    System.out.println("readBinaryWatch(" + turnedOn + ") = ");     
    List list2 = readBinaryWatch(turnedOn);
    if (list2 != null) {
      System.out.println(Arrays.toString(list2.toArray()));
    }
  }
}