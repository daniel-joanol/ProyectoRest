package com.proyectoREST.models;

/*
    Implementa el patrón facade para creación de los coches según su tipo y alteración de la variable extra
        La variable extra según el tipo de coche:
            marchas - combustion
            autonomiaKm - electrico
            tanqueHidrogeno - hibrido

 */
public class CocheFacade {
    private Coche coche;

    public CocheFacade(){}

    /**
     * Crea un coche según su tipo
     * @param tipo String (Son aceptadas "combustion", "electrico" e "hibrido"
     * @param fabricante String
     * @param nombre String
     * @param color String
     * @param puertas int
     * @param extra int (numero de marchas, autonomiaKm o tanquehidrogeno,
     *                     a depender del tipo de coche a ser creado)
     * @return Coche
     * @throws CocheNotFoundException si el tipo de coche no existe
     */
    public Coche createCoche(String tipo, String fabricante, String nombre, String color, int puertas, int extra)
        throws CocheNotFoundException{

        switch (tipo){
            case "combustion":
                coche = new CocheCombustion(fabricante, nombre, color, puertas, extra);
                return coche;
            case "hibrido":
                coche = new CocheHibrido(fabricante, nombre, color, puertas, extra);
                return coche;
            case "electrico":
                coche = new CocheElectrico(fabricante, nombre, color, puertas, extra);
                return coche;
            default:
                throw new CocheNotFoundException();
        }
    }

    /**
     * Actualiza el valor de marchas, autonomiaKm o tanqueHidrogeno según la instancia del coche
     * @param coche
     * @param extra
     */
    public void setVarExtra(Coche coche, int extra){
        if (coche instanceof CocheCombustion)
            ((CocheCombustion) coche).setMarchas(extra);

        if (coche instanceof CocheElectrico)
            ((CocheElectrico) coche).setAutonomiaKM(extra);

        if (coche instanceof CocheHibrido)
            ((CocheHibrido) coche).setTanqueHidrogeno(extra);
    }
}
