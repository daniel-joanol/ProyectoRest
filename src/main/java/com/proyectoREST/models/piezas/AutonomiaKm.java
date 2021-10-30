package com.proyectoREST.models.piezas;

public class AutonomiaKm {
    private int autonomiaKm;

    private AutonomiaKm(){}
    public AutonomiaKm(int autonomiaKm){ this.autonomiaKm = autonomiaKm; }

    public int getAutonomiaKm() {
        return autonomiaKm;
    }

    public void setAutonomiaKm(int autonomiaKm) {
        this.autonomiaKm = autonomiaKm;
    }
}
