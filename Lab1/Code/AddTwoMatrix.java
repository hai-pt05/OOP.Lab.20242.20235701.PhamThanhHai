import java.util.Scanner;

public class AddTwoMatrix {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        //nhập kích thước 
        System.out.print("Số hàng: ");
        int rows = scanner.nextInt();
        System.out.print("Số cột: ");
        int cols = scanner.nextInt();

        //khởi tạo ma trận
        int[][] mtrix1 = new int[rows][cols];
        int[][] mtrix2 = new int[rows][cols];
        int[][] sumMtrix = new int[rows][cols];

        System.out.println("Nhập mtrix1: ");
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                System.out.print("Nhập gtrị  hàng " + (i+1) + ", cột " + (j+1) + ": ");
                mtrix1[i][j] = scanner.nextInt(); 
            }
        }

        System.out.println("Nhập mtrix2: ");
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                System.out.print("Nhập gtrị hàng " + (i+1) + ", cột " + (j+1) + ": ");
                mtrix2[i][j] = scanner.nextInt();
            }
        }

        //cộng 2 mtrix
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++)
                sumMtrix[i][j] = mtrix1[i][j] + mtrix2[i][j];
        }

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                System.out.print(sumMtrix[i][j] + " ");
            }
            System.out.println();
        }
        scanner.close();
    }    
}

