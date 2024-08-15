package c_cucumber_bdd.teoria.system;

public enum NomesPropriedades {

    PROP_PATH_RAIZ("Path raiz", "pathRaiz"),
    PROP_PATH_BASE_REPORT("Path base report", "pathBaseReport"),

    PROP_TRELLO_LOGIN("Trello login", "trelloLogin"),
    PROP_TRELLO_SENHA("Trello senha", "trelloSenha"),
    PROP_TRELLO_URL("Trello url", "trelloUrl");

    private final String descricao;
    private final String valor;

    NomesPropriedades(String descricao, String valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getValor() {
        return valor;
    }

    public static NomesPropriedades getName(String descricaoPropriedade) {
        for (NomesPropriedades atual : NomesPropriedades.values()) {
            if (descricaoPropriedade.toUpperCase().contains(atual.descricao.toUpperCase())) {
                return atual;
            }
        }
        return null;
    }

}
