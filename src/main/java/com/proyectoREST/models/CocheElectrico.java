package com.proyectoREST.models;

import com.proyectoREST.models.piezas.AutonomiaKm;

/*
    La clase CocheElectrico deriva de la clase Coche
    Es la única clase derivada de Coche que contiene el atributo AutonomiaKm
 */
public class CocheElectrico extends Coche{
    private AutonomiaKm oAutonomiaKM;

    public CocheElectrico(){
        super("electrico");
    }

    public CocheElectrico(String fabricante, String nombre, String color, int puertas, int autonomia){
        setFabricante(fabricante);
        setNombre(nombre);
        setColor(color);
        setTipo("electrico");
        setPuertas(puertas);
        setBateriaOn(true);
        setMotorOn(true);
        setAireOn(true);
        oAutonomiaKM = new AutonomiaKm(autonomia);
    }

    public int getAutonomiaKM() {
        return oAutonomiaKM.getAutonomiaKm();
    }

    public void setAutonomiaKM(int autonomiaKM) {
        oAutonomiaKM.setAutonomiaKm(autonomiaKM);
    }
}
