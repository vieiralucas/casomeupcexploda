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


    public void executeAction(int action, Token token) throws SemanticError {
        int pos = token.getPosition();
        Id id = null;

        switch (token.getId()) {
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
            case 150:
                if (opUnario) {
                    throw new SemanticError("Op. “unário” repetido", pos);
                } else {
                    opUnario = true;
                }
                break;
            case 152:
                opNega = opUnario = false;
                break;
            case 121:
                if (idAtual.categoria.equals("variavel")) {
                    throw new SemanticError("tipos incompatíveis", pos);
                }
                // gera codigo??
                break;
        }
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

