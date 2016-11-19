package compiler;

public interface Constants extends ScannerConstants, ParserConstants
{
    int EPSILON  = 0;
    int DOLLAR   = 1;

    int t_num_int = 2;
    int t_num_real = 3;
    int t_CLITERAL = 4;
    int t_COMMENTLINHA = 5;
    int t_COMMENTBLOCK = 6;
    int t_proc = 7;
    int t_funcao = 8;
    int t_se = 9;
    int t_entao = 10;
    int t_senao = 11;
    int t_faca = 12;
    int t_repita = 13;
    int t_ate = 14;
    int t_leia = 15;
    int t_escreva = 16;
    int t_ou = 17;
    int t_e = 18;
    int t_nao = 19;
    int t_falso = 20;
    int t_verdadeiro = 21;
    int t_enquanto = 22;
    int t_const = 23;
    int t_decl = 24;
    int t_ref = 25;
    int t_val = 26;
    int t_TOKEN_27 = 27; //";"
    int t_TOKEN_28 = 28; //","
    int t_TOKEN_29 = 29; //"."
    int t_TOKEN_30 = 30; //">"
    int t_TOKEN_31 = 31; //"<"
    int t_TOKEN_32 = 32; //"="
    int t_TOKEN_33 = 33; //"("
    int t_TOKEN_34 = 34; //")"
    int t_TOKEN_35 = 35; //"["
    int t_TOKEN_36 = 36; //"]"
    int t_TOKEN_37 = 37; //"+"
    int t_TOKEN_38 = 38; //"-"
    int t_TOKEN_39 = 39; //"*"
    int t_TOKEN_40 = 40; //"/"
    int t_TOKEN_41 = 41; //":"
    int t_TOKEN_42 = 42; //":="
    int t_TOKEN_43 = 43; //".."
    int t_TOKEN_44 = 44; //"<>"
    int t_TOKEN_45 = 45; //"<="
    int t_TOKEN_46 = 46; //">="
    int t_intervalo = 47;
    int t_vetor = 48;
    int t_cadeia = 49;
    int t_de = 50;
    int t_inteiro = 51;
    int t_real = 52;
    int t_booleano = 53;
    int t_caracter = 54;
    int t_inicio = 55;
    int t_fim = 56;
    int t_literal = 57;
    int t_id = 58;

}
