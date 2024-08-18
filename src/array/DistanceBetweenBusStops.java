package array;
import java.util.Arrays;

public class DistanceBetweenBusStops
{
  public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
    int forward = getDistance(distance, start, destination);

    int backward = getDistance(distance, destination, start);
    /*
    for (int dist: distance) {
        backward += dist;
    }
    backward = backward - forward;
    */
    if (forward < backward) {
        return forward;
    } else {
        return backward;
    }
  }

  public static int getDistance(int[] distance, int s, int d) {
    int res = 0;
    while (s != d) {
        res += distance[s];
        s++;
        if (s > distance.length - 1) {
            s = 0;
        }
    }
    return res;
  }

  public static void readme()
  {
    String str = "A bus has n stops numbered from 0 to n - 1 that form a circle. We know the distance between all pairs of neighboring stops where distance[i] is the distance between the stops number i and (i + 1) % n.\n\n";

    str += "The bus goes along both directions i.e. clockwise and counterclockwise.\n\n";

    str += "Return the shortest distance between the given start and destination stops.\n\n";

    System.out.println(str);
  }

  public static void main()
  {
    DistanceBetweenBusStops.readme();

    int start;
    int destination;
    
    // Input: distance = [1,2,3,4], start = 0, destination = 1
    // Output: 1

    int [] distance1 = {1,2,3,4};
    start = 0;
    destination = 1;
    System.out.println("distanceBetweenBusStops(" + 
                       Arrays.toString(distance1) + 
                       ", " + start + ", " + destination + ") = " +
                       distanceBetweenBusStops(distance1, start, destination));

    // Input: distance = [1,2,3,4], start = 0, destination = 2
    // Output: 3
    int [] distance2 = {1,2,3,4};
    start = 0;
    destination = 2;
    System.out.println("distanceBetweenBusStops(" + 
                       Arrays.toString(distance2) + 
                       ", " + start + ", " + destination + ") = " +
                       distanceBetweenBusStops(distance2, start, destination));

    // Input: distance = [1,2,3,4], start = 0, destination = 3
    // Output: 4
    int [] distance3 = {1,2,3,4};
    start = 0;
    destination = 3;
    System.out.println("distanceBetweenBusStops(" + 
                       Arrays.toString(distance3) + 
                       ", " + start + ", " + destination + ") = " +
                       distanceBetweenBusStops(distance3, start, destination));

  }
}