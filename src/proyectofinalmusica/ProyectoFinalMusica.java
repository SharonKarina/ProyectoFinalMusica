package proyectofinalmusica;

import java.util.ArrayList;
import java.util.Scanner;
public class ProyectoFinalMusica {

    Scanner sc = new Scanner(System.in);
    private static Reproductor reproductor;
    private static Biblioteca biblioteca; 
    
    public static Reproductor getReproductor(){
       return reproductor; 
    }

    public static Biblioteca getBiblioteca() {
        return biblioteca;
    }
    
    public static void main(String[] args) {
        ProyectoFinalMusica obj = new ProyectoFinalMusica();
        reproductor = new Reproductor();
        biblioteca = new Biblioteca();
        int veces = 0;
        do{
            mostrarMenu();
            veces++;
        }while(veces != 0);
    }
    
    public static void mostrarMenu(){
        ProyectoFinalMusica obj = new ProyectoFinalMusica();
        System.out.println("---BIENVENIDO---");
        System.out.println("0. Salir");
        System.out.println("1. Reproducir");
        System.out.println("2. Biblioteca");
        System.out.println("3. Ajustar volumen");
        System.out.println("Seleccione una opción:");
        int opcion = Integer.parseInt(obj.sc.nextLine());
        ejecutarMenu(opcion);
    }
    
    public static void ejecutarMenu(int opc){
        switch(opc){
            case 0:
                System.exit(0);
                break;
            case 1:
                System.out.println("---REPRODUCIR---");
                reproducir();
                break;
            case 2:
                System.out.println("---BIBLIOTECA---");
                biblioteca();
                break;
            case 3:
                System.out.println("---AJUSTAR VOLUMEN---");
                ajustarVolumen();
                break;
            default:
                System.out.println("La opción no es valida");
        }
    }
    
    public static void reproducir(){
        ProyectoFinalMusica obj = new ProyectoFinalMusica();
        System.out.println("0. Salir");
        System.out.println("1. Reproducir");
        System.out.println("Seleccione una opción");
        int opc = Integer.parseInt(obj.sc.nextLine());
        ejecutarReproducir(opc);
    }
    
    public static void ejecutarReproducir(int opcion){
        ProyectoFinalMusica obj = new ProyectoFinalMusica();
        switch(opcion){
            case 0:
                System.exit(0);
                break;
            case 1:
                System.out.println("---REPRODUCIR---");
                reproducirCancion();
                break;
            default:
                System.out.println("La opción no es valida");       
        }
    }
        
    public static void reproduciendo(){
        ProyectoFinalMusica obj = new ProyectoFinalMusica();
        System.out.println("0. Salir");
        System.out.println("1. Pausar");
        System.out.println("2. Renaudar");
        System.out.println("3. Avanzar");
        System.out.println("4. Retroceder");
        System.out.println("5. Detener reproducción");
        System.out.println("6. Agregar canción");
        System.out.println("7. Eliminar canción");
        int opc = Integer.parseInt(obj.sc.nextLine());
        ejecutarReproduciendo(opc);
    }    
    
    public static void ejecutarReproduciendo(int opcion){
        switch(opcion){
            case 0:
                System.exit(0);
            case 1:
                System.out.println("---PAUSAR---");
                pausarReproduccion();
                break;
            case 2:
                System.out.println("---REANUDAR---");
                reanudarReproduccion();
                break;
            case 3:
                System.out.println("---AVANZAR---");
                avanzarReproduccion();
                break;
            case 4:
                System.out.println("---RETROCEDER---");
                retrocederReproduccion();
                break;
            case 5:
                System.out.println("---DETENER REPRODUCCION---");
                detenerReproduccion();
                break;
            case 6:
                System.out.println("---AGREGAR CANCION---");
                agregarCancionReproducir();
                break;
            case 7:
                System.out.println("---ELIMINAR CANCION---");
                eliminarCancionReproducir();
                break;
            default:
                System.out.println("La opción no es valida");
        }
    }
    
