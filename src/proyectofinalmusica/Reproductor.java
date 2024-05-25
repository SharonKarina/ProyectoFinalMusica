package proyectofinalmusica;

import java.util.ArrayList;

public class Reproductor {
    private ArrayList<Cancion> listaReproduccion;
    private Cancion cancionActual;
    private boolean estaReproduciendo;
    private int volumen;
    private int posicionActual;
    
    public Reproductor() {
        this.listaReproduccion = new ArrayList<>();
        this.volumen = 50;
        this.posicionActual = -1;
    }
    
    public void reproducirCancion(Cancion cancion){
        cancionActual = cancion;
        this.listaReproduccion = new ArrayList<>();
        this.listaReproduccion.add(cancion);
        this.posicionActual = 0;
        reproducirAudio(cancion);
        estaReproduciendo = true;
    }
    
    public void reproducirAudio(Cancion cancion) {
        System.out.println("---"+cancion.consultarTitulo()+"---");
        System.out.println("Artista: "+cancion.consultarArtista()+".");
        System.out.println("Album: "+cancion.consultarAlbum()+".");
        System.out.println("Genero: "+cancion.consultarGenero()+".");
        System.out.println("Reproduciendo audio de la canción.");
    }
    
    public void agregarCancionLista(Cancion cancion) {
        this.listaReproduccion.add(cancion);
    }
    
    public void eliminarCancionLista(Cancion cancion) {
        this.listaReproduccion.remove(cancion);
        if(this.posicionActual>0){
            this.posicionActual--;
        }
    }
    
    public void pausarReproduccion() {
        if(estaReproduciendo){
            estaReproduciendo = false;
            System.out.println("---"+this.cancionActual.consultarTitulo()+"---");
            System.out.println("Artista: "+this.cancionActual.consultarArtista()+".");
            System.out.println("Album: "+this.cancionActual.consultarAlbum()+".");
            System.out.println("Genero: "+this.cancionActual.consultarGenero()+".");
            System.out.println("Reproducción pausada");
        }
    }

    public void reanudarReproduccion() {
        if(!estaReproduciendo){
            estaReproduciendo = true;
            System.out.println("Reproducción reanudada");
        }else{
            System.out.println("La reprducción ya está en curso");
        }
    }

    public void avanzarReproduccion() {
        if(estaReproduciendo && this.posicionActual < this.listaReproduccion.size() - 1){
            this.posicionActual++;
            reproducirCancion(this.listaReproduccion.get(this.posicionActual));
        }else{
            System.out.println("No se puede avanzar, no hay más canciones en la lista.");
        }
    }

    public void retrocederReproduccion() {
        if (estaReproduciendo && this.posicionActual > 0) {
            this.posicionActual--;
            reproducirCancion(this.listaReproduccion.get(this.posicionActual));
        } else {
            System.out.println("No se puede retroceder, no hay canciones antes.");
        }
    }

    public void ajustarVolumen(int nuevoVolumen) {
        volumen = Math.max(0, Math.min(nuevoVolumen, 100));
        System.out.println("Volumen ajustado al " + volumen + "%");
    }

    public void detenerReproduccion() {
        if (estaReproduciendo) {
            estaReproduciendo = false;
            System.out.println("La reproduccion de la cancion se detuvo.");
        }
    }

    public Cancion getCancionActual() {
        return cancionActual;
    }
}