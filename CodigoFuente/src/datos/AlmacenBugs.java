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
    private int desplazamientoBits;
    private static final int capacidadEstandar = 1024;

    /*
     * es el inverso del número áureo escalado al espacio de un int -> 2^32
     * se utiliza en hexadecimal para mantenerlo como int y que sea identificable
     */
    private static final int inversoAurea = 0x9E3779B9;

    public AlmacenBugs() {
        this.listaBugs = new ArrayList<>(capacidadEstandar);
        this.tablaHash = new ArrayList<>();
        this.capacidadHash = capacidadEstandar;
        this.desplazamientoBits = 22;
        for (int i = 0; i < capacidadEstandar; i++) {
            this.tablaHash.add(new LinkedList<>());
        }
        this.totalBugs = 0;
    }

    public AlmacenBugs(int capacidad) {
        this.listaBugs = new ArrayList<>(capacidad);
        this.tablaHash = new ArrayList<>();
        this.capacidadHash = capacidad;
        desplazamientoBits = 32 - (31 - Integer.numberOfLeadingZeros(capacidad));
        for (int i = 0; i < capacidad; i++) {
            this.tablaHash.add(new LinkedList<>());
        }
        this.totalBugs = 0;
    }

    private int funcionHash(String idCompleto) {
        String id = idCompleto.replace("BUG-", ""); // Se obtiene la parte numérica del id
        int k = Integer.parseInt(id);
        int producto = k * inversoAurea;
        return (producto >>> this.getDesplazamientoBits());
    }

    public boolean agregarBug(Bug bug) {
        if (bug == null) {
            return false;
        }
        int indice = funcionHash(bug.getId());
        for (Bug b : this.getTablaHash().get(indice)) {
            if (b.getId().equals(bug.getId())) {
                return false;
            }
        }
        this.getListaBugs().add(bug);
        this.getTablaHash().get(indice).add(bug);
        this.setTotalBugs(this.getTotalBugs() + 1);
        return true;
    }

    public boolean eliminarBugId(String id) {
        if (id == null || !id.matches("BUG-(\\d{1,9}|1\\d{9})")) {
            return false; 
        }
        Bug bugAEliminar = null;
        int indice = this.funcionHash(id);
        for (Bug bug : this.getTablaHash().get(indice)) {
            if (bug.getId().equals(id)) {
                bugAEliminar = bug;
                break;
            }
        }
        if (bugAEliminar == null) {
            return false;
        }
        this.getTablaHash().get(indice).remove(bugAEliminar);
        this.getListaBugs().remove(bugAEliminar);
        this.setTotalBugs(this.getTotalBugs() - 1);
        return true;
    }

    public Bug buscarId(String id){
        if (id == null || !id.matches("BUG-(\\d{1,9}|1\\d{9})")) {
            return null; 
        }
        int indice = funcionHash(id);
        for (Bug bug : this.getTablaHash().get(indice)) {
            if (bug.getId().equals(id)) {
                return bug;
            }
        }
        return null;
    }

    public void poblarInicial(int cantidad){
        while (this.getTotalBugs() < cantidad) {
            this.agregarBug(GeneradorBugs.generarBug());
        }
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

    public int getDesplazamientoBits() {
        return desplazamientoBits;
    }

}
