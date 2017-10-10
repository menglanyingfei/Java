package com.lxy.basic;

import java.util.Scanner;
 
/**
 * 
 * @author 15072
 * 200 200
 * 运行超时
 */
public class Main25_TraverseNumber {
 
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int m = sc.nextInt();
        int n = sc.nextInt();
        int mum;
        boolean[][] test = new boolean[m][n];
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mum = sc.nextInt();
                arr[i][j] = mum;
                test[i][j] = true;
            }
        }
        int mark1 = 0;
        while (mark1<=(m>n?n:m)/2) {
             
            for (int i = 0+mark1; i < m - mark1; i++) {                     //down
                if(test[i][mark1] != false){
                System.out.print(arr[i][mark1] + " ");
                test[i][mark1] = false;
                }
            }
              
            for (int i = mark1+1; i < n - mark1; i++) {                     //right
                if(test[m - 1 - mark1][i] != false){
                System.out.print(arr[m - 1 - mark1][i] + " ");
                test[m - 1 - mark1][i] = false;
                }
            }
              
            for (int i = m - 1 - mark1-1; i >= mark1; i--) {          //up
                if(test[i][n - 1 - mark1] != false){
                System.out.print(arr[i][n - 1 - mark1] + " ");
                test[i][n - 1 - mark1] = false;
                }
            }
            for (int i = n - 1 - mark1-1; i >= mark1+1; i--) {                //left
                if(test[mark1][i] != false){
                System.out.print(arr[mark1][i] + " ");
                test[mark1][i] = false;
                }
            }
            mark1++;
        }
        }
}