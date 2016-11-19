package compilerSintaticLexic;

import java.util.Scanner;

class Util {
    int[] readScannerTableIndexes() {
        try {
            Scanner s = new Scanner(getClass().getResourceAsStream("scanner-table-indexes"));
            int[] array = new int[s.nextInt()];
            for (int i = 0; i < array.length; i++) {
                array[i] = s.nextInt();
            }

            return array;
        } catch(Exception e) {
            e.printStackTrace();
        }

        return new int[0];
    }

    int[][] readScannerTable() {
        try {
            Scanner s = new Scanner(getClass().getResourceAsStream("scanner-table"));
            int size = s.nextInt();
            int[][] array = new int[size][2];
            for (int i = 0; i < size; i++) {
                array[i][0] = s.nextInt();
                array[i][1] = s.nextInt();
            }

            return array;
        } catch(Exception e) {
            e.printStackTrace();
        }

        return new int[0][0];
    }
}

public interface ScannerConstants
{
    Util util = new Util();

    int[] SCANNER_TABLE_INDEXES = util.readScannerTableIndexes();

    int[][] SCANNER_TABLE = util.readScannerTable();

    int[] TOKEN_STATE = {  0,   0,  -1,  33,  34,  39,  37,  28,  38,  29,  40,   2,   2,  41,  27,  31,  32,  30,  -1,  58,  35,  36,  58,  58,  58,  58,  18,  58,  58,  58,  58,  58,  58,  58,  58,  58,   4,  43,   3,  -1,   5,  -1,  -1,   2,  42,  45,  44,  46,  -1,  -1,  58,  58,  58,  58,  50,  58,  58,  58,  58,  58,  58,  58,  58,  58,  58,  17,  58,  58,   9,  58,  58,  -1,  -1,  -1,   3,  -1,  -1,  -1,   2,   2,  -1,  -1,  14,  58,  58,  58,  58,  58,  58,  58,  58,  58,  58,  56,  58,  58,  58,  58,  58,  19,  58,  58,  58,  25,  58,  58,  26,  58,  58,  -1,  -1,   3,   3,   6,  -1,   3,   3,   3,  -1,  58,  58,  58,  58,  24,  58,  58,  58,  12,  58,  58,  58,  58,  15,  58,  -1,   7,  52,  58,  58,  58,  58,  -1,   3,  -1,  58,  58,  58,  23,  58,  10,  58,  20,  58,  58,  58,  58,  58,  58,  58,  58,  11,  58,  48,   0,  58,  49,  58,  58,  58,   8,  55,  58,  58,  58,  58,  58,  13,  58,  58,  58,  58,  16,  51,  58,  57,   2,  58,  58,  53,  54,  22,  58,   3,  58,  47,  58,  21 };

    String[] SCANNER_ERROR =
    {
        "Caractere não esperado",
        "",
        "Erro identificando CLITERAL",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "Erro identificando id",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "Erro identificando COMMENTBLOCK",
        "",
        "Erro identificando num_real",
        "Erro identificando num_int ou num_real",
        "",
        "",
        "",
        "",
        "",
        "Erro identificando id",
        "Erro identificando id",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "Erro identificando num_real",
        "Erro identificando num_real",
        "Erro identificando COMMENTBLOCK",
        "",
        "Erro identificando num_real",
        "Erro identificando num_int",
        "Erro identificando num_real",
        "",
        "",
        "Erro identificando num_real",
        "Erro identificando <ignorar>",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "Erro identificando num_real",
        "Erro identificando num_real",
        "",
        "",
        "",
        "Erro identificando num_real",
        "",
        "",
        "",
        "Erro identificando <ignorar>",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "Erro identificando num_int ou num_real ou id",
        "",
        "",
        "",
        "",
        "",
        "",
        "Erro identificando num_real",
        "",
        "Erro identificando <ignorar>",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        ""
    };

}
