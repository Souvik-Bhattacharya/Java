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

    MatrixClass add(MatrixClass n){
        MatrixClass res = new MatrixClass(m.length, m[0].length);

        for(int r = 0; r < m.length; r++){
            for(int c = 0; c < m[0].length; c++){
                res.m[r][c] = m[r][c] + n.m[r][c];
            }
        }

        return res;
    }
}

public class MatrixAddition{
    public static void main(String args[]){
        MatrixClass m1 = new MatrixClass(3, 3);
        MatrixClass m2 = new MatrixClass(3, 3);
        
        m1.setMatrix();
        m2.setMatrix();
        
        System.out.println("\nThe first matrix is as follows:\n");
        m1.getMatrix();

        System.out.println("\nThe second matrix is as follows:\n");
        m2.getMatrix();

        MatrixClass r = m1.add(m2);
        System.out.println("\nThe resultant matrix is as follows:\n");
        r.getMatrix();
    }
}