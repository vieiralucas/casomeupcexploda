package compilerSemantic;

public interface ParserConstants
{
    int START_SYMBOL = 45;

    int FIRST_NON_TERMINAL    = 45;
    int FIRST_SEMANTIC_ACTION = 71;

    int[][] PARSER_TABLE =
    {
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  1,  1,  1,  1,  1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, 21, -1, 25, -1, 23, 24, -1, -1, -1, -1, -1, 22, -1, -1, -1, -1, -1, -1, -1, -1, 19, 25, -1, -1, -1, -1, -1, -1, -1, -1, -1, 20, 25, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 61, 61, -1, -1, -1, -1, -1, -1, -1, -1, -1, 61, 61, -1, -1, -1, -1, -1, -1, -1, -1, 61, 60, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 62, 63, -1, -1, -1, -1, -1, -1, -1, -1, -1, 64, 65, -1, -1, -1, -1, -1, -1, -1, -1, 66, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  2,  2,  2,  2,  2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  3, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 31, 31, -1, -1, -1, -1, -1, -1, -1, -1, 31, 31, 31, -1, -1, -1, -1, -1, -1, -1, -1, 31, 31, -1, -1, -1, -1, -1, -1, 31, -1, -1, -1, -1, -1, -1, 31, -1, -1, -1, -1, -1, -1 },
        { -1, 40, 40, -1, -1, -1, -1, -1, -1, -1, -1, 40, 40, 40, -1, -1, -1, -1, -1, -1, -1, -1, 40, 40, -1, -1, -1, -1, -1, -1, 40, -1, -1, -1, -1, -1, -1, 40, -1, -1, -1, -1, -1, -1 },
        { -1, 57, 57, -1, -1, -1, -1, -1, -1, -1, -1, 53, 57, 57, -1, -1, -1, -1, -1, -1, -1, -1, 57, 56, -1, -1, -1, -1, -1, -1, 55, -1, -1, -1, -1, -1, -1, 54, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 11, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, 45, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 43, 44, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 52, -1, -1, -1, -1, -1, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 49, 50, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, 35, 34, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 39, 38, 37 },
        { -1, -1, -1, -1, -1, 28, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 28, -1, -1, -1, -1, -1, -1, -1, 27, -1, -1, 28, -1, -1, -1, -1, 26, -1, -1, -1 },
        { -1, -1, -1, -1, 42, 42, 42, -1, -1, 41, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 42, 42, -1, 42, 42, 42, -1, 42, -1, 42, -1, 42, 41, 41, -1, -1, -1, 42, 42, 42 },
        { -1, -1, -1, -1, 48, 48, 48, -1, -1, 48, 47, -1, -1, -1, -1, -1, 47, -1, -1, -1, -1, -1, -1, -1, 48, 48, -1, 48, 48, 48, -1, 48, -1, 48, -1, 48, 48, 48, 47, 47, -1, 48, 48, 48 },
        { -1, -1, -1, -1, 33, 33, 33, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 33, 33, -1, 32, 32, 32, -1, 33, -1, 33, -1, 33, -1, -1, -1, -1, -1, 32, 32, 32 },
        { -1, -1, -1, -1, 59, 59, 59, -1, -1, 59, 59, -1, -1, -1, -1, -1, 59, -1, -1, -1, -1, -1, -1, -1, 59, 59, -1, 59, 59, 59, -1, 59, 58, 59, -1, 59, 59, 59, 59, 59, -1, 59, 59, 59 },
        { -1, 46, 46, -1, -1, -1, -1, -1, -1, -1, -1, 46, 46, 46, -1, -1, -1, -1, -1, -1, -1, -1, 46, 46, -1, -1, -1, -1, -1, -1, 46, -1, -1, -1, -1, -1, -1, 46, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  8,  4,  5,  6,  7, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 16, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 10, -1, -1, -1, -1, -1, -1, -1, -1,  9, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 15, -1, -1, -1, -1, 14, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 13, 12, -1, -1, -1, 13, -1, 13, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 17, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 18, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 29, -1, -1, -1, -1, -1, 30, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }
    };

    int[][] PRODUCTIONS = 
    {
        {  16,  24, 172,  25,  46,  27 },
        {  50,  65 },
        {  64,  66, 173,  54,  67, 174,  25,  50 },
        {   0 },
        {  19, 175 },
        {  20, 176 },
        {  21, 177 },
        {  22, 178 },
        {  18,  33,  48, 179,  34 },
        { 180,  33,  48, 181,  34 },
        { 182 },
        {  24, 183,  68 },
        {  26,  54 },
        {   0 },
        {  30,  48, 184 },
        { 185 },
        {  35,  47,  69,  36 },
        {  25,  47,  69 },
        {   0 },
        {  24, 186,  58 },
        {  65 },
        {   4,  51, 187,   5,  47,   6,  47 },
        {  15,  51, 187,   7,  47 },
        {   8,  31, 188,  54,  32 },
        {   9,  31,  51, 189,  70,  32 },
        {   0 },
        { 190,  41,  51, 191 },
        {  33, 192,  51, 193,  34,  41,  51, 191 },
        {   0 },
        {  26,  51, 198,  70 },
        {   0 },
        {  52, 199,  61 },
        {  57,  52, 200 },
        {   0 },
        {  30, 201 },
        {  29, 202 },
        {  28, 203 },
        {  44, 204 },
        {  43, 205 },
        {  42, 205 },
        {  63, 206,  59 },
        {  55, 207,  63, 208,  59 },
        {   0 },
        {  37, 209 },
        {  38, 210 },
        {  10, 211 },
        {  53, 212,  60 },
        {  56, 213,  53, 214,  60 },
        {   0 },
        {  39, 215 },
        {  40, 216 },
        {  17, 217 },
        {  11, 218 },
        {  12, 219,  53, 220 },
        {  38, 221,  53, 222 },
        {  31, 223,  51,  32, 224 },
        {  24, 186,  62, 225 },
        {  49, 226 },
        {  33, 192,  51, 227,  34 },
        { 228 },
        {  24, 229 },
        {  49 },
        {   2, 230 },
        {   3, 231 },
        {  13, 232 },
        {  14, 233 },
        {  23, 234 }
    };

    String[] PARSER_ERROR =
    {
        "",
        "Era esperado fim de programa",
        "Era esperado num_int",
        "Era esperado num_real",
        "Era esperado se",
        "Era esperado entao",
        "Era esperado senao",
        "Era esperado faca",
        "Era esperado leia",
        "Era esperado escreva",
        "Era esperado ou",
        "Era esperado e",
        "Era esperado nao",
        "Era esperado falso",
        "Era esperado verdadeiro",
        "Era esperado enquanto",
        "Era esperado programa",
        "Era esperado div",
        "Era esperado cadeia",
        "Era esperado inteiro",
        "Era esperado real",
        "Era esperado booleano",
        "Era esperado caracter",
        "Era esperado literal",
        "Era esperado id",
        "Era esperado \";\"",
        "Era esperado \",\"",
        "Era esperado \".\"",
        "Era esperado \">\"",
        "Era esperado \"<\"",
        "Era esperado \"=\"",
        "Era esperado \"(\"",
        "Era esperado \")\"",
        "Era esperado \"[\"",
        "Era esperado \"]\"",
        "Era esperado \"{\"",
        "Era esperado \"}\"",
        "Era esperado \"+\"",
        "Era esperado \"-\"",
        "Era esperado \"*\"",
        "Era esperado \"/\"",
        "Era esperado \":=\"",
        "Era esperado \"<>\"",
        "Era esperado \"<=\"",
        "Era esperado \">=\"",
        "<programa> inválido",
        "<bloco> inválido",
        "<comando> inválido",
        "<constante> inválido",
        "<constante_explicita> inválido",
        "<dcl_var_const> inválido",
        "<expressao> inválido",
        "<expsimp> inválido",
        "<fator> inválido",
        "<lid> inválido",
        "<op_add> inválido",
        "<op_mult> inválido",
        "<oprel> inválido",
        "<rcomid> inválido",
        "<rep_expsimp> inválido",
        "<rep_termo> inválido",
        "<resto_expressao> inválido",
        "<rvar> inválido",
        "<termo> inválido",
        "<tipo> inválido",
        "<com_composto> inválido",
        "<dimensao> inválido",
        "<fator_const> inválido",
        "<rep_lid> inválido",
        "<replistacomando> inválido",
        "<rep_lexpr> inválido"
    };
}
