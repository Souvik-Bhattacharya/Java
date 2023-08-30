import java.util.Random;

class MatrixClass{
    int m[][];

    MatrixClass(int row, int column){
        m = new int [row][column];
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

    MatrixClass transpose(){
        MatrixClass res = new MatrixClass(m.length, m[0].length);

        for(int r = 0; r < m.length; r++){
            for(int c = 0; c < m[0].length; c++){
                res.m[r][c] = m[c][r];
            }
        }

        return res;
    }
}

public class MatrixTranspose{
    public static void main(String args[]){
        MatrixClass m1 = new MatrixClass(3, 3);
        
        m1.setMatrix();
        System.out.println("\nThe matrix is as follows:\n");
        m1.getMatrix();

        MatrixClass r = m1.transpose();
        System.out.println("\nThe transposed matrix is as follows:\n");
        r.getMatrix();
    }
}