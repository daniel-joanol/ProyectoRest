package com.proyectoREST.services;

import com.proyectoREST.models.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CocheService {
    private final ArrayList<Coche> listCoches = new ArrayList<>();
    private CocheFactory cFactory = new CocheFactory();
    private CocheFacade cFacade = new CocheFacade();

    /**
     * Retorna el ultimo coche creado
     * @return Coche
     */
    public Coche readCoche(){
        return listCoches.get(listCoches.size()-1);
    }

    /**
     * Le todos los coches
     * @return ArrayList<Coche>
     */
    public ArrayList<Coche> readAllCoches(){
        return listCoches;
    }

    /**
     * Filtra los coches por color
     * @param color String
     * @return ArrayList<Coche>
     */
    public ArrayList<Coche> filterColor(String color){
        ArrayList<Coche> cochesPorColor = new ArrayList<>();
        for (Coche coche : listCoches){
            if (coche.getColor().equalsIgnoreCase(color))
                cochesPorColor.add(coche);
        }

        return cochesPorColor;
    }

    /**
     * Filtra los coches por número de puertas
     * @param puertas int
     * @return ArrayList<Coche>
     */
    public ArrayList<Coche> filterPuerta(int puertas){
        ArrayList<Coche> cochesPorPuerta = new ArrayList<>();
        for (Coche coche : listCoches){
            if (coche.getPuertas() == puertas)
                cochesPorPuerta.add(coche);
        }

        return cochesPorPuerta;
    }

    /**
     * Filtra los coches por el nombre
     * @param nombre String
     * @return ArrayList<Coches>
     */
    public ArrayList<Coche> filterNombre(String nombre){
        ArrayList<Coche> cochesPorNombre = new ArrayList<>();
        for (Coche coche : listCoches){
            if (coche.getNombre().equalsIgnoreCase(nombre))
                cochesPorNombre.add(coche);
        }

        return cochesPorNombre;
    }

    /**
     * Filtra los coches por tipo
     * @param tipo String (son aceptados "combustion", "electrico" e "hibrido")
     * @return ArrayList<Coche>
     */
    public ArrayList<Coche> filterTipo(String tipo){
        ArrayList<Coche> cochesPorTipo = new ArrayList<>();
        for (Coche coche : listCoches){
            if (coche.getTipo().equalsIgnoreCase(tipo))
                cochesPorTipo.add(coche);
        }

        return cochesPorTipo;
    }

    /**
     * Realiza una búsqueda en listCoches para borrarlo
     * @param nombre
     * @return true si el param nombre esta correcta
     * @return false si el param nombre esta incorrecto
     */
    public boolean deleteCoche(String nombre){
        for (int i = 0 ; i < listCoches.size() ; i++){
            if (listCoches.get(i).getNombre().equalsIgnoreCase(nombre)){
                listCoches.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Busca el coche por el nombre para actualizar sus atributos
     @param nombre String nombre del coche a ser actualizado
      * @param color String nuevo color
     * @param puertas int nuevo numero de puertas
     * @param extra int (nuevo numero de marchas, autonomiaKm o tanquehidrogeno,
     *              a depender del tipo de coche a ser actualizado)
     * @return true si el coche existe
     * @return false si el coche no existe
     */
    public boolean updateCoche(String nombre, String color, int puertas, int extra){
        for(int i = 0; i < listCoches.size(); i++){
            if (listCoches.get(i).getNombre().equalsIgnoreCase(nombre)){

                listCoches.get(i).setNombre(nombre);
                listCoches.get(i).setColor(color);
                listCoches.get(i).setPuertas(puertas);
                cFacade.setVarExtra(listCoches.get(i), extra);

                return true;
            }
        }
        return false;
    }

    /**
     * Crea un coche
     * @param tipo String (Son aceptadas "combustion", "electrico" e "hibrido"
     * @param fabricante String
     * @param nombre String
     * @param color String
     * @param puertas int
     * @param extra int (numero de marchas, autonomiaKm o tanquehidrogeno,
     *                    a depender del tipo de coche a ser creado)
     * @throws CocheNotFoundException
     */
    public void createCoche(String tipo, String fabricante, String nombre, String color, int puertas, int extra)
            throws CocheNotFoundException{

        try {
            listCoches.add( cFactory.createCoche(tipo, fabricante, nombre, color, puertas, extra));
        } catch (CocheNotFoundException e){
            throw new CocheNotFoundException("Tipo de coche no encontrado");
        }
    }
}
