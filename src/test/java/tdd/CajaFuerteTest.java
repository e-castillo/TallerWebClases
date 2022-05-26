package tdd;

import ar.edu.unlam.tallerweb1.tdd.CajaFuerte;
import org.junit.Test;
import org.springframework.test.context.TestExecutionListeners;

import static org.assertj.core.api.Assertions.*;


// 1 - No escribir código productivo sin que haya un test que falle antes.
// 2 - escribir el menor código posible para que el test sea exitoso.
// 3 - Mejorar el código hecho.

public class CajaFuerteTest {

    Integer clave = 4657;
    Integer claveIncorrecta = 4351;
    CajaFuerte cajaFuerte = new CajaFuerte();

    @Test
    public void alAbrirConClaveCorrectaDeberiaAbrirse(){
        //preparación
        cajaFuerte.cerrarCon(clave);

        //ejecución
        cajaFuerte.abrirCon(clave);

        //validación
        entoncesEstaAbiertaLa(cajaFuerte);
    }

    @Test
    public void AlAbrirConClaveIncorrectaNoDebeAbrirse(){
        //preparación
        cajaFuerte.cerrarCon(clave);

        //ejecución
        cajaFuerte.abrirCon(claveIncorrecta);

        //validación
        entoncesEstaCerradaLa(cajaFuerte);
    }

    @Test
    public void QueAlCrearLaCajaFuerteDebeEstarAbierta(){
        //validación
        entoncesEstaAbiertaLa(cajaFuerte);
    }

    @Test
    public void alCerrarUnaCajaFuerteDebeQuedarCerrada(){
        //ejecución
        cajaFuerte.cerrarCon(clave);
        //validación
        entoncesEstaCerradaLa(cajaFuerte);
    }

    @Test
    public void alCambiarDeClaveDebeAbrirseConLaClaveNueva(){
        cajaFuerte.cerrarCon(clave);
        cajaFuerte.abrirCon(clave);

        Integer claveNueva = 0013;

        cajaFuerte.cerrarCon(claveNueva);
        cajaFuerte.abrirCon(claveNueva);

        entoncesEstaAbiertaLa(cajaFuerte);

    }

    @Test
    public void seBloqueaLaCajaFuerteDespuesDeTresIntentosIncorrectos(){
        cajaFuerte.cerrarCon(clave);

        cajaFuerte.abrirCon(claveIncorrecta);
        cajaFuerte.abrirCon(claveIncorrecta);
        cajaFuerte.abrirCon(claveIncorrecta);

        entoncesEstaBloqueadaLa(cajaFuerte);

    }

    @Test
    public void luegoDeAperturaExitosaSeReinicianLosIntentos(){
        cajaFuerte.cerrarCon(clave);

        cajaFuerte.abrirCon(claveIncorrecta);
        cajaFuerte.abrirCon(claveIncorrecta);
        cajaFuerte.abrirCon(clave);

        cajaFuerte.cerrarCon(clave);
        cajaFuerte.abrirCon(claveIncorrecta);

        entoncesNoEstaBloqueadaLa(cajaFuerte);
    }

    private void entoncesEstaBloqueadaLa(CajaFuerte cajaFuerte) {
        assertThat(cajaFuerte.estaBloqueada()).isTrue();
    }


    private void entoncesNoEstaBloqueadaLa(CajaFuerte cajaFuerte) {
        assertThat(cajaFuerte.estaBloqueada()).isFalse();
    }


    private void entoncesEstaCerradaLa(CajaFuerte cajaFuerte) {
        assertThat(cajaFuerte.estaAbierta()).isFalse();
    }

    private void entoncesEstaAbiertaLa(CajaFuerte cajaFuerte) {
        assertThat(cajaFuerte.estaAbierta()).isTrue();
    }


}
