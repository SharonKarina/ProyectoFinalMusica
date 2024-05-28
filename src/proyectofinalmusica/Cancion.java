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
    
    //devuelve el titulo de la cancion
    public String consultarTitulo(){
        return this.titulo;
    }
    
    //devuelve el artista de la cancion
    public String consultarArtista(){
        return this.artista;
    }
    
    //devuelve el album de la cancion
    public String consultarAlbum(){
        return this.album;
    }
    
    //devuelve el genero de la cancion
    public String consultarGenero(){
        return this.genero;
    }

    @Override
    public String toString() {
        return "Canci\u00f3n{" + "titulo=" + titulo + ", artista=" + artista + ", album=" + album + ", genero=" + genero + '}';
    } 
    
}