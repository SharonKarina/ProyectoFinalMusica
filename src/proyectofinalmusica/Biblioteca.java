package proyectofinalmusica;

import java.util.ArrayList;
import java.util.Collections;

public class Biblioteca {
    private ArrayList<Cancion> canciones;
    private ArrayList<Playlist> playlist;

    public Biblioteca() {
        this.canciones = new ArrayList<>();
        this.playlist = new ArrayList<>();
    }
    
    public void agregarCancion(Cancion cancion){
        canciones.add(cancion);
    }
    
    public void eliminarCancion(Cancion cancion){
        canciones.remove(cancion);
    }
    
    public void crearPlaylist(Playlist playlistN){
        playlist.add(playlistN);
    }
    
    public void eliminarPlaylist(Playlist playlistN){
        playlist.remove(playlistN);
    }
    
    public ArrayList<Cancion> buscarTitulo(String titulo){
        ArrayList<Cancion> cancionesE = new ArrayList<>();
        for(int i=0; i< this.canciones.size(); i++){
            if(this.canciones.get(i).consultarTitulo().equals(titulo)){
                cancionesE.add(this.canciones.get(i));
            }
        }
        return cancionesE;
    }
    
    public ArrayList<Cancion> buscarArtista(String artista){
        ArrayList<Cancion> cancionesE = new ArrayList<>();
        for(int i=0; i< this.canciones.size(); i++){
            if(this.canciones.get(i).consultarArtista().equals(artista)){
                cancionesE.add(this.canciones.get(i));
            }
        }
        return cancionesE;
    }
    
    public ArrayList<Cancion> buscarAlbum(String album){
        ArrayList<Cancion> cancionesE = new ArrayList<>();
        for(int i=0; i< this.canciones.size(); i++){
            if(this.canciones.get(i).consultarAlbum().equals(album)){
                cancionesE.add(this.canciones.get(i));
            }
        }
        return cancionesE;
    }
    
    public ArrayList<Cancion> buscarGenero(String genero){
        ArrayList<Cancion> cancionesE = new ArrayList<>();
        for(int i=0; i< this.canciones.size(); i++){
            if(this.canciones.get(i).consultarGenero().equals(genero)){
                cancionesE.add(this.canciones.get(i));
            }
        }
        return cancionesE;
    }
    
    public Playlist buscarPlaylist(String nombre){
        for(int i=0; i< this.playlist.size(); i++){
            if(this.playlist.get(i).getNombre().equals(nombre)){
                return this.playlist.get(i);
            }
        }
        return null;
    }
    
    public ArrayList<Cancion> ordenarTitulo(){
        ArrayList<Cancion> canciones = getCanciones();
        Collections.sort(canciones,new CancionComparatorByName());
        return canciones;
    }
    
    public ArrayList<Cancion> ordenarArtista(){
        ArrayList<Cancion> canciones = getCanciones();
        Collections.sort(canciones,new CancionComparatorByArtista());
        return canciones;
    }
    
    public ArrayList<Cancion> ordenarAlbum(){
        ArrayList<Cancion> canciones = getCanciones();
        Collections.sort(canciones,new CancionComparatorByAlbum());
        return canciones;
    }
    
    public ArrayList<Cancion> ordenarGenero(){
        ArrayList<Cancion> canciones = getCanciones();
        Collections.sort(canciones,new CancionComparatorByGenero());
        return canciones;
    }
    
    public void listaCanciones(){
        ArrayList<Cancion> canciones = getCanciones();
        if(canciones.size() > 0){
        System.out.println("Canciones en la biblioteca:");
        for(int i = 0; i < canciones.size(); i++){
            System.out.println((i + 1) + ". " + canciones.get(i));
        }
        }else{
            System.out.println("No hay canciones en la biblioteca.");
        }
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
        }
    
    public void listaPlaylist(){
        ArrayList<Playlist> playlist = getPlaylist();
        if(playlist.size() > 0){
        System.out.println("Playlist en la biblioteca:");
        for(int i = 0; i < playlist.size(); i++){
            System.out.println((i + 1) + ". " + playlist.get(i));
        }
        }else{
            System.out.println("No hay playlist en la biblioteca.");
        }
    }
    
    public ArrayList<Playlist> getPlaylist() {
        return playlist;
        }
}