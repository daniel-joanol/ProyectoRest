package com.proyectoREST.models;

import com.proyectoREST.models.piezas.*;

/*
    La clase abstracta Coche es utilizada para la implementación de las clases:
        CocheCombustion, CocheHibrido y CocheElectrico
 */
public abstract class Coche {
    private String tipo;
    private Fabricante oFabricante = new Fabricante();
    private Nombre oNombre = new Nombre();
    private Color oColor = new Color();
    private Puertas oPuertas = new Puertas();
    private BateriaOn oBateriaOn = new BateriaOn();
    private MotorOn oMotorOn = new MotorOn();
    private AireOn oAireOn = new AireOn();

    public Coche(){}
    public Coche(String tipo){
        this.tipo = tipo;
        oBateriaOn = new BateriaOn(true);
        oMotorOn = new MotorOn(true);
        oAireOn = new AireOn(true);
    }

    public int getPuertas() { return oPuertas.getPuertas(); }

    public void setPuertas(int puertas) {
        oPuertas.setPuertas(puertas);
    }

    public String getFabricante() {
        return oFabricante.getFabricante();
    }

    public void setFabricante(String fabricante) {
        oFabricante.setFabricante(fabricante);
    }

    public String getColor() {
        return oColor.getColor();
    }

    public void setColor(String color) {
        oColor.setColor(color);
    }

    public String getNombre() {
        return oNombre.getNombre();
    }

    public void setNombre(String nombre) {
        oNombre.setNombre(nombre);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) { this.tipo = tipo; }

    public boolean getIsBateriaOn() {
        return oBateriaOn.isBateriaOn();
    }

    public void setBateriaOn(boolean bateriaOn) {
        oBateriaOn.setBateriaOn(bateriaOn);
    }

    public boolean getIsMotorOn() {
        return oMotorOn.isMotorOn();
    }

    public void setMotorOn(boolean motorOn) {
        oMotorOn.setMotorOn(motorOn);
    }

    public boolean getIsAireOn() {
        return oAireOn.isAireOn();
    }

    public void setAireOn(boolean aireOn) {
        oAireOn.setAireOn(aireOn);
    }
}
