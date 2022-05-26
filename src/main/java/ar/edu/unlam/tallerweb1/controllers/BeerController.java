package ar.edu.unlam.tallerweb1.controllers;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

//Cada acción de un controlador debe ser capaz de escuchar peticiones HTTP.
//Devuelve o no información y redirecciona a otra parte de la aplicación.
// el tipo de retorno de una acción tiene datos + vista


public class BeerController {
    //TO DO Solo para explicación de controladores, después hay que eliminarlo!

    private List<Cerveza> listaCerveza = new LinkedList<>();

    public BeerController(int cantidadExistente, String tipo){
        for (int i = 0; i<cantidadExistente; i++){
            listaCerveza.add(new Cerveza(tipo));
        }
    }

    //TO DO Solo para explicación de controladores, después hay que eliminarlo!
    public ModelAndView listar(String tipo) {
        ModelMap model = new ModelMap();
        List<Cerveza> resultado = new LinkedList<>();
        for(Cerveza each: listaCerveza){
            if(each.getTipo().equals(tipo)){
                resultado.add(each);
            }
        }
        if (resultado.isEmpty()){
            model.put("msg-error", "tipo inexistente");
        } else{
            model.put("cervezas", resultado);
        }

        model.put("cervezas", resultado);

        ModelAndView modelAndView = new ModelAndView("listado-cerveza", model);



        return modelAndView;

    }

}