    public static void reproducirCancion(){
        ProyectoFinalMusica obj = new ProyectoFinalMusica();
        Biblioteca biblioteca = getBiblioteca();
        ArrayList<Cancion> listaCanciones = biblioteca.getCanciones();
        if(listaCanciones.size() > 0){
            System.out.println("Selecciona el número de la canción a reproducir:");
            for(int i = 0; i < listaCanciones.size(); i++){
                System.out.println((i + 1) + ". " + listaCanciones.get(i));
            }
            int opcion = Integer.parseInt(obj.sc.nextLine());
            Cancion cancionRepro = listaCanciones.get(opcion - 1);
            Reproductor reproductor = getReproductor();
            reproductor.reproducirCancion(cancionRepro);
            reproduciendo();
        }else{
            System.out.println("No hay canciones en la biblioteca.");
        }
    }
    
    
    public static void pausarReproduccion() {
        Cancion cancionActual = ProyectoFinalMusica.getReproductor().getCancionActual();
        Reproductor reproductor = getReproductor();
        if(cancionActual != null){
            reproductor.pausarReproduccion();
            reproduciendo();
        } else {
        System.out.println("No hay ninguna canción en reproducción.");
    }
}

    public static void reanudarReproduccion() {
        Reproductor reproductor = getReproductor();
        reproductor.reanudarReproduccion();
        reproduciendo();
    }
    
    public static void avanzarReproduccion() {
        Reproductor reproductor = getReproductor();
        reproductor.avanzarReproduccion();
        reproduciendo();
    }

    public static void retrocederReproduccion() {
        Reproductor reproductor = getReproductor();
        reproductor.retrocederReproduccion();
        reproduciendo();
    }
    
    public static void agregarCancionReproducir(){
        ProyectoFinalMusica obj = new ProyectoFinalMusica();
        System.out.println("¿Qué canción desea agregar a la lista de reproducción? (titulo-artista)");
        String datos = obj.sc.nextLine();
        String[] arregloDatos = datos.split("-");  
        String titulo = arregloDatos[0];
        String artista = arregloDatos[1];
        Biblioteca biblioteca = getBiblioteca();
        ArrayList<Cancion> cancionesE = biblioteca.buscarTitulo(titulo);
            for(int i = 0; i < cancionesE.size(); i++){
                Cancion cancion = cancionesE.get(i);
                if(cancion.consultarArtista().equals(artista)){
                    System.out.println((i + 1) + ". " + cancion);
                }
            }   
        System.out.println("Selecciona el número de la canción a agregar:");
        int opcion = Integer.parseInt(obj.sc.nextLine());
        Cancion cancionAgregar = cancionesE.get(opcion - 1);
        Reproductor reproductor = getReproductor();
        reproductor.agregarCancionLista(cancionAgregar);
        System.out.println("La canción " + cancionAgregar.consultarTitulo() + " se ha agregado a la lista de reproducción.");
        reproduciendo();
    }
    
    public static void eliminarCancionReproducir(){
        ProyectoFinalMusica obj = new ProyectoFinalMusica();
        System.out.println("¿Qué canción desea eliminar deq la lista de reproducción? (titulo-artista)");
        String datos = obj.sc.nextLine();
        String[] arregloDatos = datos.split("-");  
        String titulo = arregloDatos[0];
        String artista = arregloDatos[1];
        Biblioteca biblioteca = getBiblioteca();
        ArrayList<Cancion> cancionesE = biblioteca.buscarTitulo(titulo);
            for(int i = 0; i < cancionesE.size(); i++){
                Cancion cancion = cancionesE.get(i);
                if(cancion.consultarArtista().equals(artista)){
                    System.out.println((i + 1) + ". " + cancion);
                }
            }
        System.out.println("Selecciona el número de la canción a eliminar:");
        int opcion = Integer.parseInt(obj.sc.nextLine());
        Cancion cancionEliminar = cancionesE.get(opcion - 1);
        Reproductor reproductor = getReproductor();
        reproductor.eliminarCancionLista(cancionEliminar);
        System.out.println("La canción " + cancionEliminar.consultarTitulo() + " se ha eliminado a la lista de reproducción.");
        reproduciendo();
    }
    
    public static void detenerReproduccion(){
        Reproductor reproductor = getReproductor();
        reproductor.detenerReproduccion();
    }
    
