package com.proyectoREST.models;

import com.proyectoREST.models.piezas.TanqueHidrogeno;

/*
    La clase CocheHibrido deriva de la clase Coche
    Es la única clase derivada de Coche que contiene el atributo TanqueHidrogeno
 */
public class CocheHibrido extends Coche{
    private TanqueHidrogeno oTanqueHidrogeno;

    public CocheHibrido(){
        super("hibrido");
    }

    public CocheHibrido(String fabricante, String nombre, String color, int puertas, int tanque){
        setFabricante(fabricante);
        setNombre(nombre);
        setColor(color);
        setTipo("hibrido");
        setPuertas(puertas);
        setBateriaOn(true);
        setMotorOn(true);
        setAireOn(true);
        oTanqueHidrogeno = new TanqueHidrogeno(tanque);
    }

    public int getTanqueHidrogeno() {
        return oTanqueHidrogeno.getTanqueHidrogeno();
    }

    public void setTanqueHidrogeno(int tanqueHidrogeno) {
        oTanqueHidrogeno.setTanqueHidrogeno(tanqueHidrogeno);
    }
}
