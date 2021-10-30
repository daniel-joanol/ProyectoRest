package com.proyectoREST.models;

//Implementa el patrón Factory para la creación de coches
public class CocheFactory {
    private CocheFacade cFacade = new CocheFacade();

    public CocheFactory(){}

    /**
     * Crea un coche
     * @param tipo String (Son aceptadas "combustion", "electrico" e "hibrido"
     * @param fabricante String
     * @param nombre String
     * @param color String
     * @param puertas int
     * @param extra int (numero de marchas, autonomiaKm o tanquehidrogeno,
     *                     a depender del tipo de coche a ser creado)
     * @return Coche
     * @throws CocheNotFoundException
     */
    public Coche createCoche(String tipo, String fabricante, String nombre, String color, int puertas, int extra)
            throws CocheNotFoundException{

        try {
            return cFacade.createCoche(tipo, fabricante, nombre, color, puertas, extra);
        } catch (CocheNotFoundException e) {
            throw new CocheNotFoundException();
        }
    }
}
