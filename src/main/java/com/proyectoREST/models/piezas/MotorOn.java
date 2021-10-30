package com.proyectoREST.models.piezas;

public class MotorOn {
    private boolean motorOn;

    public MotorOn(){}
    public MotorOn(boolean motorOn){ this.motorOn = motorOn; }

    public boolean isMotorOn() {
        return motorOn;
    }

    public void setMotorOn(boolean motorOn) {
        this.motorOn = motorOn;
    }
}
