package easy;

public class ExcelSheetColumnNumber
{
  public static int titleToNumber(String columnTitle)
  {
    int pos = columnTitle.length() - 1;
    int number = 0;
    int pow = 1;
    while (pos >= 0) {
      // Use pow variable instead of Math.pow() to get better for the run time.
      // number += (c - '@') * Math.pow(26,digit);
      number += (columnTitle.charAt(pos) - '@') * pow;
      pow = pow * 26;
      //System.out.println("number = " + number);
      pos--;
    }
    
    return number;
  }

  public static int titleToNumberOpt(String columnTitle) 
  {
    int res = 0;
    for(int i = 0; i < columnTitle.length(); i++) {
        res = res * 26 + (columnTitle.charAt(i)-'A' + 1);
        //System.out.println("i = " + i + ", res = " + res);
    }
    
    return res;
  }
  
  public static void readme()
  {
    String str = "Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.\n\n";

    System.out.println(str);
  }

  public static void main() 
  {
    ExcelSheetColumnNumber.readme();
    String str = "";

    // columnTitle = "A" => 1
    String columnTitle = "A";
    System.out.println("titleToNumber(" + columnTitle + ") = " + 
                      ExcelSheetColumnNumber.titleToNumber(columnTitle));


    // columnTitle = "AB" => 28
    columnTitle = "AB";
    System.out.println("titleToNumber(" + columnTitle + ") = " + 
                      ExcelSheetColumnNumber.titleToNumber(columnTitle));

    // columnTitle = "ZY" => 701
    columnTitle = "ZY";
    System.out.println("titleToNumber(" + columnTitle + ") = " + 
                      ExcelSheetColumnNumber.titleToNumber(columnTitle));

    columnTitle = "ABC";
    System.out.println("titleToNumberOpt(" + columnTitle + ") = " + 
                      ExcelSheetColumnNumber.titleToNumberOpt(columnTitle));

  }
}