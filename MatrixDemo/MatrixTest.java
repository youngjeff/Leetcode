package MatrixDemo;

public class MatrixTest {
    public static void main(String[] args)
    {
        int x[][] = {
                {3,2,3},
                {5,9,8},
        };
        int y[][] = {
                {4,7},
                {9,3},
                {8,1},
        };
        int z[][] = Matrix.muliply(x, y);
        Matrix.mprint(x);
        Matrix.mprint(y);
        Matrix.mprint(z);
    }
}
