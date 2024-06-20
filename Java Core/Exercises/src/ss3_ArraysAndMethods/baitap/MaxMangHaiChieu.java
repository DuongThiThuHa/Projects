package ss3_ArraysAndMethods.baitap;

import java.util.Scanner;

public class MaxMangHaiChieu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhạp vao so hang cua mang : ");
        int row = scanner.nextInt();
        System.out.println("Nhap vao so cot cua mang : ");
        int col = scanner.nextInt();

        int[][] array =  new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.println("phan tu cua mang tai vi tri ["+i+"]["+j+"] la : "+array[i][j]);
                array[i][j] = scanner.nextInt();
            }
        }
        int max = array[0][0];
        for (int k = 0; k < row; k++) {
            for (int h = 0; h < col; h++) {
                if (array[k][h] > max){
                    max = array[k][h];
                }
            }
        }
        System.out.println("Phan tu lon nhat trong mang la : "+ max);
    }
}