    public static void biblioteca(){
        ProyectoFinalMusica obj = new ProyectoFinalMusica();
        System.out.println("0. Salir");
        System.out.println("1. Agregar canción");
        System.out.println("2. Ver canciones");
        System.out.println("3. Ordenar canciones");
        System.out.println("4. Buscar canciones");
        System.out.println("5. Eliminar cancion");
        System.out.println("6. Crear playlist");
        System.out.println("7. Ver playlist");
        System.out.println("8. Eliminar playlist");
        System.out.println("Seleccione una opción:");
        int opc = Integer.parseInt(obj.sc.nextLine());
        ejecutarBiblioteca(opc);
    }
    
    public static void ejecutarBiblioteca(int opcion){
        ProyectoFinalMusica obj = new ProyectoFinalMusica();
        switch(opcion){
            case 0:
                System.exit(0);
                break;
            case 1:
                System.out.println("---AGREGAR CANCIÓN---");
                agregarCancion();
                break;
            case 2:
                System.out.println("---VER CANCIONES---");
                verCanciones();
                break;
            case 3:
                System.out.println("---ORDENAR CANCIONES---");
                System.out.println("1. Ordenar por título");
                System.out.println("2. Ordenar por artista");
                System.out.println("3. Ordenar por álbum");
                System.out.println("4. Ordenar por género");
                System.out.println("Seleccione una opción:");
                int opc = Integer.parseInt(obj.sc.nextLine());
                ordenarCanciones(opc);
                break;
            case 4:
                System.out.println("---BUSCAR CANCIONES---");
                System.out.println("1. Buscar por título");
                System.out.println("2. Buscar por artista");
                System.out.println("3. Buscar por álbum");
                System.out.println("4. Buscar por género");
                System.out.println("Seleccione una opción:");
                int opci = Integer.parseInt(obj.sc.nextLine());
                buscarCanciones(opci);
                break;
            case 5:
                System.out.println("---ELIMINAR CANCION---");
                eliminarCancion();
                break;
            case 6:
                System.out.println("---CREAR PLAYLIST---");
                crearPlaylist();
                break;
            case 7:
                System.out.println("---VER PLAYLIST---");
                verPlaylist();
                break;
            case 8:
                System.out.println("---ELIMINAR PLAYLIST---");
                eliminarPlaylist();
                break;
            default:
                System.out.println("La opción no es valida");
        }
    }
    
    public static void agregarCancion(){
        ProyectoFinalMusica obj = new ProyectoFinalMusica();
        System.out.println("Ingrese los datos de la canción (Título-Artista-Albúm-Genero):");
        String datos = obj.sc.nextLine();
        String[] arregloDatos = datos.split("-");  
        String titulo = arregloDatos[0];
        String artista = arregloDatos[1];
        String album = arregloDatos[2];
        String genero = arregloDatos[3];
        Cancion cancion = new Cancion(titulo, artista, album, genero);
        Biblioteca biblioteca = getBiblioteca();
        biblioteca.agregarCancion(cancion);
    }
    
    public static void verCanciones(){
        Biblioteca biblioteca = getBiblioteca();
        ArrayList<Cancion> listaCanciones = biblioteca.getCanciones();
        if(listaCanciones.size() > 0){
            System.out.println("Canciones en la biblioteca:");
            for(int i = 0; i < listaCanciones.size(); i++){
                System.out.println((i + 1) + ". " + listaCanciones.get(i));
            }
        }else{
            System.out.println("No hay canciones en la biblioteca.");
        }
    }
    
    public static void ordenarCanciones(int opcion){
        switch(opcion){
            case 1:
                System.out.println("---ORDENAR POR TITULO---");
                ordenarTitulo();
                break;
            case 2:
                System.out.println("---ORDENAR POR ARTISTA---");
                ordenarArtista();
                break;
            case 3:
                System.out.println("---ORDENAR POR ALBUM---");
                ordenarAlbum();
                break;
            case 4:
                System.out.println("---ORDENAR POR GENERO---");
                ordenarGenero();
                break;
            default:
                System.out.println("La opción no es valida");
        }
    }
    
        public static void ordenarTitulo(){
            ProyectoFinalMusica obj = new ProyectoFinalMusica();
            Biblioteca biblioteca = getBiblioteca();
            ArrayList<Cancion> cancionesO = biblioteca.ordenarTitulo();
            biblioteca.listaCanciones();
        }
        
        public static void ordenarArtista(){
            ProyectoFinalMusica obj = new ProyectoFinalMusica();
            Biblioteca biblioteca = getBiblioteca();
            ArrayList<Cancion> cancionesO = biblioteca.ordenarArtista();
            biblioteca.listaCanciones();
        }
        
