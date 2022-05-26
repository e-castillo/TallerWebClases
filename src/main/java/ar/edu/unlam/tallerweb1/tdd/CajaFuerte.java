package ar.edu.unlam.tallerweb1.tdd;

public class CajaFuerte {

    private Integer claveDeApertura;
    private Boolean estaAbierta;
    private Integer intentos;


    public CajaFuerte(){
        estaAbierta = true;
        intentos = 0;
    }

    public void cerrarCon(Integer clave) {
        claveDeApertura = clave;
        estaAbierta = false;
    }

    public void abrirCon(Integer clave) {
        if (clave.equals(claveDeApertura)){
            estaAbierta = true;
            intentos=0;
        } else {
            intentos++;
        }
    }

    public boolean estaAbierta() {
        return estaAbierta;
    }

    public boolean estaBloqueada() {
        return intentos >= 3;
    }
}
