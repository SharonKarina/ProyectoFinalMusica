package proyectofinalmusica;

import java.util.ArrayList;

public class Reproductor {
    private ArrayList<Cancion> listaReproduccion;
    private Cancion cancionActual;
    private boolean estaReproduciendo;
    private int volumen;
    private int indiceActual;
    
    public Reproductor() {
        this.listaReproduccion = new ArrayList<>();
        this.volumen = 50;
        this.indiceActual = 0;
    }
    
    //Empieza la reproducción de la canción
    public void reproducirCancion(Cancion cancion){
        cancionActual = cancion;
        if(!estaEnLista(cancion)){
            this.listaReproduccion.add(cancion);
            this.indiceActual = this.listaReproduccion.size() - 1;
        }else{
            this.indiceActual = this.listaReproduccion.indexOf(cancion);
        }
        reproducirAudio(cancion);
        estaReproduciendo = true;
    }
    
    //Es el mensaje que se muestra al reproducir la cancion
    public void reproducirAudio(Cancion cancion) {
        System.out.println("---"+cancion.consultarTitulo()+"---");
        System.out.println("Artista: "+cancion.consultarArtista()+".");
        System.out.println("Album: "+cancion.consultarAlbum()+".");
        System.out.println("Genero: "+cancion.consultarGenero()+".");
        System.out.println("Reproduciendo audio de la canción.");
    }
    
    //revisa si la cancion ya esta en la lista
    public boolean estaEnLista(Cancion cancion) {
        for(int i = 0; i < listaReproduccion.size(); i++){
            Cancion c = listaReproduccion.get(i);
            if(c.equals(cancion)){
                return true;
            }
        }
        return false;
    }
    
    //elimina los duplicados de la lista de reproduccion
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
    
    //permite agregar una cancion a la lista de reproduccion
    public void agregarCancionLista(Cancion cancion) {   
        if(!estaEnLista(cancion)){
            listaReproduccion.add(cancion);
            System.out.println("La canción " + cancion.consultarTitulo() + " se ha agregado a la lista de reproducción.");
            eliminarDuplicados();
        }else{
            System.out.println("La canción " + cancion.consultarTitulo() + " ya se encuentra en la lista de reproducción.");
        }
    }
    
    //permite eliminar una cancion de la lista de reproduccion
    public void eliminarCancionLista(Cancion cancion) {
        int indiceCancion = this.listaReproduccion.indexOf(cancion);
    this.listaReproduccion.remove(cancion);

    // Actualizar el índice actual si la canción eliminada es anterior a la actual
    if (indiceCancion < this.indiceActual) {
        this.indiceActual--;
    } else if (indiceCancion == this.indiceActual) {
        // Si la canción eliminada es la actual, reproducir la siguiente canción
        if (this.indiceActual < this.listaReproduccion.size() - 1) {
            this.indiceActual++;
            Cancion siguienteCancion = this.listaReproduccion.get(this.indiceActual);
            reproducirCancion(siguienteCancion);
        } else {
            // Si no hay más canciones, detener la reproducción
            detenerReproduccion();
        }
    }
    }
    
    //pausa la reproduccion de la cancion
    public void pausarReproduccion() {
        if(estaReproduciendo){
            estaReproduciendo = false;
            System.out.println("---"+this.cancionActual.consultarTitulo()+"---");
            System.out.println("Artista: "+this.cancionActual.consultarArtista()+".");
            System.out.println("Album: "+this.cancionActual.consultarAlbum()+".");
            System.out.println("Genero: "+this.cancionActual.consultarGenero()+".");
            System.out.println("Reproducción pausada");
        }else{
            System.out.println("La reproducción ya esta pausada");
        }
    }

    //reanuda la reproduccion de la cancion
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

    //permite avanzar de cancion
    public void avanzarReproduccion() {
        if(estaReproduciendo && !listaReproduccion.isEmpty()){
            if(this.indiceActual < this.listaReproduccion.size() - 1){
                this.indiceActual++;
                cancionActual = this.listaReproduccion.get(this.indiceActual);
                reproducirAudio(cancionActual);
            }else{
                System.out.println("No se puede avanzar, ya está reproduciendo la última canción de la lista.");
            }
        }else{
            System.out.println("No se puede avanzar, no hay más canciones en la lista.");
        }
    }

    //permite retroceder de cancion
    public void retrocederReproduccion(){
        if(estaReproduciendo && !listaReproduccion.isEmpty()){
            if(this.indiceActual > 0){
                this.indiceActual--;
                cancionActual = this.listaReproduccion.get(this.indiceActual);
                reproducirAudio(cancionActual);
            }else{
                System.out.println("No se puede retroceder, ya está reproduciendo la primera canción de la lista.");
            }
        }else{
            System.out.println("No se puede retroceder, no hay más canciones en la lista.");
        }
    }

    //ajusta el volumen de la reproduccion
    public void ajustarVolumen(int nuevoVolumen) {
        volumen = Math.max(0, Math.min(nuevoVolumen, 100));
        System.out.println("Volumen ajustado al " + volumen + "%");
    }

    //detiene la reproduccion
    public void detenerReproduccion() {
        if (estaReproduciendo) {
            estaReproduciendo = false;
            System.out.println("La reproduccion de la cancion se detuvo.");
        }
    }
    
    //muestra las canciones en la lista de reproducccion
    public void listaReproduccion(){
        eliminarDuplicados();
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