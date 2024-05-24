package proyectofinalmusica;

import java.util.Comparator;

public class Cancion {
    private String titulo;
    private String artista;
    private String album;
    private String genero;

    public Cancion(String titulo, String artista, String album, String genero) {
        this.titulo = titulo;
        this.artista = artista;
        this.album = album;
        this.genero = genero;
    }
    
    public String consultarTitulo(){
        return this.titulo;
    }
    
    public String consultarArtista(){
        return this.artista;
    }
    
    public String consultarAlbum(){
        return this.album;
    }
    
    public String consultarGenero(){
        return this.genero;
    }

    @Override
    public String toString() {
        return "Canci\u00f3n{" + "titulo=" + titulo + ", artista=" + artista + ", album=" + album + ", genero=" + genero + '}';
    } 
    
}