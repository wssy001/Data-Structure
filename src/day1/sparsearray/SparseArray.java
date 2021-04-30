package day1.sparsearray;

public class SparseArray {
    //稀疏数组用于存储一些具有很多无意义值的数组
    //它能很好的压缩原数组

    //    棋盘：
    // 1为白子  2为黑子
    public static void main(String[] args) {
        int[][] templateChess = new int[11][11];
        templateChess[1][2] = 1;
        templateChess[2][3] = 2;

        //打印

        for (int[] line : templateChess) {
            for (int row : line) {
                System.out.print(row + "\t");
            }
            System.out.println("\n");
        }

//      0	0	0	0	0	0	0	0	0	0	0
//      0	0	1	0	0	0	0	0	0	0	0
//      0	0	0	2	0	0	0	0	0	0	0
//      0	0	0	0	0	0	0	0	0	0	0
//      0	0	0	0	0	0	0	0	0	0	0
//      0	0	0	0	0	0	0	0	0	0	0
//      0	0	0	0	0	0	0	0	0	0	0
//      0	0	0	0	0	0	0	0	0	0	0
//      0	0	0	0	0	0	0	0	0	0	0
//      0	0	0	0	0	0	0	0	0	0	0
//      0	0	0	0	0	0	0	0	0	0	0

        //稀疏数组也是一个二维数组，其行数比原数组有效数字总数多1，列数固定为3
        //稀疏数组第一行的三个数据固定为 原数组的行数，列数以及有效数字的总数
        //第二行起展示原数组有效数字的行号，列号及具体的值

        //按照上文棋盘，建立一个稀疏数组

        //1：先获取原数组有效数字的个数
        int sum = 0;
        for (int[] line : templateChess) {
            for (int row : line) {
                if (row != 0) sum++;
            }
        }

        //2：建立稀疏数组
        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = templateChess.length;
        sparseArray[0][1] = templateChess[0].length;
        sparseArray[0][2] = sum;

        //设定一个变量，记录稀疏数组的行数（理解为当前找到的有效数字是第几个）
        int sparseLine = 1;

        for (int i = 0; i < templateChess.length; i++) {
            for (int j = 0; j < templateChess[i].length; j++) {
                if (templateChess[i][j] != 0) {
                    sparseArray[sparseLine][0] = i;
                    sparseArray[sparseLine][1] = j;
                    sparseArray[sparseLine][2] = templateChess[i][j];
                    sparseLine++;
                }
            }
        }

        for (int[] line : sparseArray) {
            for (int row : line) {
                System.out.print(row + "\t");
            }
            System.out.println("\n");
        }


        //稀疏数组打印：
        //  11	11	2
        //  1	2	1
        //  2	3	2

        //从稀疏数组复原为原数组

        //1：读取稀疏数组第一行数据，获取原数组的行，列
        int[][] chessArray = new int[sparseArray[0][0]][sparseArray[0][1]];

        //根据稀疏数组第1行信息，进行遍历，将数据存入目标数组
        for (int i = 1; i <= sparseArray[0][2]; i++) {
            int line = sparseArray[i][0];
            int row = sparseArray[i][1];
            int value = sparseArray[i][2];
            chessArray[line][row] = value;
        }

        for (int[] line : chessArray) {
            for (int row : line) {
                System.out.print(row + "\t");
            }
            System.out.println();
        }
    }
}
