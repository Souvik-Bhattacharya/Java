package matrix_operation;

import java.util.Random;

class Matrix{
    int m[][];

    Matrix(int row, int column){
        m = new int[row][column];
    }

    void setMatrix(){
        for(int r = 0; r < m.length; r++){
            for(int c = 0; c < m[r].length; c++){
                Random num = new Random();
                m[r][c] = num.nextInt(10);
            }
        }
    }
    
    void getMatrix(){
        for(int r = 0; r < m.length; r++){
            for(int c = 0; c < m[r].length; c++){
                System.out.print(" " + m[r][c]);     
            }
            System.out.println("");
        }
    }

    Matrix addition(Matrix n){
        Matrix result = new Matrix(m.length, m[0].length);

        for(int r = 0; r < m.length; r++){
            for(int c = 0; c < m[0].length; c++){
                result.m[r][c] = m[r][c] + n.m[r][c];
            }
        }

        return result;
    }

    Matrix multiplication(Matrix n){
        Matrix result = new Matrix(m.length, n.m[0].length);

        for(int r1 = 0; r1 < m.length; r1++){
            for(int c2 = 0; c2 < n.m[0].length; c2++){
                result.m[r1][c2] = 0;
                for(int r2 = 0; r2 < n.m.length; r2++){
                    result.m[r1][c2] += m[r1][r2] * n.m[r2][c2];
                }
            }
        }

        return result;
    }

    Matrix transpose(){
        Matrix result = new Matrix(m.length, m[0].length);

        for(int r = 0; r < m.length; r++){
            for(int c = 0; c < m[0].length; c++){
                result.m[r][c] = m[c][r];
            }
        }

        return result;
    }

}

public class MatDemo {
    public static void main(String[] args){
        Matrix matrix1 = new Matrix(4, 4);
        Matrix matrix2 = new Matrix(4, 4);

        matrix1.setMatrix();
        System.out.println("Matrix 1:\n");
        matrix1.getMatrix();
        
        matrix2.setMatrix();
        System.out.println("Matrix 2:\n");
        matrix2.getMatrix();

        Matrix matrixAdd = matrix1.addition(matrix2);
        System.out.println("Result of addition:\n");
        matrixAdd.getMatrix();

        Matrix matrixMul = matrix1.multiplication(matrix2);
        System.out.println("Result of multiplication:\n");
        matrixMul.getMatrix();

        Matrix matrixTran = matrix1.transpose();
        System.out.println("Result of transpose:\n");
        matrixTran.getMatrix();
    }
}