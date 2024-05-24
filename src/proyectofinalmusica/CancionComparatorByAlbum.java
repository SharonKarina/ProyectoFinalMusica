package proyectofinalmusica;

import java.util.Comparator;

class CancionComparatorByAlbum implements Comparator<Cancion> {
    @Override
    public int compare(Cancion o1, Cancion o2) {
        return o1.consultarAlbum().compareTo(o2.consultarAlbum());
    }
}