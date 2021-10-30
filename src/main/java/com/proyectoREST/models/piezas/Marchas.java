package com.proyectoREST.models.piezas;

public class Marchas {
    private int marchas;

    private Marchas(){}
    public Marchas(int marchas){ this.marchas = marchas; }

    public int getMarchas() {
        return marchas;
    }

    public void setMarchas(int marchas) {
        this.marchas = marchas;
    }
}
