
import java.util.Scanner; 

public class TowersOfHanoi {
  
  /** Main method */
  public static void main(String[] args) {
    // Create a Scanner
    Scanner input = new Scanner(System.in);
    System.out.print("Enter number of disks: ");
    int n = input.nextInt();

    // Find the solution recursively
    // System.out.println("The moves are:");
    System.out.println(moveDisks(n, 'A', 'B', 'C',0));

    input.close();
  }
  

  /** The method for finding the solution to move n disks
      from fromTower to toTower with auxTower */
  public static int moveDisks(int n, char fromTower,
      char toTower, char auxTower, int calories){
    if (n == 1) { // Stopping condition
      System.out.println("Move disk " + n + " from " +
        fromTower + " to " + toTower);
        calories += 1000 * n;
        return calories; 
      } 
      else {
      calories = moveDisks(n - 1, fromTower, auxTower, toTower,  calories);
      System.out.println("Move disk " + n + " from " +
      fromTower + " to " + toTower);
      calories += 1000 * n;
      calories = moveDisks(n - 1, auxTower, toTower, fromTower, calories);
      return calories; 
    }
  }
}
