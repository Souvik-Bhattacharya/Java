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

    MatrixClass mul(MatrixClass n){
        MatrixClass res = new MatrixClass(m.length, n.m[0].length);

        for(int r1 = 0; r1 < m.length; r1++){
            for(int c2 = 0; c2 < n.m[0].length; c2++){
                res.m[r1][c2] = 0;
                for(int r2 = 0; r2 < n.m.length; r2++){
                    res.m[r1][c2] += m[r1][r2] * n.m[r2][c2];
                }
            }
        }

        return res;
    }
}

public class MatrixMultiplication{
    public static void main(String args[]){
        MatrixClass m1 = new MatrixClass(4, 3);
        MatrixClass m2 = new MatrixClass(3, 5);
        
        m1.setMatrix();
        m2.setMatrix();
        
        System.out.println("\nThe first matrix is as follows:\n");
        m1.getMatrix();

        System.out.println("\nThe second matrix is as follows:\n");
        m2.getMatrix();

        MatrixClass r = m1.mul(m2);
        System.out.println("\nThe resultant matrix is as follows:\n");
        r.getMatrix();
    }
}