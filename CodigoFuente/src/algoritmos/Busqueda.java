package algoritmos;

import java.util.ArrayList;
import java.util.List;
import modelo.Bug;

public class Busqueda {
    //Compara los atributos buscados con cada objeto Bug de la lista del almacen
    public static List<Bug> busquedaCompuesta(TargetAux target, List<Bug> listaBugs){
        if (listaBugs == null || listaBugs.isEmpty() || target == null) {
            return new ArrayList<>(); // Lista vacía 
        }

        List<Bug> coincidencias = new ArrayList<>();
        
        for(int i = 0; i < listaBugs.size(); i++){
            if(target.comparador(listaBugs.get(i)))
                coincidencias.add(listaBugs.get(i));
        }

        return coincidencias;
    }

    public static List<Bug> busquedaTitulo(String titulo, List<Bug> listaBugs) {
        if (listaBugs == null || listaBugs.isEmpty() || titulo == null) {
            return new ArrayList<>(); // Lista vacía 
        }

        //Lower-bound
        int indiceL = lowerBound(titulo, listaBugs);
        //Upper-bound
        int indiceH = upperBound(titulo, listaBugs);

        if(indiceH - indiceL == 0) //Si no existen bugs en el rango, no hay bugs con ese titulo
            return new ArrayList<>();

        List<Bug> coincidencias = new ArrayList<>(indiceH - indiceL);

        for(int i = indiceL; i < indiceH; i++) {
            coincidencias.add(listaBugs.get(i));
        }
        return coincidencias;
    }

    protected static int lowerBound(String titulo, List<Bug> listaBugs) {
        int l = 0, r = (int)listaBugs.size(); 
        while(l < r) {
            int mid = l + (r-l)/2;
            if(listaBugs.get(mid).getTitulo().compareTo(titulo) < 0)
                l = mid + 1;
            else 
                r = mid;
        }
        return l;
    }

    protected static int upperBound(String titulo, List<Bug> listaBugs) {
        int l = 0, r = (int)listaBugs.size();
        while(l < r) {
            int mid = l + (r-l)/2;
            if(listaBugs.get(mid).getTitulo().compareTo(titulo) <= 0)
                l = mid + 1;
            else 
                r = mid;
        }
        return l;
    }
}