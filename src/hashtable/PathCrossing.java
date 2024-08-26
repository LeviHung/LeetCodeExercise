package hashtable;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class PathCrossing
{
  public static boolean isPathCrossing(String path) {
    int size = path.length();
    int len;
    if (size > 1000) {
        len = size / 500;
    } else {
        len = size;
    }
    boolean[][] map = new boolean[len * 2 + 1][len * 2 + 1]; 
    //System.out.println("len = " + len);
    int x = 0;
    int y = 0;
    map[x + len][y + len] = true;
    for (int i = 0; i < size; i++) {
        char ch = path.charAt(i);
        if (ch == 'N') {
            y++;
        } else if (ch == 'S') {
            y--;
        } else if (ch == 'E') {
            x++;
        } else {
            x--;
        }
        if (map[x + len][y + len] == true) {
            return true;
        }
        map[x + len][y + len] = true;
    }

    return false;
  }

  public static boolean isPathCrossingOpt(String path) {
    int x, y, i;
  x = y = i = 0;
  Set<Integer> cor = new HashSet<>();
  cor.add(0);
  while (i < path.length()) {
  switch (path.charAt(i)) {
  case 'N':
    x++;
    break;
  case 'S':
    x--;
    break;
  case 'E':
    y++;
    break;
  case 'W':
    y--;
    break;
  }
   int hash = y * 20000 + x;
  if (!cor.add(hash))
    return true;
  i++;
  }
  return false;
  }

  public static void readme()
  {
    String str = "Given a string path, where path[i] = 'N', 'S', 'E' or 'W', each representing moving one unit north, south, east, or west, respectively. You start at the origin (0, 0) on a 2D plane and walk on the path specified by path.\n\n";

    str += "Return true if the path crosses itself at any point, that is, if at any time you are on a location you have previously visited. Return false otherwise.\n";

    System.out.println(str);
  }

  public static void main() 
  {
    PathCrossing.readme();

    String path;

    // Input: path = "NES"
    // Output: false 
    path = "NES";
    System.out.println("isPathCrossing(" + path + ") = " + 
                       isPathCrossing(path));

    // Input: path = "NESWW"
    // Output: true
    path = "NESWW";
    System.out.println("isPathCrossing(" + path + ") = " + 
                       isPathCrossing(path));

    // Input: path = "NESWW"
    // Output: true
    path = "NESWW";
    System.out.println("isPathCrossingOpt(" + path + ") = " + 
                       isPathCrossingOpt(path));


  }
}