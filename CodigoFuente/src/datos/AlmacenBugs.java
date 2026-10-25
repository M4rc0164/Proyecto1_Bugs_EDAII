package datos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import modelo.*;

public class AlmacenBugs {
    private List<Bug> listaBugs;
    private List<List<Bug>> tablaHash;
    private int capacidadHash;
    private int totalBugs;

    private static final int capacidadEstandar = 1024;

    /*
     * es el inverso del número áureo escalado al espacio de un int -> 2^32
     * se utiliza en hexadecimal para mantenerlo como int y que sea identificable
     */
    private static final int inversoAurea = 0x9E3779B9;

    public AlmacenBugs() {
        this.listaBugs = new ArrayList<>();
        this.tablaHash = new ArrayList<>();
        this.capacidadHash = capacidadEstandar;
        for (int i = 0; i < capacidadEstandar; i++) {
            this.tablaHash.add(new LinkedList<>());
        }
        this.totalBugs = 0;
    }

    public AlmacenBugs(int capacidad) {
        this.listaBugs = new ArrayList<>();
        this.tablaHash = new ArrayList<>();
        this.capacidadHash = capacidad;
        for (int i = 0; i < capacidad; i++) {
            this.tablaHash.add(new LinkedList<>());
        }
        this.totalBugs = 0;
    }

    private static int funcionHash(String idCompleto) {
        String id = idCompleto.substring(4); // Se obtiene la parte numérica del id
        int k = Integer.parseInt(id);
        int producto = k * inversoAurea;
        return (producto >>> 22);
    }

    public boolean agregarBug(Bug bug) {
        int indice = funcionHash(bug.getId());
        this.getListaBugs().add(bug);
        this.getTablaHash().get(indice).add(bug);
        this.setTotalBugs(this.getTotalBugs()+1);
        return true;
    }

    public List<Bug> getListaBugs() {
        return listaBugs;
    }

    public List<List<Bug>> getTablaHash() {
        return tablaHash;
    }

    public int getCapacidadHash() {
        return capacidadHash;
    }

    public int getTotalBugs() {
        return totalBugs;
    }

    public void setTotalBugs(int totalBugs) {
        this.totalBugs = totalBugs;
    }

    public int getCapacidadEstandar() {
        return capacidadEstandar;
    }

}
