/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.elimination.gauss;

/**
 *
 * @author muchlas
 */
public class EliminasiGauss {

    public void solve(double[][] A, double[] B) {
        int N = B.length;
        for (int k = 0; k < N; k++) {

            int max = k;
            for (int i = k + 1; i < N; i++) {
                if (Math.abs(A[i][k]) > Math.abs(A[max][k])) {
                    max = i;
                }
            }

            double[] temp = A[k];
            A[k] = A[max];
            A[max] = temp;

            double t = B[k];
            B[k] = B[max];
            B[max] = t;

            for (int i = k + 1; i < N; i++) {
                double factor = A[i][k] / A[k][k];
                B[i] -= factor * B[k];
                for (int j = k; j < N; j++) {
                    A[i][j] -= factor * A[k][j];
                }
            }
        }

        printRowEchelonForm(A, B);

        double[] solution = new double[N];
        for (int i = N - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < N; j++) {
                sum += A[i][j] * solution[j];
            }
            solution[i] = (B[i] - sum) / A[i][i];
        }

        printSolution(solution);
    }

    public void printRowEchelonForm(double[][] A, double[] B) {
        int N = B.length;
        System.out.println("\nMatriks Eselon : ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf("%.3f ", A[i][j]);
            }
            System.out.printf("| %.3f\n", B[i]);
        }
        System.out.println();
    }

    public void printSolution(double[] sol) {
        int N = sol.length;
        System.out.println("\nSolusi : ");
        for (int i = 0; i < N; i++) {
            System.out.printf("%.3f ", sol[i]);
        }
        System.out.println();
    }
}