        public static void ordenarAlbum(){
            ProyectoFinalMusica obj = new ProyectoFinalMusica();
            Biblioteca biblioteca = getBiblioteca();
            ArrayList<Cancion> cancionesO = biblioteca.ordenarAlbum();
            biblioteca.listaCanciones();
        }
        
        public static void ordenarGenero(){
            ProyectoFinalMusica obj = new ProyectoFinalMusica();
            Biblioteca biblioteca = getBiblioteca();
            ArrayList<Cancion> cancionesO = biblioteca.ordenarGenero();
            biblioteca.listaCanciones();
        }
    
    public static void buscarCanciones(int opcion){
        ProyectoFinalMusica obj = new ProyectoFinalMusica();
        switch(opcion){
            case 1:
                System.out.println("---BUSCAR POR TITULO---");
                buscarTitulo();
                break;
            case 2:
                System.out.println("---BUSCAR POR ARTISTA---");
                buscarArtista();
                break;
            case 3:
                System.out.println("---BUSCAR POR ALBUM---");
                buscarAlbum();
                break;
            case 4:
                System.out.println("---BUSCAR POR GENERO---");
                buscarGenero();
                break;
            default:
                System.out.println("La opción no es valida");
        }
    }
    
    public static void menuBusqueda(Cancion cancion){
        ProyectoFinalMusica obj = new ProyectoFinalMusica();
        Biblioteca biblioteca = getBiblioteca();
        Reproductor reproductor = getReproductor();
        System.out.println("1. Reproducir");
        System.out.println("2. Agregar a playlist");
        System.out.println("3. Agregar a lista de reproducción");
        System.out.println("4. Eliminar");
        System.out.println("Seleccione una opción");
        int opc = Integer.parseInt(obj.sc.nextLine()); 
        switch(opc){
            case 1:
                System.out.println("---REPRODUCIR---");
                reproductor.reproducirCancion(cancion);
                reproduciendo();
                break;
            case 2:
                System.out.println("---AGREGAR A PLAYLIST---");
                biblioteca.listaPlaylist();
                System.out.println("¿A cual playlist desea agregarla?(nombre)");
                String nombre = obj.sc.nextLine();
                Playlist playlistE = biblioteca.buscarPlaylist(nombre);
                if(playlistE != null){
                    playlistE.agregarCancion(cancion);
                    System.out.println("La "+cancion.toString()+" se ha agregado a la playlist "+nombre);
                }else{
                    System.out.println("No se encontro la playlist "+nombre);
                }               
                break;
            case 3:
                System.out.println("---AGREGAR A REPRODUCCION---");
                reproductor.agregarCancionLista(cancion);
                System.out.println("La "+cancion.toString()+" se agrego a la lista de reproducción.");
                break;
            case 4:
                System.out.println("---ELIMINAR---");
                biblioteca.eliminarCancion(cancion);
                System.out.println("La "+cancion.toString()+" se elimino de la biblioteca.");
                break;
            default:
                System.out.println("La opcion no es valida");
        }
    }
    

        public static void buscarTitulo(){
            ProyectoFinalMusica obj = new ProyectoFinalMusica();
            System.out.println("Ingrese el título:");
            String titulo = obj.sc.nextLine();
            Biblioteca biblioteca = getBiblioteca();
            ArrayList<Cancion> cancionesE = biblioteca.buscarTitulo(titulo);
            if(cancionesE.size() > 0){
                System.out.println("Canciones encontradas:");
                for(int i = 0; i < cancionesE.size(); i++){
                    System.out.println((i + 1)+". "+cancionesE.get(i));
                }
                System.out.println("Elige una canción(numero): ");
                int opc = Integer.parseInt(obj.sc.nextLine());
                Cancion cancionR = cancionesE.get(opc-1);
                menuBusqueda(cancionR);
            }else{
                System.out.println("No se encontró ninguna canción con ese título.");
            }
        }
        
