package compilerSemantic;

import java.util.HashMap;

public class Semantico implements Constants {
    HashMap<String, Id> tabelaSimbolos = new HashMap<String, Id>();

    int nivelAtual = 0;
    String tipoAtual = "";
    String tipoConstante = "";
    String valorConstante = "";
    String subCategoria = "";
    int numElementos;
    String contextoLid = "";
    String categoriaAtual = "constante";
    Id idLid;
    Id idAtual;
    String tipoLadoEsquerdo = "";
    boolean opNega = false;
    boolean opUnario = false;
    String tipoVarIndexada = "";
    String tipoFator = "";
    String tipoExpressao = "";
    String tipoVar = "";
    String tipoElementosDoVetor = "";
    String tipoTermo = "";
    String operadorAtual = "";
    String tipoExpressaoSimples = "";
    String contextoEXPR = "";


    public void executeAction(int action, Token token) throws SemanticError {
        int pos = token.getPosition();
        Id id = null;

        switch (action) {
            case 101:
                id = new Id("id-programa", categoriaAtual, "programa", null);
                tabelaSimbolos.put(token.getLexeme() + nivelAtual, id);
                break;
            case 104:
                tipoAtual = "inteiro";
                break;
            case 105:
                tipoAtual = "real";
                break;
            case 106:
                tipoAtual = "booleano";
                break;
            case 107:
                tipoAtual = "caracter";
                break;
            case 158:
                id = getIdByLexema(token.getLexeme());
                if (id == null) {
                    throw new SemanticError("Id não declarado", pos);
                } else {
                    if (id.categoria != "constante") {
                        throw new SemanticError("Esperava-se um id de Constante", pos);
                    } else {
                        tipoConstante = id.tipo;
                        valorConstante = id.getValorAsString();
                    }
                }
                break;
            case 159:
                tipoConstante = "inteiro";
                valorConstante = token.getLexeme();
                break;
            case 160:
                tipoConstante = "real";
                valorConstante = token.getLexeme();
                break;
            case 161:
                tipoConstante = "booleano";
                valorConstante = "falso";
                break;
            case 162:
                tipoConstante = "booleano";
                valorConstante = "verdadeiro";
                break;
            case 163:
                tipoConstante = "literal";
                valorConstante = token.getLexeme();
                break;
            case 108:
                if (!tipoConstante.equals("inteiro")) {
                    throw new SemanticError("Esperava-se uma constante inteira", pos);
                } else {
                    if (!tipoAtual.equals("inteiro")) {
                        throw new SemanticError("O tamanho da cadeia deve ser uma constante inteira", pos);
                    }

                    int valorConstanteParsed = Integer.parseInt(valorConstante);
                    if (valorConstanteParsed > 255) {
                        throw new SemanticError("Tamanho da cadeia maior que o permitido.", pos);
                    } else {
                        tipoAtual = "cadeia";
                    }
                }
                break;
            case 109:
                if (tipoAtual.equals("cadeia")) {
                    throw new SemanticError("Vetor do tipo cadeia nåo é permitido", pos);
                } else {
                    subCategoria = "vetor";
                }
                break;
            case 110:
                if (!tipoConstante.equals("inteiro")) {
                    throw new SemanticError("A dimensão deve ser uma constante inteira", pos);
                } else {
                    numElementos = Integer.parseInt(valorConstante);
                }
                break;
            case 111:
                if (tipoAtual.equals("cadeia")) {
                    subCategoria = "vetor";
                } else {
                    subCategoria = "pré-definido";
                }
                break;
            case 102:
                contextoLid = "decl";
                break;
            case 112:
                id = tabelaSimbolos.get(token.getLexeme() + nivelAtual);
                idLid = id;
                if (contextoLid.equals("decl")) {
                    if (id != null) {
                        throw new SemanticError("Id já declarado", pos);
                    } else {
                        id = new Id(categoriaAtual, subCategoria, tipoAtual, null);
                        tabelaSimbolos.put(token.getLexeme() + nivelAtual, id);
                    }
                } else if (contextoLid.equals("leitura")) {
                    if (id == null) {
                        throw new SemanticError("Id não delcarado", pos);
                    } else if (!categoriaAtual.equals("id-programa") || !isTipoAtualValid()) {
                        // TODO endenter oq significa categoria ou tipo invalido
                        throw new SemanticError("Tipo inválido para leitura", pos);
                    } else {
                        id.setValor(token.getLexeme());
                    }
                }
                break;
            case 113:
                if (subCategoria.equals("cadeia") || subCategoria.equals("vetor")) {
                    throw new SemanticError("Apenas ids de tipo pré-definido podem ser declarados como \t\tconstante", pos);
                } else if (tipoConstante.equals(tipoAtual)) {
                    throw new SemanticError("Tipo da constante incorreto", pos);
                } else {
                    categoriaAtual = "constante";
                }
                break;
            case 114:
                categoriaAtual = "variavel";
                break;
            case 103:
                idLid.categoria = categoriaAtual;
                idLid.subCategoria = subCategoria;
                break;
            case 115:
                id = getIdByLexema(token.getLexeme());
                if (id == null) {
                    throw new SemanticError("Identificador não declarado", pos);
                } else {
                    idAtual = id;
                }
                break;
            case 119:
                if (id.categoria.equals("variavel") || id.categoria.equals("parametro")) {
                    if (id.tipo.equals("vetor")) {
                        throw new SemanticError("id deveria ser indexado", pos);
                    } else {
                        tipoLadoEsquerdo = id.tipo;
                    }
                } else {
                    throw new SemanticError("id deveria ser variável", pos);
                }
                break;
            case 148:
                if (opNega) {
                    throw new SemanticError("Op. \"não\" repetido", pos);
                } else {
                    opNega = true;
                }
                break;
            case 149:
                if (!tipoFator.equals("boleano")) {
                    throw new SemanticError("Op. “não” exige operando booleano", pos);
                }
                break;
            case 150:
                if (opUnario) {
                    throw new SemanticError("Op. “unário” repetido", pos);
                } else {
                    opUnario = true;
                }
                break;
            case 151:
                if (!isNumber(tipoFator)) {
                    throw new SemanticError("Op. unário exige operando numérico", pos);
                }
                break;
            case 152:
                opNega = opUnario = false;
                break;
            case 153:
                tipoFator = tipoExpressao;
                break;
            case 121:
                if (!idAtual.categoria.equals("variavel")) {
                    throw new SemanticError("esperava-se uma variável", pos);
                } else {
                    if (!idAtual.tipo.equals("vetor") && !idAtual.tipo.equals("cadeia")) {
                        throw new SemanticError("apenas vetores e cadeias podem ser indexados", pos);
                    } else {
                        tipoVarIndexada = idAtual.tipo;
                    }
                }
                break;
            case 156:
                if (!tipoExpressao.equals("inteiro")) {
                    throw new SemanticError("índice deveria ser inteiro", pos);
                } else {
                    if (tipoVarIndexada.equals("cadeia")) {
                        tipoVar = "caracter";
                    } else {
                        tipoVar = tipoElementosDoVetor;
                    }
                }
                break;
            case 157:
                if (idAtual.categoria.equals("variavel") || idAtual.categoria.equals("parametro")) {
                    if (idAtual.tipo.equals("vetor")) {
                        throw new SemanticError("vetor deve ser indexado", pos);
                    } else {
                        tipoVar = idAtual.tipo;
                    }
                } else {
                    if (idAtual.categoria.equals("constante")) {
                        tipoVar = tipoConstante;
                    } else {
                        throw new SemanticError("esperava-se variável ou constante", pos);
                    }
                }
                break;
            case 154:
                tipoFator = tipoVar;
                break;
            case 155:
                tipoFator = tipoConstante;
                break;
            case 141:
                tipoTermo = tipoFator;
                break;
            case 144:
                operadorAtual = "*";
                break;
            case 145:
                operadorAtual = "/";
                break;
            case 146:
                operadorAtual = "div";
                break;
            case 147:
                operadorAtual = "e";
                break;
            case 142:
                if (isNumber(tipoTermo)) {
                    if (!"*+-/div".contains(operadorAtual)) {
                        throw new SemanticError("Operador e Operando incompatíveis", pos);
                    }
                } else if (tipoTermo.equals("boleano")) {
                    if (!"oue".contains(operadorAtual)) {
                        throw new SemanticError("Operador e Operando incompatíveis", pos);
                    }
                } else if ("caractercadeia".contains(tipoTermo)) {
                    if (!"+".equals(operadorAtual)) {
                        throw new SemanticError("Operador e Operando incompatíveis", pos);
                    }
                }
                break;
            case 143:
                if ((isNumber(tipoTermo) && !isNumber(tipoFator)) || (isNumber(tipoFator) && !isNumber(tipoTermo))) {
                    throw new SemanticError("Operandos incompatíveis", pos);
                } else if (("boleano".equals(tipoTermo) && !"boleano".equals(tipoFator)) || (!"boleano".equals(tipoTermo) && "boleano".equals(tipoFator))) {
                    throw new SemanticError("Operandos incompatíveis", pos);
                } else if (("cadeiacaracter".equals(tipoTermo) && !"cadeiacaracter".equals(tipoFator)) || (!"cadeiacaracter".equals(tipoTermo) && "cadeiacaracter".equals(tipoFator))) {
                    throw new SemanticError("Operandos incompatíveis", pos);
                } else {
                    if (isNumber(tipoTermo) && isNumber(tipoFator)) {
                        if ((tipoTermo + tipoFator).contains("real")) {
                            tipoTermo = "real";
                        } else {
                            tipoTermo = "inteiro";
                        }
                    } else if ("cadeiacaracter".equals(tipoTermo) || "cadeiacaracter".equals(tipoFator)) {
                        tipoTermo = "cadeia";
                    }
                }
                break;
            case 135:
                tipoExpressaoSimples = tipoTermo;
                break;
            case 138:
                operadorAtual = "+";
                break;
            case 139:
                operadorAtual = "-";
                break;
            case 140:
                operadorAtual = "ou";
                break;
            case 136:
                if (isNumber(tipoExpressaoSimples)) {
                    if (!"*+-/div".contains(operadorAtual)) {
                        throw new SemanticError("Operador e Operando incompatíveis", pos);
                    }
                } else if (tipoExpressaoSimples.equals("boleano")) {
                    if (!"oue".contains(operadorAtual)) {
                        throw new SemanticError("Operador e Operando incompatíveis", pos);
                    }
                } else if ("caractercadeia".contains(tipoExpressaoSimples)) {
                    if (!"+".equals(operadorAtual)) {
                        throw new SemanticError("Operador e Operando incompatíveis", pos);
                    }
                }
                break;
            case 137:
                if (isIncompatible(tipoExpressaoSimples, tipoTermo)) {
                    throw new SemanticError("Operandos incompatíveis", pos);
                } else {
                    if (isNumber(tipoTermo) && isNumber(tipoExpressaoSimples)) {
                        if ((tipoTermo + tipoExpressaoSimples).contains("real")) {
                            tipoExpressaoSimples = "real";
                        } else {
                            tipoExpressaoSimples = "inteiro";
                        }
                    } else if ("cadeiacaracter".equals(tipoTermo) || "cadeiacaracter".equals(tipoExpressaoSimples)) {
                        tipoExpressaoSimples = "cadeia";
                    }
                }
                break;
            case 128:
                tipoExpressao = tipoExpressaoSimples;
                break;
            case 130:
                operadorAtual = "=";
                break;
            case 131:
                operadorAtual = "<";
                break;
            case 132:
                operadorAtual = ">";
                break;
            case 133:
                operadorAtual = ">=";
                break;
            case 134:
                operadorAtual = "<=";
                break;
            case 999:
                operadorAtual = "<>";
                break;
            case 129:
                if (isIncompatible(tipoExpressaoSimples, tipoExpressao)) {
                    throw new SemanticError("Operandos incompatíveis", pos);
                } else {
                    tipoExpressao = "boleano";
                }
                break;
            case 120:
                if (isIncompatible(tipoExpressao, tipoLadoEsquerdo)) {
                    throw new SemanticError("tipos incompatíveis", pos);
                }
                break;
            case 122:
                if (!tipoExpressao.equals("inteiro")) {
                    throw new SemanticError("índice deveria ser inteiro", pos);
                } else {
                    if (tipoVarIndexada.equals("cadeia")) {
                        tipoLadoEsquerdo = "caracter";
                    } else {
                        tipoLadoEsquerdo = tipoElementosDoVetor;
                    }
                }
                break;
            case 116:
                if (!tipoExpressao.equals("inteiro") && !tipoExpressao.equals("boleano")) {
                    throw new SemanticError("tipo inválido da expressão", pos);
                } else {
                    // TODO gera codigo?
                }
                break;
            case 117:
                contextoLid = "leitura";
                break;
            case 118:
                contextoEXPR = "impressão";
                if (tipoExpressao.equals("boleano")) {
                    throw new SemanticError("tipo inválido para impressão");
                } else {
                    // TODO gera codigo?
                }
                break;
            case 127:
                if (contextoEXPR.equals("impressão")) {
                    if (tipoExpressao.equals("boleano")) {
                        throw new SemanticError("tipo inválido para impressão");
                    } else {
                        // TODO gera codigo?
                    }
                }
                break;
        }
    }

