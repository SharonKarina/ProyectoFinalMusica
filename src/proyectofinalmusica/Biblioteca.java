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
    
    //permite agregar una canción a la lsita de canciones
    public void agregarCancion(Cancion cancion){
        canciones.add(cancion);
        System.out.println("La "+cancion.toString()+" fue agregada con exito.");
    }
    
    //permite eliminar una cancion de la lsita de canciones
    public void eliminarCancion(Cancion cancion){
        canciones.remove(cancion);
    }
    
    //permite que el usuario cree una playlist
    public void crearPlaylist(Playlist playlistN){
        playlist.add(playlistN);
    }
    
    //permite que el ususario elimine una playlist
    public void eliminarPlaylist(Playlist playlistN){
        playlist.remove(playlistN);
    }
    
    
    //permite al usuario buscar alguna cancion por el titulo
    public ArrayList<Cancion> buscarTitulo(String titulo){
        ArrayList<Cancion> cancionesE = new ArrayList<>();
        for(int i=0; i< this.canciones.size(); i++){
            if(this.canciones.get(i).consultarTitulo().equals(titulo.toLowerCase())){
            cancionesE.add(this.canciones.get(i));
            }
        }
        return cancionesE;
    }
    
    //permite al usuario buscar alguna cancion por el artista
    public ArrayList<Cancion> buscarArtista(String artista){
        ArrayList<Cancion> cancionesE = new ArrayList<>();
        for(int i=0; i< this.canciones.size(); i++){
            if(this.canciones.get(i).consultarArtista().equals(artista.toLowerCase())){
                cancionesE.add(this.canciones.get(i));
            }
        }
        return cancionesE;
    }
    
    //permite al usuario buscar alguna cancion por el album
    public ArrayList<Cancion> buscarAlbum(String album){
        ArrayList<Cancion> cancionesE = new ArrayList<>();
        for(int i=0; i< this.canciones.size(); i++){
            if(this.canciones.get(i).consultarAlbum().equals(album.toLowerCase())){
                cancionesE.add(this.canciones.get(i));
            }
        }
        return cancionesE;
    }
    
    //permite al usuario buscar alguna cancion por el genero
    public ArrayList<Cancion> buscarGenero(String genero){
        ArrayList<Cancion> cancionesE = new ArrayList<>();
        for(int i=0; i< this.canciones.size(); i++){
            if(this.canciones.get(i).consultarGenero().equals(genero.toLowerCase())){
                cancionesE.add(this.canciones.get(i));
            }
        }
        return cancionesE;
    }
    
    //permite al usuario buscar alguna playlist por el nombre
    public Playlist buscarPlaylist(String nombre){
        for(int i=0; i< this.playlist.size(); i++){
            if(this.playlist.get(i).getNombre().equals(nombre.toLowerCase())){
                return this.playlist.get(i);
            }
        }
        return null;
    }
    
    //permite al usuario ordenar las canciones por el titulo
    public ArrayList<Cancion> ordenarTitulo(){
        ArrayList<Cancion> canciones = getCanciones();
        Collections.sort(canciones,new CancionComparatorByName());
        return canciones;
    }
    
    //permite al usuario ordenar las canciones por el artista
    public ArrayList<Cancion> ordenarArtista(){
        ArrayList<Cancion> canciones = getCanciones();
        Collections.sort(canciones,new CancionComparatorByArtista());
        return canciones;
    }
    
    //permite al usuario ordenar las canciones por el album
    public ArrayList<Cancion> ordenarAlbum(){
        ArrayList<Cancion> canciones = getCanciones();
        Collections.sort(canciones,new CancionComparatorByAlbum());
        return canciones;
    }
    
    //permite al usuario ordenar las canciones por el genero
    public ArrayList<Cancion> ordenarGenero(){
        ArrayList<Cancion> canciones = getCanciones();
        Collections.sort(canciones,new CancionComparatorByGenero());
        return canciones;
    }
    
    //muestra una lista de las canciones en la biblioteca
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
    
    //muestra una lista de las playlist en la biblioteca
    public void listaPlaylist(){
        ArrayList<Playlist> playlist = getPlaylist();
        if(playlist.size() > 0){
            System.out.println("Playlist en la biblioteca:");
            for(int i = 0; i < playlist.size(); i++){
                System.out.println((i + 1) + ". " + playlist.get(i).getNombre());
            }
        }else{
            System.out.println("No hay playlist en la biblioteca.");
        }
    }
    
    public ArrayList<Playlist> getPlaylist() {
        return playlist;
        }
}