package com.proyectoREST.models.piezas;

public class AireOn {
    private boolean aireOn;

    public AireOn(){}
    public AireOn(boolean aireOn){ this.aireOn = aireOn; }

    public boolean isAireOn() {
        return aireOn;
    }

    public void setAireOn(boolean aireOn) {
        this.aireOn = aireOn;
    }
}
