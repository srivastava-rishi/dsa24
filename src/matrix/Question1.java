package matrix;


/*
 How to move inside a matrix ?
 How to get the row and column from a int[][]

 */
public class Question1 {


    public static void main(String[] args) {
        int fan[][] = {
                {5, 4, 7, 7},
                {1, 3, 8, 8},
                {2, 9, 6, 9}
        };

        int row = fan.length;
        int column = fan[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(fan[i][j] + " ");
            }
            System.out.println();
        }

    }
}
