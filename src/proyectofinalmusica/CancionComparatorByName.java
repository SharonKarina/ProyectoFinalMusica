package proyectofinalmusica;

import java.util.Comparator;

class CancionComparatorByName implements Comparator<Cancion> {
    @Override
    public int compare(Cancion o1, Cancion o2) {
        return o1.consultarTitulo().compareTo(o2.consultarTitulo());   
    }
}