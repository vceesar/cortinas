package com.java.cortinas.api;

public class Filme {

    int filmeId;
    String tituloFilme;
    String diretorFilme;
    String elencoPrincipalFilme;
    String paisFilme;
    int anoFilme;

    public int getFilmeId() {
        return filmeId;
    }

    public void setFilmeId(int filmeId) {
        this.filmeId = filmeId;
    }

    public String getTituloFilme() {
        return tituloFilme;
    }

    public void setTituloFilme(String tituloFilme) {
        this.tituloFilme = tituloFilme;
    }

    public String getDiretorFilme() {
        return diretorFilme;
    }

    public void setDiretorFilme(String diretorFilme) {
        this.diretorFilme = diretorFilme;
    }

    public String getElencoPrincipalFilme() {
        return elencoPrincipalFilme;
    }

    public void setElencoPrincipalFilme(String elencoPrincipalFilme) {
        this.elencoPrincipalFilme = elencoPrincipalFilme;
    }

    public String getPaisFilme() {
        return paisFilme;
    }

    public void setPaisFilme(String paisFilme) {
        this.paisFilme = paisFilme;
    }

    public int getAnoFilme() {
        return anoFilme;
    }

    public void setAnoFilme(int anoFilme) {
        this.anoFilme = anoFilme;
    }
}

