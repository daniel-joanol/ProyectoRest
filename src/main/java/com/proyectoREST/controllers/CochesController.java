package com.proyectoREST.controllers;

import com.proyectoREST.models.Coche;
import com.proyectoREST.models.CocheNotFoundException;
import com.proyectoREST.services.CocheService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
    Aplicación REST para creación de coches a combustion, eléctricos e híbridos
        Implementa los métodos CRUD
        Produces JSON
 */
@Component
@Path("/")
public class CochesController {
    private final CocheService cocheService = new CocheService();
    private static final Logger LOGGER = Logger.getLogger("CocheFacadeLogs");

    public CochesController(CocheService cocheService){
        try{
            this.cocheService.createCoche("combustion", "ford", "escort", "azul", 2, 6);
            this.cocheService.createCoche("electrico", "tesla", "S", "negro", 4, 500);
            this.cocheService.createCoche("combustion", "peugeot", "206", "verde", 4, 7);
            this.cocheService.createCoche("hibrido", "hiunday", "kona", "gris", 4, 400);
            this.cocheService.createCoche("combustion", "chevrolet", "opala", "negro", 2, 8);
            this.cocheService.createCoche("electrico", "tesla", "tesla-Z", "amarillo", 4, 5);
        } catch (CocheNotFoundException e){
            LOGGER.log(Level.INFO, "Tipo de coche no encontrado" );
            e.printStackTrace();
        }

    }

    /**
     * Lee todos los coches
     * @return ArrayList<Coche>
     */
    @GET
    @Path("all")
    @Produces("Application/json")
    public ArrayList<Coche> readAllCoches(){
        return cocheService.readAllCoches();
    }

    /**
     * Filtra los coches por color
     * @param color String
     * @return ArrayList<Coche>
     */
    @GET
    @Path("filter/color/{color}")
    @Produces("Application/json")
    public ArrayList<Coche> filterColor(@PathParam("color") String color){
        return cocheService.filterColor(color);
    }

    /**
     * Filtra los coches por número de puertas
     * @param puertas int
     * @return ArrayList<Coche>
     */
    @GET
    @Path("filter/puertas/{puertas}")
    @Produces("Application/json")
    public ArrayList<Coche> filterPuerta(@PathParam("puertas") int puertas){
        return cocheService.filterPuerta(puertas);
    }

    /**
     * Filtra los coches por el nombre
     * @param nombre String
     * @return ArrayList<Coches>
     */
    @GET
    @Path("filter/nombre/{nombre}")
    @Produces("Application/json")
    public ArrayList<Coche> filterNombre(@PathParam("nombre") String nombre){
        return cocheService.filterNombre(nombre);
    }

    /**
     * Filtra los coches por tipo
     * @param tipo String (son aceptados "combustion", "electrico" e "hibrido")
     * @return ArrayList<Coche>
     */
    @GET
    @Path("filter/tipo/{tipo}")
    @Produces("Application/json")
    public ArrayList<Coche> filterTipo(@PathParam("tipo") String tipo){
        return cocheService.filterTipo(tipo);
    }

    /**
     * Remove el coche
     * @param nombre String
     * @return String "Coche 'nombre' removido" si el coche existe
     * @return String "Coche 'nombre' no encontrado" si el coche no existe
     */
    @DELETE
    @Path("{nombre}")
    @Produces("Application/json")
    public String deleteCoche(@PathParam("nombre") String nombre){
        if(cocheService.deleteCoche(nombre)){
            return "Coche " + nombre + " removido.";
        }else{
            return "Coche " + nombre + " no encontrado";
        }
    }

    /**
     * Actualiza el coche
     * @param nombre String nombre del coche a ser actualizado
     * @param color String nuevo color
     * @param puertas int nuevo numero de puertas
     * @param extra int (nuevo numero de marchas, autonomiaKm o tanquehidrogeno,
     *              a depender del tipo de coche a ser actualizado)
     * @return String "Coche actualizado" si el param nombre esta correcta
     * @return String "Coche no encontrado" si el param nombre no esta correcto
     */
    @PUT
    @Path("{nombre}/{color}/{puertas}/{extra}")
    @Produces("application/json")
    public String updateCoche(@PathParam("nombre") String nombre,
                              @PathParam("color") String color,
                              @PathParam("puertas") int puertas,
                              @PathParam("extra") int extra){
        if (cocheService.updateCoche(nombre, color, puertas, extra)){
            return "Coche actualizado";
        } return "Coche no encontrado";

    }

    /**
     * Crea un coche
     * @param tipo String (Son aceptadas "combustion", "electrico" e "hibrido"
     * @param fabricante String
     * @param nombre String
     * @param color String
     * @param puertas int
     * @param extra int (numero de marchas, autonomiaKm o tanquehidrogeno,
     *      *              a depender del tipo de coche a ser creado)
     * @return ResponseEntity<Coche> 200.OK si el tipo de coche existe
     * @return ResponseEntity 404.NOT_FOUND si el tipo de coche no existe
     */
    @POST
    @Path("{tipo}/{fabricante}/{nombre}/{color}/{puertas}/{extra}")
    @Produces("Application/json")
    public ResponseEntity createCoche(@PathParam("tipo") String tipo,
                                      @PathParam("fabricante") String fabricante,
                                      @PathParam("nombre") String nombre,
                                      @PathParam("color") String color,
                                      @PathParam("puertas") int puertas,
                                      @PathParam("marchas") int extra) {

        try{
            cocheService.createCoche(tipo, fabricante, nombre, color, puertas, extra);
            return new ResponseEntity<Coche>(cocheService.readCoche(), HttpStatus.OK);
        } catch (CocheNotFoundException e){
            // Crea logs en consola en caso de errores
            LOGGER.log(Level.INFO, "Tipo de coche no encontrado" );
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
