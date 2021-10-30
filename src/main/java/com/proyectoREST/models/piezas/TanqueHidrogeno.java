package com.proyectoREST.models.piezas;

public class TanqueHidrogeno {
    private int tanqueHidrogeno;

    private TanqueHidrogeno(){}
    public TanqueHidrogeno(int tanqueHidrogeno){ this.tanqueHidrogeno = tanqueHidrogeno; }

    public int getTanqueHidrogeno() {
        return tanqueHidrogeno;
    }

    public void setTanqueHidrogeno(int tanqueHidrogeno) {
        this.tanqueHidrogeno = tanqueHidrogeno;
    }
}
