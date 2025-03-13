import java.util.Arrays;
import java.util.Scanner;

public class ArrayFunction {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("n: ");
        int n = scanner.nextInt();
        int[] Array = new int[n];

        for (int i = 0; i < n; i++){
            Array[i] = scanner.nextInt();
        }

        Arrays.sort(Array);
        System.out.println("Mảng sắp xếp: " + Arrays.toString(Array));

        int sum = 0;
        for (int num : Array)
            sum += num;
        
        System.out.println("Sum: " + sum);

        double average = (double) sum / n;
        System.out.println("Average: " + average);

        scanner.close();
    }
}