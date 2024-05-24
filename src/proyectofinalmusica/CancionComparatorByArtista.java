package proyectofinalmusica;

import java.util.Comparator;

class CancionComparatorByArtista implements Comparator<Cancion> {
    @Override
    public int compare(Cancion o1, Cancion o2) {
        return o1.consultarArtista().compareTo(o2.consultarArtista());
    }
}