    private boolean isIncompatible(String tipoExpressaoSimples, String tipoExpressao) {
        if ((isNumber(tipoTermo) && !isNumber(tipoExpressaoSimples)) || (isNumber(tipoExpressaoSimples) && !isNumber(tipoTermo))) {
            return true;
        } else if (("boleano".equals(tipoTermo) && !"boleano".equals(tipoExpressaoSimples)) || (!"boleano".equals(tipoTermo) && "boleano".equals(tipoExpressaoSimples))) {
            return true;
        } else if (("cadeiacaracter".equals(tipoTermo) && !"cadeiacaracter".equals(tipoExpressaoSimples)) || (!"cadeiacaracter".equals(tipoTermo) && "cadeiacaracter".equals(tipoExpressaoSimples))) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isNumber(String type) {
        return "inteiroreal".contains(type);
    }

    private boolean isTipoAtualValid() {
        return !tipoAtual.equals("inteiro") && !tipoAtual.equals("real") && !tipoAtual.equals("cadeia") &&
                !tipoAtual.equals("booleano");
    }

    private Id getIdByLexema(String lexeme) {
        int nivel = nivelAtual;
        while (nivel >= 0) {
            Id id = tabelaSimbolos.get(lexeme + nivel);
            if (id != null) {
                return id;
            }

            nivel--;
        }

        return null;
    }
}

class Id {
    public String categoria;
    public String subCategoria;
    public String tipo;
    private String valor;

    public Id(String categoria, String subCategoria, String tipo, String valor) {
        this.categoria = categoria;
        this.subCategoria = subCategoria;
        this.tipo = tipo;
        this.valor = valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getValorAsInteger(int tokenPos) throws SemanticError {
        try {
            return Integer.parseInt(this.valor);
        } catch(NumberFormatException nfe) {
            throw new SemanticError("Esperava-se um valor inteiro", tokenPos);
        }
    }

    public double getValorAsDouble(int tokenPos) throws SemanticError {
        try {
            return Double.parseDouble(this.valor);
        } catch(NumberFormatException nfe) {
            throw new SemanticError("Esperava-se um valor inteiro", tokenPos);
        }
    }

    public String getValorAsString() {
        return this.valor;
    }

    public boolean getValorAsBoolean(int tokenPos) throws SemanticError {
        if (this.valor.equals("verdadeiro")) {
            return true;
        } else if (this.valor.equals("falso")) {
            return false;
        } else {
            throw new SemanticError("Esperava-se um valor booleano", tokenPos);
        }
    }
}

