package com.proyectoREST.models;

public class CocheNotFoundException extends Exception{
    public CocheNotFoundException(){
        super();
    }

    public CocheNotFoundException(String message){
        super(message);
    }
}
