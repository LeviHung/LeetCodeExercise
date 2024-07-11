package easy;

public class FirstBadVersion
{
  private static int badVersion;
  public static int firstBadVersion(int n)
  {
    // n = 5, bad = 4 => 4
    // 1 2 3 4 5
    // n = 2126753390, bad = 1702766719
    int good = 0;
    int bad = n;
    int l = 1;
    int r = n;
    int m = 1;
    while (good < (bad - 1)) {
      //System.out.println("# l = " + l + ", r = " + r + ", c = " + c);
      //c = (int)(((long)r + (long)l) / (long)2);
      // avoid overflow
      m = l + (r - l) / 2;
      if (isBadVersion(m) == true) {
        bad = m;
        r = m - 1;

      } else {
        good = m;
        l = m + 1;
      }
    }
    
    return bad;
  }

  public static int firstBadVersionOpt(int n) {
    return search(1, n);
  }

  private static int search(int start, int end) {
    if (start == end) return start;
    int middle = start + (end - start) /2;
    if (isBadVersion(middle)) {
        return search(start, middle);
    } else {
        return search(middle + 1, end);
    }
  }

  
  public static boolean isBadVersion(int n) 
  {
    if (n >= badVersion) {
      return true;
    } else {
      return false;
    }
  }

  public static void setBadVersion(int n)
  {
    badVersion = n;
  }
  
  public static void readme()
  {
    String str = "You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.\n\n";

    str += "Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.\n\n";
    
    str += "You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.\n";
    System.out.println(str);
  }

  public static void main()
  {
    FirstBadVersion.readme();

    int n;
    int bad;
    // n = 5, bad = 4 => 4
    n = 5;
    bad = 4;
    setBadVersion(bad);
    
    System.out.println("firstBadVersion(" + n + ") = " + 
                       firstBadVersion(n));

    // n = 1, bad = 1 => 1
    n = 1;
    bad = 1;
    setBadVersion(bad);

    System.out.println("firstBadVersion(" + n + ") = " + 
                       firstBadVersion(n));

    // n = 2126753390, bad = 1702766719
    n = 2126753390;
    bad = 1702766719;
    setBadVersion(bad);
    System.out.println("firstBadVersion(" + n + ") = " + 
                        firstBadVersion(n));

  }
}