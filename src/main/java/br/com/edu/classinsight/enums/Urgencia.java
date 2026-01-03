package br.com.edu.classinsight.enums;

public enum Urgencia {
    CRITICO,
    ALTA,
    MEDIA,
    BAIXA;

    public static Urgencia fromNota(Integer nota) {
        if (nota == null) return CRITICO;
        if (nota <= 2) return CRITICO;
        if (nota <= 5) return ALTA;
        if (nota <= 7) return MEDIA;
        return BAIXA; // inclui >7 e >10 como BAIXA por padrão
    }

    public String asString() {
        return name();
    }
}

