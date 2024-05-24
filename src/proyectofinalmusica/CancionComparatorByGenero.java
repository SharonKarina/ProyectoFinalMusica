package proyectofinalmusica;

import java.util.Comparator;

class CancionComparatorByGenero implements Comparator<Cancion> {
    @Override
    public int compare(Cancion o1, Cancion o2) {
        return o1.consultarGenero().compareTo(o2.consultarGenero());
    }
}