package proyectofinalmusica;

import java.util.ArrayList;

public class Playlist {
    private String nombre;
    private ArrayList<Cancion> canciones;

    public Playlist(String nombre) {
        this.nombre = nombre;
        this.canciones = new ArrayList<>();
    }
    
    public Playlist(String nombre, ArrayList<Cancion> canciones) {
        this.nombre = nombre;
        this.canciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
    }
    
    public void agregarCancion(Cancion cancion){
        canciones.add(cancion);
    }
    
    public void eliminarCancion(Cancion cancion){
        canciones.remove(cancion);
    }

    public void listaCanciones(){
        System.out.println("Canciones en " + this.nombre + ":");
            for (int i = 0; i < this.canciones.size(); i++) {
                System.out.println((i + 1) + ". " + this.canciones.get(i));
            }
    }
}