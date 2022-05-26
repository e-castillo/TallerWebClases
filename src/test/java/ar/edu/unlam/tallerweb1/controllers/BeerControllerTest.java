package ar.edu.unlam.tallerweb1.controllers;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class BeerControllerTest {

    private BeerController beerController;

    @Test
    public void alPedirTodasLasCervezasDevuelveLaListaCompleta(){
        //preparación
        dadoQueExistenCervezas(10, "IPA");

        //ejecución
        ModelAndView mav = beerController.listar("IPA");

        //validación
        entoncesEncuentro((List<Cerveza>) mav.getModel().get("cervezas"), 10);
        entoncesMeLlevaALaVista("listado-cerveza", mav.getViewName());
    }

    @Test
    public void alPedirUnTipoInvalidoLlevaAPantallaDeError() {
        dadoQueExistenCervezas(10, "IPA");

        ModelAndView mav = beerController.listar("Scotch");

        entoncesMeLlevaALaVista("listado-cerveza", mav.getViewName());
        entoncesSeRecibeMensaje("tipo inexistente", mav.getModel());

    }

    private void entoncesSeRecibeMensaje(String mensaje, Map<String, Object> model) {
        assertThat(model.get("msg-error")).isEqualTo(mensaje);
    }

    private void entoncesMeLlevaALaVista(String vistaEsperada, String vistaRecibida) {
        assertThat(vistaRecibida).isEqualTo(vistaEsperada);
    }

    private void entoncesEncuentro(List<Cerveza> listaCervezas, int cantidadEsperada) {
        assertThat(listaCervezas).hasSize(cantidadEsperada);
    }

    private void dadoQueExistenCervezas(int cantidadExistente, String tipo) {
        beerController = new BeerController(cantidadExistente, tipo);
    }
}