        public static void buscarArtista(){
            ProyectoFinalMusica obj = new ProyectoFinalMusica();
            System.out.println("Ingrese el artista:");
            String artista = obj.sc.nextLine();
            Biblioteca biblioteca = getBiblioteca();
            ArrayList<Cancion> cancionesE = biblioteca.buscarArtista(artista);
            if(cancionesE.size() > 0){
                System.out.println("Canciones encontradas:");
                for(int i = 0; i < cancionesE.size(); i++){
                    System.out.println((i + 1)+". "+cancionesE.get(i));
                }
                System.out.println("Elige una canción(numero): ");
                int opc = Integer.parseInt(obj.sc.nextLine());
                Cancion cancionR = cancionesE.get(opc-1);
                menuBusqueda(cancionR);
            }else{
                System.out.println("No se encontró ninguna canción con ese artista.");
            }
        }
        
        public static void buscarAlbum(){
            ProyectoFinalMusica obj = new ProyectoFinalMusica();
            System.out.println("Ingrese el album:");
            String album = obj.sc.nextLine();
            Biblioteca biblioteca = getBiblioteca();
            ArrayList<Cancion> cancionesE = biblioteca.buscarAlbum(album);
            if(cancionesE.size() > 0){
                System.out.println("Canciones encontradas:");
                for(int i = 0; i < cancionesE.size(); i++){
                    System.out.println((i + 1)+". "+cancionesE.get(i));
                }
                System.out.println("Elige una canción(numero): ");
                int opc = Integer.parseInt(obj.sc.nextLine());
                Cancion cancionR = cancionesE.get(opc-1);
                menuBusqueda(cancionR);
            }else{
                System.out.println("No se encontró ninguna canción con ese album.");
            }
        }
        
        public static void buscarGenero(){
            ProyectoFinalMusica obj = new ProyectoFinalMusica();
            System.out.println("Ingrese el genero:");
            String genero = obj.sc.nextLine();
            Biblioteca biblioteca = getBiblioteca();
            ArrayList<Cancion> cancionesE = biblioteca.buscarGenero(genero);
            if(cancionesE.size() > 0){
                System.out.println("Canciones encontradas:");
                for(int i = 0; i < cancionesE.size(); i++){
                    System.out.println((i + 1)+". "+cancionesE.get(i));
                }
                System.out.println("Elige una canción(numero): ");
                int opc = Integer.parseInt(obj.sc.nextLine());
                Cancion cancionR = cancionesE.get(opc-1);
                menuBusqueda(cancionR);
            }else{
                System.out.println("No se encontró ninguna canción con ese genero.");
            }
        }
    
    public static void eliminarCancion(){
        ProyectoFinalMusica obj = new ProyectoFinalMusica();
        System.out.println("¿Qué canción deseas eliminar?(titulo-artista)");
        String datos = obj.sc.nextLine();
        String[] arregloDatos = datos.split("-");
        String titulo = arregloDatos[0];
        String artista = arregloDatos[1];
        Biblioteca biblioteca = getBiblioteca();
        ArrayList<Cancion> cancionesE = biblioteca.buscarTitulo(titulo);
        if(cancionesE.size()>0){
            System.out.println("Canciones encontradas:");
                for(int i = 0; i < cancionesE.size(); i++){
                    Cancion cancion = cancionesE.get(i);
                    if(cancion.consultarArtista().equals(artista)){
                        System.out.println((i + 1)+". "+cancion);
                    }
                }
            System.out.println("Selecciona el número de la canción a eliminar:");
            int opc = Integer.parseInt(obj.sc.nextLine());
            Cancion cancionAEliminar = cancionesE.get(opc-1);
            biblioteca.eliminarCancion(cancionAEliminar);
            System.out.println("La canción"+ cancionAEliminar.toString()+"ha sido eliminada de la biblioteca.");
        }else{
            System.out.println("No se encontró ninguna canción con ese título y artista.");
        }   
    }
    
    public static void crearPlaylist(){
        ProyectoFinalMusica obj = new ProyectoFinalMusica();
        System.out.println("Ingrese nombre del Playlist:");
        String nombre = obj.sc.nextLine();
        Playlist playlist = new Playlist(nombre);
        Biblioteca biblioteca = getBiblioteca();
        biblioteca.crearPlaylist(playlist);
    }
    
