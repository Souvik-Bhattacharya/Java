import java.util.Random;

class MatrixClass{
    int m[][];

    MatrixClass(int row, int column){
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
        System.out.println("The matrix is as follows:\n");
        for(int r = 0; r < m.length; r++){
            for(int c = 0; c < m[r].length; c++){
                System.out.print(" " + m[r][c]);     
            }
            System.out.println("");
        }
    }

}

public class Matrix {
    public static void main(String[] args){
        MatrixClass matrix1 = new MatrixClass(4, 3);

        matrix1.setMatrix();
        matrix1.getMatrix();
    }
}