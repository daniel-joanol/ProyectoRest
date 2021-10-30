package com.proyectoREST.models;

import com.proyectoREST.models.piezas.Marchas;

/*
    La clase CocheCombustion deriva de la clase Coche
    Es la única clase derivada de Coche que contiene el atributo Marchas
 */
public class CocheCombustion extends Coche {
    private Marchas oMarchas;

    public CocheCombustion(){
        super("combustion");
    }

    public CocheCombustion(String fabricante, String nombre, String color, int puertas, int marchas){
        setFabricante(fabricante);
        setNombre(nombre);
        setColor(color);
        setTipo("combustion");
        setPuertas(puertas);
        setBateriaOn(true);
        setMotorOn(true);
        setAireOn(true);
        oMarchas = new Marchas(marchas);
    }

    public int getMarchas() {
        return oMarchas.getMarchas();
    }

    public void setMarchas(int marchas) { oMarchas.setMarchas(marchas);
    }
}
