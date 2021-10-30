package com.proyectoREST.models.piezas;

public class BateriaOn {
    private boolean bateriaOn;

    public BateriaOn(){}
    public BateriaOn(boolean bateriaOn){ this.bateriaOn = bateriaOn; }

    public boolean isBateriaOn() {
        return bateriaOn;
    }

    public void setBateriaOn(boolean bateriaOn) {
        this.bateriaOn = bateriaOn;
    }
}
