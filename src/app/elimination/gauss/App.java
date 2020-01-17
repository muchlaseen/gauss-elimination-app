/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.elimination.gauss;

import java.util.Scanner;

/**
 *
 * @author muchlas
 */
public class App {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        EliminasiGauss gauss = new EliminasiGauss();
 
        System.out.println("\nMasukkan jumlah variable: ");
        int N = scan.nextInt();
 
        double[] B = new double[N];
        double[][] A = new double[N][N];
 
        System.out.println("\nMasukkan sebanyak "+ N +" koefisien persamaan");
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                A[i][j] = scan.nextDouble();
 
        System.out.println("\nMasukkan "+ N +" matriks solusi");
        for (int i = 0; i < N; i++)
            B[i] = scan.nextDouble();
 
        gauss.solve(A,B);
    }
}