    public static void verPlaylist(){
        ProyectoFinalMusica obj = new ProyectoFinalMusica();
        Biblioteca biblioteca = getBiblioteca();
        biblioteca.listaPlaylist();
        System.out.println("¿Cuál playlist desea ver?(nombre)");
        String nombre = obj.sc.nextLine();
        Playlist playlistS = biblioteca.buscarPlaylist(nombre);
        if(playlistS != null){
            if(playlistS.getCanciones().size()>0){
                playlistS.listaCanciones();
                ejecutarPlaylist(playlistS);
            }else{
                System.out.println("La playlist "+nombre+" no tiene canciones.");
                ejecutarPlaylist(playlistS);
            }
        }else{
            System.out.println("No se encontró la playlist '" + nombre + "'.");
        }
    }
    
    public static void ejecutarPlaylist(Playlist playlist){
        ProyectoFinalMusica obj = new ProyectoFinalMusica();
        System.out.println("Selecciona una opción:");
        System.out.println("0. Salir");
        System.out.println("1. Agregar canción");
        System.out.println("2. Eliminar canción");
        System.out.println("3. Reproducir playlist");
        int opcion = Integer.parseInt(obj.sc.nextLine());
        switch(opcion){
            case 0:
                System.exit(0);
                break;
            case 1:
                System.out.println("---AGREGAR CANCION---");
                agregarCancionPlaylist(playlist);
                break;
            case 2:
                System.out.println("---ELIMINAR CANCION---");
                eliminarCancionPlaylist(playlist);
                break;
            case 3:
                System.out.println("---REPRODUCIR PLAYLIST---");
                reproducirPlaylist(playlist);
                break;
            default:
                System.out.println("La opción no es valida");
        }
    }
    
    public static void agregarCancionPlaylist(Playlist playlist) {
        ProyectoFinalMusica obj = new ProyectoFinalMusica();
        System.out.println("Ingresa el título de la canción a agregar:");
        String titulo = obj.sc.nextLine();
        ArrayList<Cancion> cancionesB = getBiblioteca().buscarTitulo(titulo);
        if(cancionesB.size() > 0){
            Cancion cancion = cancionesB.get(0);
            playlist.agregarCancion(cancion);
            System.out.println("La " + cancion.toString() + " se ha agregado a la playlist.");
        }else{
            System.out.println("La canción con el título '" + titulo + "' no existe en la biblioteca.");
        }
    }

    public static void eliminarCancionPlaylist(Playlist playlist) {
        ProyectoFinalMusica obj = new ProyectoFinalMusica();
        playlist.listaCanciones();
        System.out.println("Selecciona el número de la canción a eliminar:");
        int opcion = Integer.parseInt(obj.sc.nextLine());
        Cancion cancion = playlist.getCanciones().get(opcion - 1);
        playlist.eliminarCancion(cancion);
        System.out.println("La canción "+ cancion.toString() +" se ha eliminado de la playlist.");
    }
    
    public static void reproducirPlaylist(Playlist playlist){
        Reproductor reproductor = getReproductor();
        ArrayList<Cancion> cancionesP = playlist.getCanciones();
        if(cancionesP.size() == 0){
            System.out.println("La playlist "+playlist.getNombre()+" no tiene canciones");
        }else{
            System.out.println("Reproduciendo la playlist: " + playlist.getNombre());
            for(int i=0; i<cancionesP.size();i++){
                Cancion cancion = cancionesP.get(i);
                reproductor.reproducirCancion(cancion);
                reproduciendo();
            }
        }
    }
    
    public static void eliminarPlaylist(){
        ProyectoFinalMusica obj = new ProyectoFinalMusica();
        System.out.println("¿Qué playlist deseas eliminar?(nombre)");
        String nombre = obj.sc.nextLine();
        Biblioteca biblioteca = getBiblioteca();
        Playlist playlistAEliminar = biblioteca.buscarPlaylist(nombre);
        if(playlistAEliminar != null){
            biblioteca.eliminarPlaylist(playlistAEliminar);
            System.out.println("La playlist '" + nombre + "' ha sido eliminada.");
        }else{
            System.out.println("No se encontró la playlist '" + nombre + "'.");
        }
    }
    
    public static void ajustarVolumen(){
        ProyectoFinalMusica obj = new ProyectoFinalMusica();
        System.out.println("¿Qué volumen desea?(1-100)");
        int volumenN = Integer.parseInt(obj.sc.nextLine());
        Reproductor reproductor = getReproductor();
        reproductor.ajustarVolumen(volumenN);
    }
}