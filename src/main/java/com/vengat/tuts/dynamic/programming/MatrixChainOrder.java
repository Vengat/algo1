package com.vengat.tuts.dynamic.programming;

import java.util.ArrayList;

public class MatrixChainOrder {

    ArrayList<Matrix> matrices;
    int lengthOfMatrices;
    int n;
    int[][] scalarMultiplications;
    int[][] partitionPoint;

    public MatrixChainOrder(ArrayList<Matrix> matrices) {
        this.matrices= matrices;
        lengthOfMatrices = this.matrices.size();
        n = lengthOfMatrices- 1;
        scalarMultiplications = new int[lengthOfMatrices][lengthOfMatrices];
        partitionPoint = new int[lengthOfMatrices - 1][lengthOfMatrices - 1];
    }

    public int getScalarMultiplicationsOfMatrices(int i, int k,int j) {
        Matrix prev = this.matrices.get(i);
        int numberOfScalarMultiplications = 0;
        Matrix currentMatrix = null;
        for(int l = i + 1; l <= k; l++) {
            currentMatrix = matrices.get(l);
            numberOfScalarMultiplications += prev.getRow() * prev.getCol() * currentMatrix.getCol();
            prev= null;
            prev = new Matrix(prev.getRow(), currentMatrix.getCol());
        }

        currentMatrix = null;
        Matrix firstProduct = prev;
        prev = matrices.get(k + 1);
        for(int m = k + 2; m <= j; m++) {
            currentMatrix = matrices.get(m);
            numberOfScalarMultiplications += prev.getRow() * prev.getCol() * currentMatrix.getCol();
            prev = null;
            prev = new Matrix(prev.getRow(), currentMatrix.getCol());
        }

        Matrix secondProduct = prev;
        prev = null;

        numberOfScalarMultiplications += firstProduct.getRow() * firstProduct.getCol() * secondProduct.getCol();


        return numberOfScalarMultiplications;
    }

    public void OrderMatrix() {

        for(int i = 0; i <= n; i++) {
            scalarMultiplications[i][i] = 0;
        }

        for(int l = 2; l <= n; l++) {
            /**
             * suppose lengthOfMatrices = 6
             * suppose n = 5
             * l = 2
             * i has to travel till n = 4 so i <= n - l + 1 or n - (l - 1), which
             * in this case is 5 - 2 + 1 = 4
             */
            for(int i = 0; i <= n - l + 1; i++) {
                int j = i + l - 1;
                scalarMultiplications[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int q = scalarMultiplications[i][k] + scalarMultiplications[k + 1][j] + getScalarMultiplicationsOfMatrices(i, k, j) ;

                    if (q < scalarMultiplications[i][j]) {
                        scalarMultiplications[i][j] = q;
                        partitionPoint[i][j] = k;
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        Matrix p0 = new Matrix(30, 35);
        Matrix p1 = new Matrix(35, 15);
        Matrix p2 = new Matrix(15, 5);
        Matrix p3 = new Matrix(5, 10);
        Matrix p4 = new Matrix(10, 20);
        Matrix p5 = new Matrix(20, 25);
        ArrayList<Matrix> matrices = new ArrayList<Matrix>();
        matrices.add(p0);
        matrices.add(p1);
        matrices.add(p2);
        matrices.add(p3);
        matrices.add(p4);
        matrices.add(p5);
        MatrixChainOrder mco = new MatrixChainOrder(matrices);
    }
}
