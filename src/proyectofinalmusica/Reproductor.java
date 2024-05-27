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
        this.listaReproduccion.add(cancion);
        this.posicionActual = this.listaReproduccion.size() - 1;
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
    
    public boolean estaEnLista(Cancion cancion) {
        for(Cancion c : listaReproduccion){
            if(c.equals(cancion)){
                return true;
            }
        }
        return false;
    }
    
    public void eliminarDuplicados() {
        ArrayList<Cancion> listaSinDuplicados = new ArrayList<>();
        for(int i=0; i<listaReproduccion.size(); i++){
            Cancion c = listaReproduccion.get(i);
            if(!listaSinDuplicados.contains(c)){
                listaSinDuplicados.add(c);
            }
        }
        listaReproduccion = listaSinDuplicados;
    }
    
    public void agregarCancionLista(Cancion cancion) {   
        if(!estaEnLista(cancion)){
            listaReproduccion.add(cancion);
            System.out.println("La canción " + cancion.consultarTitulo() + " se ha agregado a la lista de reproducción.");
        }else{
            System.out.println("La canción " + cancion.consultarTitulo() + " ya se encuentra en la lista de reproducción.");
        }
    }
    
    public void eliminarCancionLista(Cancion cancion) {
        int indiceCancion = this.listaReproduccion.indexOf(cancion);
        this.listaReproduccion.remove(cancion);
        if (indiceCancion <= this.posicionActual) {
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
            System.out.println("---"+this.cancionActual.consultarTitulo()+"---");
            System.out.println("Artista: "+this.cancionActual.consultarArtista()+".");
            System.out.println("Album: "+this.cancionActual.consultarAlbum()+".");
            System.out.println("Genero: "+this.cancionActual.consultarGenero()+".");
            System.out.println("Reproducción reanudada");
        }else{
            System.out.println("La reprducción ya está en curso");
        }
    }

    public void avanzarReproduccion() {
        if(estaReproduciendo && this.posicionActual < this.listaReproduccion.size() - 1){
            this.posicionActual++;
            Cancion siguienteCancion = this.listaReproduccion.get(this.posicionActual);
            reproducirCancion(siguienteCancion);
        }else if(estaReproduciendo && this.posicionActual == this.listaReproduccion.size() - 1){
            this.posicionActual = 0;
            Cancion primeraCancion = this.listaReproduccion.get(this.posicionActual);
            reproducirCancion(primeraCancion);
        }else{
            System.out.println("No se puede avanzar, no hay más canciones en la lista.");
        }
    }

    public void retrocederReproduccion() {
        if(estaReproduciendo && this.posicionActual > 0){
            this.posicionActual--;
            reproducirCancion(this.listaReproduccion.get(this.posicionActual));
        }else{
            System.out.println("No se puede retroceder, ya está en la primera canción de la lista.");
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
    
    public void listaReproduccion(){
        if(listaReproduccion.isEmpty()){
            System.out.println("La lista de reproducción está vacía");
        }else{
            System.out.println("Canciones en la lista de reproducción:");
            for(int i = 0; i < listaReproduccion.size(); i++){
                Cancion cancion = listaReproduccion.get(i);
                System.out.println((i + 1) + ". " + cancion.consultarTitulo()+", "+cancion.consultarArtista()+", "+cancion.consultarAlbum()+", "+cancion.consultarGenero());
            }
        }
    }

    public Cancion getCancionActual() {
        return cancionActual;
    }
}